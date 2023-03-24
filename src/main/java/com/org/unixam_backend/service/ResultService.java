package com.org.unixam_backend.service;

import com.org.unixam_backend.model.exam.Result;
import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.model.User;

import java.util.List;

public interface ResultService {

    public Result addResult(Result result);

    public List<Result> getAllResult();

    public List<Result> getResultOfQuiz(Quiz quiz);

    public List<Result> getResultOfUser(User user);

    public List<Result> getResultOfUserAndQuiz(Quiz quiz,User user);
}
