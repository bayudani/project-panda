package com.finalproject.panda.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.finalproject.panda.Repository.UserRepo;
import com.finalproject.panda.model.User;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user) {

        return userRepo.save(user);
    }

    public User checkLogin(String NIK, String password) {
        User user = userRepo.findByNIK(NIK);

        if (user != null) {
            String passFromDb = user.getPassword();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            if (passwordEncoder.matches(password, passFromDb)) {
                log.info(user.getNama_lengkap() + " berhasil login");
                return user;
            } else {
                log.info("Password salah");
            }

        } else {
            log.info("User tidak ditemukan");
        }
        return null;
    }
}
