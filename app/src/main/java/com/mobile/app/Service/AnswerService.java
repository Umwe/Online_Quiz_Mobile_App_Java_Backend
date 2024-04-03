package com.mobile.app.Service;

import com.mobile.app.Model.Answer;
import com.mobile.app.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public Optional<Answer> getAnswerById(int answerId) {
        return answerRepository.findById(answerId);
    }

    public List<Answer> getAnswersByQuestionId(int questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public void deleteAnswer(int answerId) {
        answerRepository.deleteById(answerId);
    }

    public Answer updateAnswer(int id, Answer updatedAnswer) {
        Optional<Answer> existingAnswerOptional = answerRepository.findById(id);
        if (existingAnswerOptional.isPresent()) {
            Answer existingAnswer = existingAnswerOptional.get();
            existingAnswer.setQuestion(updatedAnswer.getQuestion());
            existingAnswer.setOptionA(updatedAnswer.getOptionA());
            existingAnswer.setOptionB(updatedAnswer.getOptionB());
            existingAnswer.setOptionC(updatedAnswer.getOptionC());
            existingAnswer.setOptionD(updatedAnswer.getOptionD());
            existingAnswer.setCorrectOptionIndex(updatedAnswer.getCorrectOptionIndex());
            return answerRepository.save(existingAnswer);
        } else {
            throw new RuntimeException("Answer not found with id: " + id);
        }
    }




}
