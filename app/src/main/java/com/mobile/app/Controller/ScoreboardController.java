package com.mobile.app.Controller;

import com.mobile.app.Model.scoreboard;
import com.mobile.app.Service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scoreboards")
public class ScoreboardController {
    private final ScoreboardService scoreboardService;

    @Autowired
    public ScoreboardController(ScoreboardService scoreboardService) {
        this.scoreboardService = scoreboardService;
    }

    // Create scoreboard
    @PostMapping("/save")
    public ResponseEntity<scoreboard> createScoreboard(@RequestBody scoreboard scoreboard) {
        scoreboard createdScoreboard = scoreboardService.createScoreboard(scoreboard);
        return new ResponseEntity<>(createdScoreboard, HttpStatus.CREATED);
    }

    // Get scoreboard by ID
    @GetMapping("/list/{id}")
    public ResponseEntity<scoreboard> getScoreboardById(@PathVariable Long id) {
        Optional<scoreboard> scoreboard = scoreboardService.getScoreboardById(id);
        return scoreboard.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update scoreboard
    @PutMapping("/update/{id}")
    public ResponseEntity<scoreboard> updateScoreboard(@PathVariable Long id, @RequestBody scoreboard scoreboard) {
        scoreboard.setId(id);
        scoreboard updatedScoreboard = scoreboardService.updateScoreboard(scoreboard);
        return new ResponseEntity<>(updatedScoreboard, HttpStatus.OK);
    }

    // Delete scoreboard
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteScoreboard(@PathVariable Long id) {
        scoreboardService.deleteScoreboard(id);
        return ResponseEntity.noContent().build();
    }

    // Get all scoreboards
        @GetMapping("/listall")
    public ResponseEntity<List<scoreboard>> getAllScoreboards() {
        List<scoreboard> scoreboards = scoreboardService.getAllScoreboards();
        return new ResponseEntity<>(scoreboards, HttpStatus.OK);
    }

    // Custom query method to find scoreboard by userid
    @GetMapping("/listbyuser/{userid}")
    public ResponseEntity<List<scoreboard>> findByUserid(@PathVariable int userid) {
        List<scoreboard> scoreboards = scoreboardService.findAllByUserid(userid);
        if (!scoreboards.isEmpty()) {
            return new ResponseEntity<>(scoreboards, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Custom query method to find scoreboard by quizId
    @GetMapping("/listbyquiz/{quizId}")
    public ResponseEntity<scoreboard> findByQuizId(@PathVariable int quizId) {
        scoreboard scoreboard = scoreboardService.findByQuizId(quizId);
        if (scoreboard != null) {
            return new ResponseEntity<>(scoreboard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

