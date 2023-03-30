package com.org.unixam_backend.service.Implements;

import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.model.exam.Category;
import com.org.unixam_backend.service.QuizService;
import com.org.unixam_backend.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new LinkedHashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
       return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        this.quizRepository.deleteById(quizId);
    }

    @Override
    public java.util.List<Quiz> getQuizzesOfCategory(Category cat) {
    return this.quizRepository.findByCategory(cat);
    }

    @Override
    public java.util.List<Quiz> getActiveQuizzes() {
    return this.quizRepository.findByActive(true);
    }

    @Override
    public java.util.List<Quiz> getActiveQuizzesOfCategory(Category cat) {
    return this.quizRepository.findByCategoryAndActive(cat,true);
    }



}
