package com.org.unixam_backend.service.Implements;

import com.org.unixam_backend.model.QuestionDto;
import com.org.unixam_backend.model.exam.Question;
import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.repository.QuestionRepository;
import com.org.unixam_backend.repository.QuizRepository;
import com.org.unixam_backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizRepository quizRepository;

//    @Override
//    public Question addQuestion(Question question) {
//        return this.questionRepository.save(
//                Question.builder()
//                        .content(question.content())
//                        .image(question.image())
//                        .option1(question.option1())
//                        .option2(question.option2())
//                        .option3(question.option3())
//                        .option4(question.option4())
//                        .answer(question.answer())
//                        .quiz(this.quizRepository.findById(question.quiz_id()).get())
//                        .build()
//        );
//    }
    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long qid) {
        this.questionRepository.deleteById(qid);
    }
}

