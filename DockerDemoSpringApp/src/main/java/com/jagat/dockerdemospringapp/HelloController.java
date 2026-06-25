package com.jagat.dockerdemospringapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloGreet(){
        return "Hello World "+ "Project created in MacBook" +"Using DockerFile ";
    }

}
