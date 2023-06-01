package AnswersDBServerA.controller;

import AnswersDBServerA.model.Answer;
import AnswersDBServerA.model.AnswerServiceResponse;
import AnswersDBServerA.model.Employee;
import AnswersDBServerA.model.ReceivedJsonAnswer;
import AnswersDBServerA.model.ReceivedJsonAnswer;
import AnswersDBServerA.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//**********This controller deals ONLY with answers
// stored on this service's DB - WE ARE PORT 8081 HERE*****
@RestController
public class EmployeeAnswerController {
  @Autowired
  private AnswerService answerService;

  @PostMapping(value = "answer/create")
  public AnswerServiceResponse createAnswer(@RequestBody ReceivedJsonAnswer receivedJsonAnswer) throws Exception {
    return answerService.createAnswer(receivedJsonAnswer);

  }

  @GetMapping (value = "answer/AllAnswersByEmployeeId/{employeeId}")
    public List<Answer> getAllAnswersByEmployeeId(@PathVariable Long employeeId) throws Exception {
      return answerService.getAllAnswersByEmployeeId(employeeId);

    }

  @GetMapping (value = "answer/AllAnswersByQuestionId/{questionId}")
  public List<Answer> getAllAnswersByQuestionId(@PathVariable long questionId) throws Exception {
    return answerService.getAllAnswersByQuestionId(questionId);

  }

  @GetMapping (value = "answer/allAnswersToAllQuestions")
  public List<Answer> getAllAnswerToAllQuestion() throws Exception {
    return answerService.getAllAnswersToAllQuestions();
  }



  @DeleteMapping (value = "delete/{employeeId}/allAnswersByEmployeeId")
  public AnswerServiceResponse deleteAllAnswersByEmployeeId(@PathVariable long employeeId) throws  Exception{
    return answerService.deleteAllAnswersByEmployeeId (employeeId);
  }

  @DeleteMapping (value = "delete/{questionId}/allAnswersByQuestionId")
  public AnswerServiceResponse deleteAllAnswersByQuestionId(@PathVariable long questionId) throws  Exception{
    return answerService.deleteAllAnswersByQuestionId (questionId);
  }

}
