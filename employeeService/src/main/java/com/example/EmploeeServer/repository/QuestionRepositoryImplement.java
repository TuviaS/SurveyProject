package com.example.EmploeeServer.repository;

import com.example.EmploeeServer.model.Question;
import com.example.EmploeeServer.repository.mapper.QuestionMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class QuestionRepositoryImplement implements QuestionRepository{
    private static final String QUESTION_TABLE_NAME = "questions";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void createQuestion(Question question) throws Exception{
        String sql = "INSERT INTO " + QUESTION_TABLE_NAME +
                "(questionIs, answerA, answerB, answerC, answerD) VALUES (?, ?, ?, ?, ?);";

        jdbcTemplate.update(
                sql,
                question.getQuestionIs(),
                question.getAnswerA(),
                question.getAnswerB(),
                question.getAnswerC(),
                question.getAnswerD()
        );


    }

    @Override
    public void updateQuestion(Long questionId, Question question) {
        String sql = "UPDATE " + QUESTION_TABLE_NAME + " SET questionIs = ?, answerA = ?, answerB = ?, answerC = ?, answerD = ?" +
                " WHERE id=?";

        jdbcTemplate.update(
                sql,
                question.getQuestionIs(),
                question.getAnswerA(),
                question.getAnswerB(),
                question.getAnswerC(),
                question.getAnswerD(), questionId);

    }

       @Override
    public void  deleteQuestion(Long questionId) {
        String sql = "DELETE FROM " + QUESTION_TABLE_NAME + " WHERE id=?";
        try {
            Question checkQuestion = getQuestionById (questionId);
            jdbcTemplate.update(sql, questionId);
           } catch (Exception error) {

        }

    }

    @Override
    public void deleteAllQuestions() {
        String sql = "DELETE FROM " + QUESTION_TABLE_NAME;
        jdbcTemplate.update(sql);



    }

    @Override
    public Question getQuestionById(long questionId) throws Exception{
        String sql = "SELECT * FROM " + QUESTION_TABLE_NAME + " WHERE id=?";
        try {
            return (Question) jdbcTemplate.queryForObject(sql, new QuestionMapper(), questionId);
        } catch (Exception error) {
            return new Question(null,"This is an Error reply: Question number not found. Check your lists by using /question/{questionId}",null,null,null,null);

        }

    }



    @Override
    public List<Question> getAllQuestions() {
        String sql = "SELECT * FROM " + QUESTION_TABLE_NAME;
        try {
            return  jdbcTemplate.query (sql, new QuestionMapper());
        }
        catch (EmptyResultDataAccessException error) {
        }
        return null;

    }
}
