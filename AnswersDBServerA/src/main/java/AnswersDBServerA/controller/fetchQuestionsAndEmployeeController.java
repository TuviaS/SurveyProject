package AnswersDBServerA.controller;
import AnswersDBServerA.model.FetchedQuestion;
import AnswersDBServerA.service.FetchQuestionsAndEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class fetchQuestionsAndEmployeeController {
    @Autowired
        FetchQuestionsAndEmployeeService fetchQuestionsAndEmployeeService;
     @GetMapping (path ="questions/getAllQuestions")
    List<FetchedQuestion> fetchAllQuestions ()    {
        return fetchQuestionsAndEmployeeService.getAllQuestions();
    }
    @GetMapping (path ="questions/{questionId}")
    FetchedQuestion fetchQuestionById (@PathVariable long questionId)    {
        return fetchQuestionsAndEmployeeService.getQuestionById(questionId);
    }

}
