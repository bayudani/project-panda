package com.finalproject.panda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.panda.Repository.UserRepo;
import com.finalproject.panda.model.User;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user){
        return userRepo.save(user);
    }
}
