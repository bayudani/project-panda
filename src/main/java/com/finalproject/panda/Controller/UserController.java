package com.finalproject.panda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.finalproject.panda.Service.UserService;
import com.finalproject.panda.model.User;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

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
    public User saveUser(User user){
       return userService.saveUser(user);
    }

    //login
    @GetMapping("/masuk")
    public String loginSucces(){
        return "LoginPage";
    }
    
    
}
