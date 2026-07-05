package com.jagat.QuizApp.controller;



import com.jagat.QuizApp.model.QuestionWrapper;

import com.jagat.QuizApp.model.Responses;
import com.jagat.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }
    
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizById(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }

    @GetMapping("submit/{id}")
    public ResponseEntity<Integer> getResult(@PathVariable Integer id, @RequestBody List<Responses> responses){
        return quizService.getResult(id,responses);
    }
}
