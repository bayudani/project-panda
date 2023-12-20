package com.finalproject.panda.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

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

    @PreAuthorize("isAuthenticated()")
    public Pengaduan savePengaduan(Pengaduan pengaduan) {
        try {
            // Periksa apakah pengguna sudah terotentikasi
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null && authentication.getPrincipal() instanceof User) {
                String nik = ((User) authentication.getPrincipal()).getNik();
                log.info("nik nya adalah: " + nik);

                User loggedInUser = userService.getUserByNik(nik);

                if (loggedInUser != null) {
                    // Set user_nik di objek Pengaduan
                    pengaduan.setUser(loggedInUser);

                    // Set waktu created_at
                    pengaduan.setCreated_at(LocalDateTime.now());

                    // Simpan Pengaduan ke database
                    Pengaduan savedPengaduan = pengaduanRepo.save(pengaduan);

                    log.info("Pengaduan dengan id registrasi: " + savedPengaduan.getId_registrasi()
                            + " berhasil ditambahkan");

                    return savedPengaduan;
                } else {
                    log.warn("User tidak ditemukan.");
                    return null;
                }
            } else {
                log.warn("User is not authenticated. Cannot save Pengaduan without an authenticated user.");
                return null;
            }
        } catch (Exception e) {
            log.error("Gagal menyimpan pengaduan: " + e.getMessage());
            throw new RuntimeException("Gagal menyimpan pengaduan", e);
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
