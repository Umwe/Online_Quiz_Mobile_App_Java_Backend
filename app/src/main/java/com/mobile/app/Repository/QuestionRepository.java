package com.mobile.app.Repository;


import com.mobile.app.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // Define any custom queries or operations here if needed
}
