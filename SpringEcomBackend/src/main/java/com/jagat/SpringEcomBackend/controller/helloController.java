package com.jagat.SpringEcomBackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/hello")
    public String home(){
        //System.out.println("In home");
        return "In Home Page...";
    }

}
