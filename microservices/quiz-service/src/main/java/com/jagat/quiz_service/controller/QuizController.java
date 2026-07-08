package com.jagat.quiz_service.controller;


import com.jagat.quiz_service.model.QuestionWrapper;
import com.jagat.quiz_service.model.QuizDto;
import com.jagat.quiz_service.model.Responses;
import com.jagat.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());
    }
    
    @PostMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizById(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getResult(@PathVariable Integer id, @RequestBody List<Responses> responses){
        return quizService.getResult(id,responses);
    }
}
