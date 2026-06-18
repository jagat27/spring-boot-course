package com.jagat.spring_security_demo;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"jagat","java"),
            new Student(2,"vinay","python")
    ));

    @GetMapping("students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("students")
    public void addStudent(@RequestBody Student student){
        students.add(student);
        System.out.print(student);
    }

    @GetMapping("csrftoken")
    public CsrfToken getCSRFToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
