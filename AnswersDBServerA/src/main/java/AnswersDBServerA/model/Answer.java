package AnswersDBServerA.model;

import java.util.List;

public class Answer {
    private Long questionId;
    private String questionAnswer;

    public Answer(Long questionId, String questionAnswer) {
        this.questionId = questionId;
        this.questionAnswer = questionAnswer;


    }
    public Long getQuestionId() {
        return questionId;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }


    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}