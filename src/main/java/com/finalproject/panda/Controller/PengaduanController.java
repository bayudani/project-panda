package com.finalproject.panda.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalproject.panda.Service.PengaduanService;
import com.finalproject.panda.Service.UserService;
import com.finalproject.panda.model.Pengaduan;
import com.finalproject.panda.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/panda")
public class PengaduanController {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private PengaduanService pengaduanService;

    // get form pengaduan
    @GetMapping("/pengaduan")
    public String formPengaduan(Model model, User user, HttpSession session) {
        try {
            Pengaduan pengaduan = new Pengaduan();
            User loggedInUser = (User) session.getAttribute("loggedInUser");
            if (loggedInUser != null) {
                log.info(loggedInUser.getNama_lengkap() +" disini");
                model.addAttribute("pengaduan", pengaduan);
                model.addAttribute("loggedInUser", loggedInUser);
                return "PengaduanPage";
            } else {
                return "redirect:/panda/login";
            }
        } catch (Exception e) {
            return "error"; 
        }
    }

    // set pengaduan ke db
    @PostMapping("/pengaduan")
    public String savePengaduan(Model model, Pengaduan pengaduan) {
        try {
            pengaduanService.savePengaduan(pengaduan);
            model.addAttribute("pengaduan", pengaduan);
        } catch (Exception e) {
            
        }
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deletePengaduan(@RequestParam("id_registrasi") Integer id_registrasi) {
        pengaduanService.deletePengaduan(id_registrasi);
        return "redirect:/";
    }
}
