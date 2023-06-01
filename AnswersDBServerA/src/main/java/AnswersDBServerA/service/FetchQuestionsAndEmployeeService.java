package AnswersDBServerA.service;
import AnswersDBServerA.model.FetchedEmployee;
import AnswersDBServerA.model.FetchedQuestion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient (
        name = "GetQuestionsAndEmployeeService",
        url ="${externalApi.QuestionsAndEmployeeService.url}"
)


public interface FetchQuestionsAndEmployeeService {
    @GetMapping (value = "/employee/{employeeId}")
    FetchedEmployee getEmployeeDetailsById(@PathVariable long employeeId);

    @GetMapping (value = "question/{questionId}")
    FetchedQuestion getQuestionById (@PathVariable long questionId);

    @GetMapping (value ="question/all")
    List<FetchedQuestion> getAllQuestions ();
}

