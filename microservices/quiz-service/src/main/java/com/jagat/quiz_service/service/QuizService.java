package com.jagat.quiz_service.service;



import com.jagat.quiz_service.dao.QuizDao;
import com.jagat.quiz_service.feign.QuizInterface;
import com.jagat.quiz_service.model.QuestionWrapper;
import com.jagat.quiz_service.model.Quiz;
import com.jagat.quiz_service.model.Responses;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        //List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(int id) {
        Quiz quiz = quizDao.findById(id).get();     //getting hold of the quiz
        List<Integer> questionIds = quiz.getQuestionsIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsById(questionIds);

       return questions;
    }

    public ResponseEntity<Integer> getResult(Integer id,List<Responses> responses) {

        ResponseEntity<Integer> result = quizInterface.getScore(responses);

        return result;
    }
}
