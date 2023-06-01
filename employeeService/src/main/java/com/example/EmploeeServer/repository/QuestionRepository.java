package com.example.EmploeeServer.repository;

import com.example.EmploeeServer.model.Question;

import java.util.List;

public interface QuestionRepository {
    void createQuestion(Question question)throws Exception;

    void updateQuestion (Long questionId, Question question)throws Exception;
    void deleteQuestion (Long questionId)throws Exception;
    void deleteAllQuestions ()throws Exception;
    Question getQuestionById(long questionId)throws Exception;
    List<Question> getAllQuestions()throws Exception;
}
