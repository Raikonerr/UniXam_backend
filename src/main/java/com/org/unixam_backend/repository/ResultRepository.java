package com.org.unixam_backend.repository;

import com.org.unixam_backend.model.exam.Result;
import com.org.unixam_backend.model.exam.Quiz;
import com.org.unixam_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByQuiz(Quiz quiz);
    List<Result> findByUser(User user);
    List<Result> findByQuizAndUser(Quiz quiz, User user);

}
