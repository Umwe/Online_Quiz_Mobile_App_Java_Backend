package com.mobile.app.Service;

import com.mobile.app.Model.scoreboard;
import com.mobile.app.Repository.ScoreboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreboardService {
    private final ScoreboardRepository scoreboardRepository;

    @Autowired
    public ScoreboardService(ScoreboardRepository scoreboardRepository) {
        this.scoreboardRepository = scoreboardRepository;
    }

    // Create operation
    public scoreboard createScoreboard(scoreboard scoreboard) {
        return scoreboardRepository.save(scoreboard);
    }

    // Read operation
    public Optional<scoreboard> getScoreboardById(Long id) {
        return scoreboardRepository.findById(id);
    }

    // Update operation
    public scoreboard updateScoreboard(scoreboard scoreboard) {
        return scoreboardRepository.save(scoreboard);
    }

    // Delete operation
    public void deleteScoreboard(Long id) {
        scoreboardRepository.deleteById(id);
    }

    // Custom query method to find scoreboard by userid
    public scoreboard findByUserid(int userid) {
        return scoreboardRepository.findByUserid(userid);
    }

    // Custom query method to find scoreboard by quizId
    public scoreboard findByQuizId(int quizId) {
        return scoreboardRepository.findByQuizId(quizId);
    }


    // Get all scoreboards
    public List<scoreboard> getAllScoreboards() {
        return scoreboardRepository.findAll();
    }
}
