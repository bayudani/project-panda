package com.finalproject.panda.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "pengaduan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pengaduan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_registrasi;

    private Date created_at;

    @OneToOne
    @JoinColumn(name = "user_nik")
    private User user;

    private String nama;
    private String alamat;
    private String pekerjaan;
    private String pendidikan;
    private String aduan;
    private String harapan;
    private Date TTL;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

}