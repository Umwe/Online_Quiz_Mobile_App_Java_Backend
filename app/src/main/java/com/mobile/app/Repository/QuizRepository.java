package com.mobile.app.Repository;

import com.mobile.app.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // You can add custom query methods here if needed

    @Query("SELECT COUNT(q) FROM Quiz q JOIN q.questions ques WHERE q.quizId = :quizId")
    int countQuestionsByQuizId(@Param("quizId") Long quizId);

    @Query("SELECT q.totalMarks FROM Quiz q WHERE q.quizId = :quizId")
    int findTotalMarksByQuizId(Long quizId);


    @Query("SELECT q FROM Quiz q LEFT JOIN FETCH q.questions WHERE q.quizId = :quizId")
    Quiz findByIdWithQuestions(@Param("quizId") Long quizId);
}