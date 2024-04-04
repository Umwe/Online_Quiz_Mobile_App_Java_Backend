package com.mobile.app.Repository;


import com.mobile.app.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // Define any custom queries or operations here if needed
    @Query("SELECT q FROM Question q JOIN FETCH q.answers WHERE q.quiz.quizId = :quizId")
    List<Question> findByQuizIdWithAnswers(int quizId);
}
