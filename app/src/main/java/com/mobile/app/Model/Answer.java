package com.mobile.app.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AnswerID")
    private int answerId;

    @ManyToOne
    @JoinColumn(name = "QuestionID")
    private Question question;

    @Column(name = "AnswerText", columnDefinition = "TEXT")
    private String answerText;

    @Column(name = "IsCorrect")
    private boolean correct;

    public Answer() {
    }

    public Answer(int answerId, Question question, String answerText, boolean correct) {
        this.answerId = answerId;
        this.question = question;
        this.answerText = answerText;
        this.correct = correct;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
