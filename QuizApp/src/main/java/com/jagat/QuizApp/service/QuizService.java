package com.jagat.QuizApp.service;


import com.jagat.QuizApp.dao.QuestionDao;
import com.jagat.QuizApp.dao.QuizDao;
import com.jagat.QuizApp.model.Question;
import com.jagat.QuizApp.model.QuestionWrapper;
import com.jagat.QuizApp.model.Quiz;
import com.jagat.QuizApp.model.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);     //getting hold of the quiz
        List<Question> questionFromDb = quiz.get().getQuestions();  //getting hold of the questions
        List<QuestionWrapper>  questionForUser = new ArrayList<>(); //creating what the use should see

        for(Question q : questionFromDb){
            QuestionWrapper qw = new QuestionWrapper(
                                    q.getId(),
                                    q.getQuestionTitle(),
                                    q.getOption1(),
                                    q.getOption2(),
                                    q.getOption3(),
                                    q.getOption4()
                                    );
            questionForUser.add(qw);
        }



        return new ResponseEntity<>(questionForUser,HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Integer> getResult(Integer id,List<Responses> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        System.out.println(questions);
        int result = 0;
        int i=0;
        for(Responses response : responses){

            if(response.getResponse().equals(questions.get(i).getRightAnswer()));
            {
                System.out.println("questions of get("+i+")");
                System.out.println(questions.get(i));
                result++;
                i++;
            }
        }
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
