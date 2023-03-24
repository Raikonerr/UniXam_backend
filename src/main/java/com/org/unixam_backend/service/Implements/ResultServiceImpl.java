package com.org.unixam_backend.service.Implements;

import com.org.unixam_backend.model.exam.Result;
import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.model.User;
import com.org.unixam_backend.repository.ResultRepository;
import com.org.unixam_backend.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Result addResult(Result result) {
        return this.resultRepository.save(result);
    }

    @Override
    public List<Result> getAllResult() {
        return this.resultRepository.findAll();
    }

    @Override
    public List<Result> getResultOfQuiz(Quiz quiz) {
        return this.resultRepository.findByQuiz(quiz);
    }

    @Override
    public List<Result> getResultOfUser(User user) {
        return this.resultRepository.findByUser(user);
    }

    @Override
    public List<Result> getResultOfUserAndQuiz(Quiz quiz, User user) {
        return this.resultRepository.findByQuizAndUser(quiz, user);
    }
}

