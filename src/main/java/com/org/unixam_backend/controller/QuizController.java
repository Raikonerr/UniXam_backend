package com.org.unixam_backend.controller;

import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.model.exam.Category;
import com.org.unixam_backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }

    @PutMapping("/")
    public ResponseEntity<?> updateQuiz(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuizzes()
    {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    @GetMapping("{id}")
    public Quiz getSingleQuiz(@PathVariable("id") Long id)
    {
        System.out.println("get single quiz");
        return this.quizService.getQuiz(id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable("id") Long id)
    {
        System.out.println("delete quiz");
        this.quizService.deleteQuiz(id);
    }

    @GetMapping("/category/{id}")
    public List<Quiz> getQuizOfCategory(@PathVariable("id") Long id)
    {
        Category cat=new Category();
        cat.setId(id);
        return this.quizService.getQuizzesOfCategory(cat);
    }

    @GetMapping("/active")
    public List<Quiz> getActiveQuizzes()
    {
        return this.quizService.getActiveQuizzes();
    }

    @GetMapping("/category/active/{id}")
    public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("id") Long id)
    {
        Category cat=new Category();
        cat.setId(id);
        return this.quizService.getActiveQuizzesOfCategory(cat);
    }


}
