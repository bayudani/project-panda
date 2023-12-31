package com.finalproject.panda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "kasus")
public class Kasus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_kasus;

    private String jenis_kasus;
    
}
