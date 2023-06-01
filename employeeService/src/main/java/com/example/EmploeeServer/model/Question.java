package com.example.EmploeeServer.model;

public class Question {
    private Long id;
    private String questionIs;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

    public Question(Long id, String questionIs, String answerA, String answerB, String answerC, String answerD) {

        this.id = id;
        this.questionIs = questionIs;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;

    }
    public Long getQuestionId() {
        return id;
    }
    public String getQuestionIs() {
        return questionIs;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setQuestionIs(String questionIs) {
        this.questionIs = questionIs;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }
}
