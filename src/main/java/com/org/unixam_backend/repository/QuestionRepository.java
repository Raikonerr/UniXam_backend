package com.org.unixam_backend.repository;

import com.org.unixam_backend.model.exam.Question;
import com.org.unixam_backend.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);

}
