package com.example.EmploeeServer.controller;
import com.example.EmploeeServer.model.FetchedAnswer;
import com.example.EmploeeServer.service.FetchedAndManipulatedAnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FetchedAndManipulatedAnswersController {

    @Autowired
        FetchedAndManipulatedAnswersService fetchedAndManipulatedAnswersService;

    @GetMapping(value ="answers/{employeeId}/getAllAnswersByEmployeeId")
    List<FetchedAnswer> fetchAllAnswersByEmployeeId (@PathVariable Long employeeId)    {
        return fetchedAndManipulatedAnswersService.getAllAnswersByEmployeeId(employeeId);
    }

    @GetMapping(value ="answers/{questionId}/getAllAnswersByQuestionId")
    List<FetchedAnswer> fetchAllAnswersByQuestionId (@PathVariable Long questionId)    {
        return fetchedAndManipulatedAnswersService.getAllAnswersByQuestionId(questionId);
    }

}
