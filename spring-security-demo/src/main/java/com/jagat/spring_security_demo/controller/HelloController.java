package com.jagat.spring_security_demo.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping()
    public String greet(HttpSession session){
        return "Hello... ";
    }

    @GetMapping("helloController")
    public String helloGreet(HttpServletRequest request){
        return "Inside helloGreet ";
    }
}
