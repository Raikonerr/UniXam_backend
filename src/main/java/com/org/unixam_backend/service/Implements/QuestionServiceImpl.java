package com.org.unixam_backend.service.Implements;


import com.org.unixam_backend.model.exam.Question;
import com.org.unixam_backend.model.exam.QuestionResponse;
import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.model.exam.Result;
import com.org.unixam_backend.repository.QuestionRepository;
import com.org.unixam_backend.repository.QuizRepository;
import com.org.unixam_backend.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizRepository quizRepository;

    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

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

    public Result evalQuiz(List<QuestionResponse> questionResponses) {

        questionResponses.forEach(response ->
                logger.info("Question ID: {}, User Response: {}",
                        response.getQuestionId(),
                        response.getUserResponse()));


        int questionAttempted = 0;
        int correctAnswer = 0;

        // Assuming you have a method to get a question by its ID
        for (QuestionResponse response : questionResponses) {
            Question question = getQuestion(response.getQuestionId());
            if (response.getUserResponse() != null && !response.getUserResponse().isEmpty()) {
                questionAttempted++;
                if (question.getAnswer().equalsIgnoreCase(response.getUserResponse())) {
                    correctAnswer++;
                }
            }
        }

        Result result = new Result();
        result.setQuestionAttempted(questionAttempted);
        result.setCorrectAnswer(correctAnswer);
        result.setMarksScored(correctAnswer);
        result.setSumbitDateTime(LocalDateTime.now().toString());

        return result;
    }


}

