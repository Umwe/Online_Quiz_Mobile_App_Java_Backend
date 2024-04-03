package com.mobile.app.Repository;

import com.mobile.app.Model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    @Query("SELECT a FROM Answer a WHERE a.question.questionId = :questionId")
    List<Answer> findByQuestionId(@Param("questionId") int questionId);
}
