package com.mobile.app.Controller;

import com.mobile.app.Model.Answer;
import com.mobile.app.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/listall")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = answerService.getAllAnswers();
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") int id) {
        Optional<Answer> answerOptional = answerService.getAnswerById(id);
        return answerOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {
        Answer createdAnswer = answerService.saveAnswer(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable("id") int id, @RequestBody Answer updatedAnswer) {
        try {
            Answer updated = answerService.updateAnswer(id, updatedAnswer);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable("id") int id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }

    // You can add more controller methods here as needed
}
