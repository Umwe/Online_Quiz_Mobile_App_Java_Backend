package com.mobile.app.Repository;

import com.mobile.app.Model.scoreboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreboardRepository extends JpaRepository<scoreboard, Long> {
    // You can add custom query methods here if needed

    scoreboard findByUserid(int userid);

    // Custom query method to find scoreboard by quizId
    scoreboard findByQuizId(int quizId);

}
