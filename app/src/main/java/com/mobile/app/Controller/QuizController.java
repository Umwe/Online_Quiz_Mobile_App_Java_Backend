package com.mobile.app.Controller;

import com.mobile.app.Model.quiz;
import com.mobile.app.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping(("/listquiz"))
    public ResponseEntity<List<quiz>> getAllQuizzes() {
        List<quiz> quizzes = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/listquiz/{quizId}")
    public ResponseEntity<quiz> getQuizById(@PathVariable Long quizId) {
        quiz quiz = quizService.getQuizById(quizId);
        if (quiz != null) {
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/savequiz")
    public ResponseEntity<quiz> createQuiz(@RequestBody quiz quiz) {
        quiz newQuiz = quizService.saveQuiz(quiz);
        return new ResponseEntity<>(newQuiz, HttpStatus.CREATED);
    }

    @PutMapping("/update/{quizId}")
    public ResponseEntity<quiz> updateQuiz(@PathVariable Long quizId, @RequestBody quiz updatedQuiz) {
        quiz existingQuiz = quizService.getQuizById(quizId);
        if (existingQuiz != null) {
            updatedQuiz.setQuizId(quizId); // Ensure the ID is set correctly
            quiz updated = quizService.saveQuiz(updatedQuiz);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{quizId}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long quizId) {
        quizService.deleteQuiz(quizId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
