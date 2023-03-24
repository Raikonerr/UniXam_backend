package com.org.unixam_backend.repository;

import com.org.unixam_backend.model.exam.Category;
import com.org.unixam_backend.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
    public List<Quiz> findByCategory(Category cat);
}
