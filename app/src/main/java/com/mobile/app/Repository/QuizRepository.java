package com.mobile.app.Repository;

import com.mobile.app.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // You can add custom query methods here if needed
}