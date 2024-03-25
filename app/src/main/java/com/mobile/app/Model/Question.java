package com.mobile.app.Model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuestionID")
    private int questionId;

    @ManyToOne
    @JoinColumn(name = "QuizID")
    private Quiz quiz;

    @Column(name = "QuestionText", columnDefinition = "TEXT")
    private String questionText;

    @Column(name = "Marks")
    private int marks;

    @JsonIgnore // Add this annotation to ignore serialization of answers
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Answer> answers;

    public Question() {
    }

    public Question(int questionId, Quiz quiz, String questionText, int marks, List<Answer> answers) {
        this.questionId = questionId;
        this.quiz = quiz;
        this.questionText = questionText;
        this.marks = marks;
        this.answers = answers;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }


    // getters and setters
}
