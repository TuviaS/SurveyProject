package com.example.EmploeeServer.service;

import com.example.EmploeeServer.model.NoticeToUser;
import com.example.EmploeeServer.model.Question;

import java.util.List;

public interface QuestionService {
    NoticeToUser createQuestion(Question question)throws Exception;

    NoticeToUser updateQuestion (Long questionId, Question question)throws Exception;
    NoticeToUser deleteQuestion (Long questionId)throws Exception;
    NoticeToUser deleteAllQuestions ()throws Exception;
    Question getQuestionById(Long questionId)throws Exception;
    List<Question> getAllQuestions()throws Exception;
}
