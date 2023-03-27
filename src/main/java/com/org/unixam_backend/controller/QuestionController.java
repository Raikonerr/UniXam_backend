package com.org.unixam_backend.controller;

import com.org.unixam_backend.model.exam.Question;
import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.service.QuestionService;
import com.org.unixam_backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        System.out.println(question);
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    @PutMapping("/")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    @GetMapping("/quiz/{id}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("id") Long id) {
        Quiz quiz = this.quizService.getQuiz(id);
        Set<Question> questions = quiz.getQuestions();
        int totalQuestions = Integer.parseInt(quiz.getNumberOfQuestions());
        List list = new ArrayList(questions);
        if (list.size() > totalQuestions) {
            list = list.subList(0, totalQuestions + 1);
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/quiz/all/{id}")
    public ResponseEntity<?> getAllQuestionsOfQuiz(@PathVariable("id") Long id) {
        Quiz quiz = new Quiz();
        quiz.setId(id);
        Set<Question> questions = this.questionService.getQuestionOfQuiz(quiz);
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable("id") Long id) {
        Question question = this.questionService.getQuestion(id);
        return ResponseEntity.ok(question);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") Long id) {
        this.questionService.deleteQuestion(id);
        return ResponseEntity.ok("Question Deleted");
    }






}
