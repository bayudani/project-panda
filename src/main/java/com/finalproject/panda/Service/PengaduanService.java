package com.finalproject.panda.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.panda.Repository.PengaduanRepo;
import com.finalproject.panda.model.Pengaduan;
import com.finalproject.panda.model.User;

@Service
public class PengaduanService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private PengaduanRepo pengaduanRepo;

    @Autowired
    private UserService userService;

    public List<Pengaduan> getAllPengaduan() {
        return pengaduanRepo.findAll();
    }

    public Pengaduan savePengaduan(Pengaduan pengaduan) {
        // log.info("User = ", user);
        try {
            // User user = userService.getUserByNik()
            // User savedUser = userService.saveUser(user);
            
            // Setel waktu pembuatan pengaduan
            pengaduan.setCreated_at(LocalDateTime.now());
    
            // Setel pengguna ke objek pengaduan
            // pengaduan.setUser(savedUser);
    
            // Simpan pengaduan ke database
            Pengaduan savedPengaduan = pengaduanRepo.save(pengaduan);
    
            log.info("Pengaduan dengan id registrasi: " + savedPengaduan.getId_registrasi() + " berhasil ditambahkan");
    
            return savedPengaduan;
        } catch (Exception e) {
            // Tangani kesalahan jika diperlukan
            log.error("Gagal menyimpan pengaduan: " + e.getMessage());
            throw new RuntimeException("Gagal menyimpan pengaduan", e );
        }
    }
    

    public void deletePengaduan(Integer id) {
        pengaduanRepo.deleteById(id);
        log.info("pengaduan dengan id register: " + id + " berhasil di hapus");
    }

    public Pengaduan getPengaduanById(Integer id) {
        return pengaduanRepo.findById(id).orElse(null);
    }

    public Pengaduan updatePengaduan(Integer id, Pengaduan pengaduan, User user) {

        Pengaduan pengaduan2 = getPengaduanById(id);

        if (pengaduan2 != null) {
            pengaduan2.setAduan(pengaduan.getAduan());
            pengaduan2.setAlamat(pengaduan.getAlamat());
            pengaduan2.setHarapan(pengaduan.getHarapan());
            pengaduan2.setId_registrasi(pengaduan.getId_registrasi());
            pengaduan2.setNama(pengaduan.getNama());
            pengaduan2.setPekerjaan(pengaduan.getPekerjaan());
            pengaduan2.setTTL(pengaduan.getTTL());
            pengaduan2.setPendidikan(pengaduan.getPendidikan());
            pengaduan2.setCreated_at(pengaduan.getCreated_at());

            Pengaduan newPengaduan = pengaduanRepo.save(pengaduan2);
            return newPengaduan;
        }

        return null;
    }
}
