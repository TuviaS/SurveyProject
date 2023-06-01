package com.example.EmploeeServer.service;

import com.example.EmploeeServer.model.NoticeToUser;
import com.example.EmploeeServer.model.Question;
import com.example.EmploeeServer.repository.QuestionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImplement implements QuestionService{
@Autowired
    QuestionRepository questionRepository;
@Autowired
    FetchedAndManipulatedAnswersService fetchedAndManipulatedAnswersService;
    @Autowired
    ObjectMapper objectMapper;
    @Override
    public NoticeToUser createQuestion(Question question) throws Exception {
        if (question.getAnswerA() ==null || question.getAnswerB() == null || question.getAnswerC()==null || question.getAnswerD() ==null || question.getQuestionIs() == null) {
            return new NoticeToUser( "You have a mistake - check to see you have a question, and 4 answers");
        } else
            {questionRepository.createQuestion(question);
            return new NoticeToUser("Added.");
        }

    }

    @Override
    public NoticeToUser updateQuestion(Long questionId, Question question) throws Exception {
        if (questionRepository.getQuestionById(questionId).getQuestionId() == null) {
            return new NoticeToUser( "Question number doesn't exist.");
        } else
        {questionRepository.updateQuestion(questionId, question);
            return new NoticeToUser("Amended. Use /questions/all to see the updated question and answers list");
        }

    }

    @Override
    public NoticeToUser deleteQuestion(Long questionId) throws Exception {
        questionRepository.deleteQuestion(questionId);
        fetchedAndManipulatedAnswersService.deleteAllAnswersByQuestionId(questionId);
        return new NoticeToUser("Question number " + questionId + " and all of its answers in the Answer Service DB have been deleted. happy now?!");


    }

    @Override
    public NoticeToUser deleteAllQuestions() throws Exception {
        questionRepository.deleteAllQuestions();
        return new NoticeToUser("All questions have been deleted. Don't ask.");

    }

    @Override
    public Question getQuestionById(Long questionId) throws Exception {
        return questionRepository.getQuestionById(questionId);
    }

    @Override
    public List<Question> getAllQuestions() throws Exception {
        return questionRepository.getAllQuestions();

    }
}
