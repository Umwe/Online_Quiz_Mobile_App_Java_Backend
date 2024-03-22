package com.mobile.app.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AnswerID")
    private int answerId;

    @ManyToOne(cascade = CascadeType.REMOVE) // Add cascade option here
    @JoinColumn(name = "QuestionID")
    private Question question;

    @Column(name = "OptionA")
    private String optionA;

    @Column(name = "OptionB")
    private String optionB;

    @Column(name = "OptionC")
    private String optionC;

    @Column(name = "OptionD")
    private String optionD;

    @Column(name = "CorrectOptionIndex")
    private int correctOptionIndex;

    public Answer() {
    }

    public Answer(int answerId, Question question, String optionA, String optionB, String optionC, String optionD, int correctOptionIndex) {
        this.answerId = answerId;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOptionIndex = correctOptionIndex;
    }

    // Getters and setters


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

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public void setCorrectOptionIndex(int correctOptionIndex) {
        this.correctOptionIndex = correctOptionIndex;
    }
}
