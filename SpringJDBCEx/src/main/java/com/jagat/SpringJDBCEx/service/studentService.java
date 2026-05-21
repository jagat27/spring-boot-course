package com.jagat.SpringJDBCEx.service;

import com.jagat.SpringJDBCEx.model.Student;
import com.jagat.SpringJDBCEx.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    private studentRepo repo;

    public void addStudent(Student s) {
       repo.save(s);
    }

    public studentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(studentRepo repo) {
        this.repo = repo;
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
