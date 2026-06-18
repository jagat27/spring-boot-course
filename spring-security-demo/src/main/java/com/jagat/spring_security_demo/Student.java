package com.jagat.spring_security_demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int rollNum;
    private String name;
    private String tech;
}
