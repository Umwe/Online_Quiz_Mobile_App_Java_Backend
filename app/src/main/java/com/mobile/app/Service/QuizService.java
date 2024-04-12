package com.mobile.app.Service;

import com.mobile.app.Model.Quiz;
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

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElse(null);
    }

    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }

    public int getTotalQuestionsForQuiz(Long quizId) {
        return quizRepository.countQuestionsByQuizId(quizId);
    }
    public int getTotalMarksByQuizId(Long quizId) {
        return quizRepository.findTotalMarksByQuizId(quizId);
    }

    public Quiz getQuizWithQuestions(Long quizId) {
        return quizRepository.findByIdWithQuestions(quizId);
    }
}
