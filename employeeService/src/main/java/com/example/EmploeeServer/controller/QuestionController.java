package com.example.EmploeeServer.controller;

import com.example.EmploeeServer.model.NoticeToUser;
import com.example.EmploeeServer.model.Question;
import com.example.EmploeeServer.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    //@Autowired
    //InternalCustomerService internalCustomerService;

    @PostMapping (value = "question/create")
    public NoticeToUser createQuestion (@RequestBody Question question)throws  Exception {
        return questionService.createQuestion(question);


    }
    @PutMapping (value = "question/{questionId}/update")
    public NoticeToUser updateQuestion (@PathVariable Long questionId, @RequestBody Question question) throws Exception {
        return  questionService.updateQuestion(questionId, question);

    }


    @GetMapping(value = "question/{questionId}")
    public Question getQuestionById (@PathVariable long questionId) throws Exception{
        return questionService.getQuestionById(questionId);
    }

    @GetMapping(value = "question/all")
    public List<Question> getAllQuestions () throws Exception{
        return questionService.getAllQuestions();
    }

    @DeleteMapping (value = "question/{questionId}/delete")
    public NoticeToUser deleteQuestionById (@PathVariable long questionId) throws  Exception {
        return questionService.deleteQuestion(questionId);
    }
    @DeleteMapping (value = "question/all/delete")
    public NoticeToUser deleteAllQuestions () throws  Exception {
        return questionService.deleteAllQuestions();

    }


}
