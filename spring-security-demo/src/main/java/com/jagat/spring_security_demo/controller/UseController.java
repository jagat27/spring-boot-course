package com.jagat.spring_security_demo.controller;

import com.jagat.spring_security_demo.model.User;
import com.jagat.spring_security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UseController {

    @Autowired
    private UserService service;

    @PostMapping("register")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

}
