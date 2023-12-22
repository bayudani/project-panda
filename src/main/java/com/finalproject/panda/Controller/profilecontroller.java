package com.finalproject.panda.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panda")
public class profilecontroller {
    

    @GetMapping("/profile")
    public String profile(){
        return "User/profileuser";
    }
    
    @GetMapping("/riwayatP")
    public String  riwayat (){
        return "user/riwayatPengaduan";
    }
}
