package com.finalproject.panda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalproject.panda.model.Pengaduan;

public interface PengaduanRepo extends JpaRepository<Pengaduan, Integer> {

}
