package com.jagat.spring_boot_rest.Controller;


import com.jagat.spring_boot_rest.model.User;
import com.jagat.spring_boot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;


    @GetMapping("users")
    public List<User> getAllUsers(){
        return new ArrayList<>(service.getAllUsers());
    }
    @PostMapping("register")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

}
