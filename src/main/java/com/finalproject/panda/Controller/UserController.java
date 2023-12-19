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

import com.finalproject.panda.Service.UserService;
import com.finalproject.panda.model.User;

@Controller
@RequestMapping("/panda")
public class UserController {

    @Autowired
    private UserService userService;

        private static final Logger log = LoggerFactory.getLogger(UserService.class);


    @GetMapping("/login")
    public String login() {
        return "LoginPage";
    }

    @GetMapping("/pengaduann")
    public String pengaduann() {
        return "PengaduanPage";
    }

    // form new user
    @GetMapping("/daftar")
    public String daftarPage(Model model) {
        try {
            User user = new User();
            model.addAttribute("user", user);

        } catch (Exception e) {

        }
        return "DaftarPage";
    }

    // save user to db
    @PostMapping("/daftar")
    public String saveUser(Model model, User users) {
        try {
            userService.saveUser(users);
            model.addAttribute("user", users);
        } catch (Exception e) {

        }
        return "redirect:/panda/login";
    }

    // login
    @PostMapping("/login")
    public String loginSucces(
            @RequestParam String nik,
            @RequestParam String password) {
        User loggedUser = userService.checkLogin(nik, password);
        if (loggedUser != null) {

            log.info(loggedUser.getNama_lengkap() + "user barhasil login ");
            return "redirect:/panda/pengaduan";
        } else {
            return "redirect:/panda/login";

        }
    }

}