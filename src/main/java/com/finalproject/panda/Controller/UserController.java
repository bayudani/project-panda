package com.finalproject.panda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalproject.panda.Service.UserService;
import com.finalproject.panda.model.User;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "LoginPage";
    }

    //form new user
    @GetMapping("/daftar")
    public String daftarPage(Model model){
        try {
            User user = new User();
            model.addAttribute("user", user);

        } catch (Exception e) {

        }
        return "DaftarPage";
    }

    // save user to db
    @PostMapping("/daftar")
    public String saveUser(User user){
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/";
    }


    //login
    @PostMapping("/masuk")
    public String loginSucces(@RequestParam String NIK, @RequestParam String password){
        User loggedUser = userService.checkLogin(NIK, password);
        if (loggedUser != null) {

            return "redirect:/";
        } else {
            
            return "redirect:/";
        }
    }  
}
