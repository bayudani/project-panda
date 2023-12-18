package com.finalproject.panda.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.panda.Repository.PengaduanRepo;
import com.finalproject.panda.model.Pengaduan;

@Service
public class PengaduanService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private PengaduanRepo pengaduanRepo;

    public List<Pengaduan> getAllPengaduan() {

        return pengaduanRepo.findAll();

    }

    
    public Pengaduan savePengaduan(Pengaduan pengaduan) {

        Pengaduan savePengaduan = pengaduanRepo.save(pengaduan);
        log.info("Pengaduan dengan id register: " + pengaduan.getId_registrasi() + " berhasil di tambahkan");
        return savePengaduan;
    }


    public void deletePengaduan(Integer id) {
        pengaduanRepo.deleteById(id);
        log.info("pengaduan dengan id register: " + id + " berhasil di hapus");
    }

    public Pengaduan getPengaduanById(Integer id){
        return pengaduanRepo.findById(id).orElse(null);
    }

    public Pengaduan updatePengaduan(Integer id, Pengaduan pengaduan) {

        Pengaduan pengaduan2 = getPengaduanById(id);

        if (pengaduan2 != null) {
            pengaduan2.setAduan(pengaduan.getAduan());
            pengaduan2.setAlamat(pengaduan.getAlamat());
            pengaduan2.setCreated_at(pengaduan.getCreated_at());
            pengaduan2.setHarapan(pengaduan.getHarapan());
            pengaduan2.setId_registrasi(pengaduan.getId_registrasi());
            pengaduan2.setNama(pengaduan.getNama());
            pengaduan2.setPekerjaan(pengaduan.getPekerjaan());
            pengaduan2.setTTL(pengaduan.getTTL());

            Pengaduan newPengaduan = pengaduanRepo.save(pengaduan2);
            return newPengaduan;
        }

        return null;
    }
}
