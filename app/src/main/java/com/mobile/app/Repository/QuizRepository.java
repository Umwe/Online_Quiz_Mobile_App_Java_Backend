package com.mobile.app.Repository;

import com.mobile.app.Model.quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<quiz, Long> {
    // You can add custom query methods here if needed
}