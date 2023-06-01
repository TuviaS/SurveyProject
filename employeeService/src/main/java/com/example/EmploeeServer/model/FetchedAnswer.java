package com.example.EmploeeServer.model;

public class FetchedAnswer {
    private Long questionId;
    private String employeeAnswer;

    public FetchedAnswer(Long questionId, String employeeAnswer) {
        this.questionId = questionId;
        this.employeeAnswer = employeeAnswer;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getEmployeeAnswer() {
        return employeeAnswer;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setEmployeeAnswer(String employeeAnswer) {
        this.employeeAnswer = employeeAnswer;
    }
}
