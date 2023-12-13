package com.finalproject.panda.model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "identitas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Identitas {

    @Id
    @OneToOne
    @JoinColumn(name = "user_nik")
    private User user;

    private String nama;
    private String alamat;
    private String pekerjaan;
    private String pendidikan;
    private Date TTL;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @OneToOne
    @JoinColumn(name = "registrasi_id")
    private Registrasi registrasi;

}

