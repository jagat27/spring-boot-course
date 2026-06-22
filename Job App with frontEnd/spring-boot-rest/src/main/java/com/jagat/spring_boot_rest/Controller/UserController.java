package com.jagat.spring_boot_rest.Controller;


import com.jagat.spring_boot_rest.model.User;
import com.jagat.spring_boot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("register")
    public User saveUser(@RequestBody User user){
        return service.saveUser(user);
    }

}
