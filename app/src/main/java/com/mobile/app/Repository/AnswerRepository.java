package com.mobile.app.Repository;

import com.mobile.app.Model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    // You can add custom query methods here if needed
}
