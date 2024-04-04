package com.mobile.app.Repository;


import com.mobile.app.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // Define any custom queries or operations here if needed

    // Custom query to retrieve questions by quiz ID
    @Query("SELECT q FROM Question q WHERE q.quiz.quizId = :quizId")
    List<Question> findByQuizId(@Param("quizId") int quizId);
}
