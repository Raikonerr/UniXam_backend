package com.org.unixam_backend.controller;

import com.org.unixam_backend.model.exam.Result;
import com.org.unixam_backend.model.User;
import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.service.ResultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
@CrossOrigin("*")
public class ResultController {

    @Autowired
    private ResultService resultService;

    //add result
    @PostMapping("/")
    public ResponseEntity<?> addResult(@RequestBody Result result)
    {
     Result res=this.resultService.addResult(result);
     return  ResponseEntity.ok(res);
    }

    //get result by user and quiz
    @GetMapping("/{quiz_id}/{user_id}")
    public ResponseEntity<?> getResultByUserAndQuiz(@PathVariable("quiz_id") long quiz_id,@PathVariable("user_id") long user_id) {
        Quiz quiz1 = new Quiz();
        quiz1.setId(quiz_id);
        User user1 = new User();
        user1.setId(user_id);
        System.out.println("quiz id : " + quiz_id + " " + " user id : " + user_id);
        List<Result> list = (this.resultService.getResultOfUserAndQuiz(quiz1, user1));

        for (Result r : list) {
            System.out.println(r.getMarksScored());
        }

        return ResponseEntity.ok(list);
    }

    //get result by quiz
    @GetMapping("/{quiz_id}")
    public ResponseEntity<?> getResultByQuiz(@PathVariable("quiz_id") long quiz_id) {
        Quiz quiz1 = new Quiz();
        quiz1.setId(quiz_id);
        List<Result> list = this.resultService.getResultOfQuiz(quiz1);
        return ResponseEntity.ok(list);
    }
}

