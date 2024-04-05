package com.mobile.app.Model;


import jakarta.persistence.*;

@Entity
public class scoreboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private int quizId;

    private int userid;

    private String username;

    private String quizName;

    private String totalMarksObtained;

    public scoreboard() {

    }

    public scoreboard(long id, int quizId, int userid, String username, String quizName, String totalMarksObtained) {
        this.id = id;
        this.quizId = quizId;
        this.userid = userid;
        this.username = username;
        this.quizName = quizName;
        this.totalMarksObtained = totalMarksObtained;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getTotalMarksObtained() {
        return totalMarksObtained;
    }

    public void setTotalMarksObtained(String totalMarksObtained) {
        this.totalMarksObtained = totalMarksObtained;
    }
}