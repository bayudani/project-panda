package com.finalproject.panda.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Kasus {

    private int id_status;
    private String Jenis_kasus;
    
}
