package com.org.unixam_backend.service;

import com.org.unixam_backend.model.QuestionDto;
import com.org.unixam_backend.model.exam.Question;
import com.org.unixam_backend.model.exam.QuestionResponse;
import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.model.exam.Result;

import java.util.List;
import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Long questionId);
    public Set<Question> getQuestionOfQuiz(Quiz quiz);
    public void deleteQuestion(Long questionId);

    Result evalQuiz(List<QuestionResponse> question);

}
