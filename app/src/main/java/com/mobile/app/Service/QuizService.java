package com.mobile.app.Service;

import com.mobile.app.Model.quiz;
import com.mobile.app.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElse(null);
    }

    public quiz saveQuiz(quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }
}
