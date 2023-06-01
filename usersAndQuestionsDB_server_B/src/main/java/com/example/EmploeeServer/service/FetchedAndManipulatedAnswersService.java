package com.example.EmploeeServer.service;
import com.example.EmploeeServer.model.FetchedAnswer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient (
        name="GetAndManipulateAnswerService",
        url="${externalApi.AnswersService.url}"
)
public interface FetchedAndManipulatedAnswersService {

    @GetMapping (value = "answer/AllAnswersByEmployeeId/{employeeId}")
    List<FetchedAnswer> getAllAnswersByEmployeeId(@PathVariable Long employeeId);

    @GetMapping (value = "answer/AllAnswersByQuestionId/{questionId}")
    List<FetchedAnswer> getAllAnswersByQuestionId(@PathVariable Long questionId);

    @DeleteMapping(value = "delete/{questionId}/allAnswersByQuestionId")
    void deleteAllAnswersByQuestionId(@PathVariable Long questionId);

    @DeleteMapping(value = "delete/{employeeId}/allAnswersByEmployeeId")
    void deleteAllAnswersByEmployeeId(@PathVariable Long employeeId);

}



