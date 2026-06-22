package com.jagat.spring_security_demo.service;


import com.jagat.spring_security_demo.model.User;
import com.jagat.spring_security_demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepo repo;

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
