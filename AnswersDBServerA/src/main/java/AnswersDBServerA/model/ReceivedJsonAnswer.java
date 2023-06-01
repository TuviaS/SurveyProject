package AnswersDBServerA.model;

import java.util.List;

public class ReceivedJsonAnswer {
    private Long employeeId;
    private List<Answer> answerList;

    public ReceivedJsonAnswer(Long employeeId, List<Answer> answerList) {
        this.employeeId = employeeId;
        this.answerList = answerList;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
