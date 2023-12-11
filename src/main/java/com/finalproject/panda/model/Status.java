package com.finalproject.panda.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "status")

public class Status {

    private int id_status;

    private String jenis_status;
    
}
