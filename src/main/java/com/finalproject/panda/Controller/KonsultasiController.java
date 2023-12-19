package com.finalproject.panda.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panda")
public class KonsultasiController {
    
    @GetMapping("/konsultasi")
    public String getKonsultasi(){
        return "KonsultasiPage";
    }
}
