package com.jagat.quiz_service.model;

import lombok.Data;

@Data
public class QuizDto {
    private String categoryName;
    private int NumQuestions;
    private String title;
}
