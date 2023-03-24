package com.org.unixam_backend.service;

import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.model.exam.Category;

import java.util.Set;
import java.util.List;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzes();
    public  Quiz getQuiz(Long quizId);
    public  void  deleteQuiz(Long quizId);
    public List<Quiz> getQuizzesOfCategory(Category cat);
}
