package com.finalproject.panda.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PengaduanController {

    @GetMapping("/pengaduan")
    public String formPengaduan(){
        return "Pengaduan";
    }
}
