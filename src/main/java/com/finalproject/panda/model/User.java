package com.finalproject.panda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String NIK;

    private String nama_lengkap;
    private String password;
    private String alamat;
    private String hp;

    @OneToOne(mappedBy = "user")
    private Identitas identitas;

}

