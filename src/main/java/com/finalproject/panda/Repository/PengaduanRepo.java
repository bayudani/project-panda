package com.finalproject.panda.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.finalproject.panda.model.Pengaduan;

public interface PengaduanRepo extends JpaRepository<Pengaduan, Integer> {
    List<Pengaduan> getByUserNik(String nik);
}
