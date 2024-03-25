package com.mobile.app.Repository;

import com.mobile.app.Model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Optional<Answer> findByQuestionId(int questionId);
    // You can add custom query methods here if needed
}
