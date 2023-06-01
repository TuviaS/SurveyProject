package com.example.EmploeeServer.service;

import com.example.EmploeeServer.model.Notice;
import com.example.EmploeeServer.model.Question;

import java.util.List;

public interface QuestionService {
    Notice createQuestion(Question question)throws Exception;

    Notice updateQuestion (Long questionId, Question question)throws Exception;
    Notice deleteQuestion (Long questionId)throws Exception;
    Notice deleteAllQuestions ()throws Exception;
    Question getQuestionById(Long questionId)throws Exception;
    List<Question> getAllQuestions()throws Exception;
}
