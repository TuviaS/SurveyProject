package AnswersDBServerA.service;

import AnswersDBServerA.model.Answer;
import AnswersDBServerA.model.AnswerServiceResponse;
import AnswersDBServerA.model.ReceivedJsonAnswer;
import AnswersDBServerA.model.ReceivedJsonAnswer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AnswerService {
    AnswerServiceResponse createAnswer (ReceivedJsonAnswer receivedJsonAnswer);
    AnswerServiceResponse changeAnswer (Long employeeId, Long questionId, String EmployeeResponse);
    List<Answer> getAllAnswersToAllQuestions();
    List<Answer> getAllAnswersByEmployeeId (Long employeeId);
    List<Answer> getAllAnswersByQuestionId(Long questionId);
    AnswerServiceResponse getSpecificAnswerByEmployee (Long employeeId, Long questionId);
    AnswerServiceResponse getAllAnswersToSpecificQuestionByQuestionId(Long QuestionId);
    AnswerServiceResponse deleteAnswer (Long employeeId, Long questionId, String EmployeeResponse);
    AnswerServiceResponse deleteAllAnswersByEmployeeId (Long employeeId);
    AnswerServiceResponse deleteAllAnswersByQuestionId (Long questionId);
}
