package com.mobile.app.Controller;

import com.mobile.app.Model.Quiz;
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
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }

    @GetMapping("/listquiz/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz != null) {
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/savequiz")
    public ResponseEntity<Long> createQuiz(@RequestBody Quiz quiz) {
        Quiz newQuiz = quizService.saveQuiz(quiz);
        return new ResponseEntity<>(newQuiz.getQuizId(), HttpStatus.CREATED);
    }



    @PutMapping("/update/{quizId}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long quizId, @RequestBody Quiz updatedQuiz) {
        Quiz existingQuiz = quizService.getQuizById(quizId);
        if (existingQuiz != null) {
            // Update only the non-collection fields
            existingQuiz.setQuizName(updatedQuiz.getQuizName());
            existingQuiz.setTotalMarks(updatedQuiz.getTotalMarks());

            // Optionally, handle the questions collection separately if needed
            // existingQuiz.getQuestions().clear();
            // existingQuiz.getQuestions().addAll(updatedQuiz.getQuestions());

            Quiz updated = quizService.saveQuiz(existingQuiz);
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
    @GetMapping("/totalQuestions/{quizId}")
    public ResponseEntity<Integer> getTotalQuestionsForQuiz(@PathVariable Long quizId) {
        int totalQuestions = quizService.getTotalQuestionsForQuiz(quizId);
        return new ResponseEntity<>(totalQuestions, HttpStatus.OK);
    }

    @GetMapping("/totalMarks/{quizId}")
    public ResponseEntity<Integer> getTotalMarksForQuiz(@PathVariable Long quizId) {
        int totalMarks = quizService.getTotalMarksByQuizId(quizId);
        return new ResponseEntity<>(totalMarks, HttpStatus.OK);
    }


    @GetMapping("/listquizrel/{quizId}")
    public ResponseEntity<Quiz> getQuizWithQuestions(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuizWithQuestions(quizId);
        if (quiz != null) {
            return ResponseEntity.ok(quiz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
