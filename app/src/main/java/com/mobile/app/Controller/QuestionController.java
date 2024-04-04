package com.mobile.app.Controller;

import com.mobile.app.Model.Question;
import com.mobile.app.Model.Quiz;
import com.mobile.app.Service.QuestionService;
import com.mobile.app.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    private final QuizService quizService;

    @Autowired
    public QuestionController(QuestionService questionService, QuizService quizService) {
        this.questionService = questionService;
        this.quizService = quizService;
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> createQuestion(@RequestBody Question question) {
        Quiz quiz = question.getQuiz(); // Get the quiz object from the question
        if (quiz == null) {
            return ResponseEntity.badRequest().build(); // Handle case where quiz is not provided
        }

        Long quizId = quiz.getQuizId(); // Assuming getQuizId() method exists in Quiz entity
        Quiz retrievedQuiz = quizService.getQuizById(quizId);
        if (retrievedQuiz == null) {
            return ResponseEntity.badRequest().build(); // Handle case where quiz is not found
        }

        // Set the retrieved quiz object for the question
        question.setQuiz(retrievedQuiz);
        Question savedQuestion = questionService.saveQuestion(question);

        // Include the saved question ID in the response
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("questionId", savedQuestion.getQuestionId()); // Assuming getId() method exists in Question entity
        responseData.put("question", savedQuestion);
        return ResponseEntity.ok(responseData);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable int id, @RequestBody Question question) {
        if (!questionService.getQuestionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        question.setQuestionId(id);
        Question updatedQuestion = questionService.saveQuestion(question);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable int id) {
        if (!questionService.getQuestionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        questionService.deleteQuestionById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listbyquiz/{quizId}")
    public ResponseEntity<List<Question>> getQuestionsByQuizId(@PathVariable int quizId) {
        List<Question> questions = questionService.getQuestionsByQuizId(quizId);
        if (questions.isEmpty()) {
            return ResponseEntity.notFound().build(); // No questions found for the specified quiz ID
        }
        return ResponseEntity.ok(questions);
    }
}
