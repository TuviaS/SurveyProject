package AnswersDBServerA.repository;

import AnswersDBServerA.model.Answer;
import AnswersDBServerA.model.AnswerServiceResponse;
import AnswersDBServerA.model.FetchedQuestion;
import AnswersDBServerA.model.ReceivedJsonAnswer;
import AnswersDBServerA.model.ReceivedJsonAnswer;
import AnswersDBServerA.repository.mapper.AnswerMapper;
import AnswersDBServerA.service.FetchQuestionsAndEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerRepositoryImplement implements AnswerRepository{
    private static final String ANSWER_TABLE_NAME = "answers";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    FetchQuestionsAndEmployeeService fetchQuestionsAndEmployeeService;
    @Override
    public AnswerServiceResponse createAnswer(ReceivedJsonAnswer receivedJsonAnswer) {
        List<Answer> answerList = receivedJsonAnswer.getAnswerList();
        long employeeId = receivedJsonAnswer.getEmployeeId();
        for (Answer answer : answerList) {
            Long fetchedNum = fetchQuestionsAndEmployeeService.getQuestionById(answer.getQuestionId()).getId();
            if (fetchedNum != null) {
                String sql = "INSERT INTO " + ANSWER_TABLE_NAME +
                        "(employee_id, question_id, answer_selected) VALUES (?, ?, ?);";
                jdbcTemplate.update(
                        sql, employeeId,
                        answer.getQuestionId(),
                        answer.getQuestionAnswer()
                );

            }


        }
        return null;
    }



    @Override
    public AnswerServiceResponse changeAnswer(Long employeeId, Long questionId, String EmployeeResponse) {
        return null;
    }

    @Override
    public List<Answer> getAllAnswersToAllQuestions() {

        String sql = "SELECT * FROM " + ANSWER_TABLE_NAME;
        try {
            return  jdbcTemplate.query (sql, new AnswerMapper());
        }
        catch (EmptyResultDataAccessException error) {
            return null;
        }



    }

    @Override
    public List<Answer> getAllAnswersByEmployeeId(Long employeeId) {

        String sql = "SELECT * FROM " + ANSWER_TABLE_NAME + " WHERE employee_id=?";
        try {

            return jdbcTemplate.query(sql, new AnswerMapper(), employeeId);


        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
    @Override
    public List<Answer> getAllAnswersByQuestionId(Long questionId) {
        String sql = "SELECT question_id, answer_selected FROM " + ANSWER_TABLE_NAME + " WHERE question_id = ?";
        List<Answer> answerList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Long qId = rs.getLong("question_id");
            String answerSelected = rs.getString("answer_selected");
            return new Answer(qId, answerSelected);
        }, questionId);
        return answerList;
    }

    @Override
    public AnswerServiceResponse getSpecificAnswerByEmployee(Long employeeId, Long questionId) {
        return null;
    }

    @Override
    public AnswerServiceResponse getAllAnswersToSpecificQuestionByQuestionId(Long QuestionId) {
        return null;
    }

    @Override
    public AnswerServiceResponse deleteAnswer(Long employeeId, Long questionId, String EmployeeResponse) {
        return null;
    }

    @Override
    public void deleteAllAnswersByEmployeeId(Long employeeId) {
    String sql = " DELETE FROM " + ANSWER_TABLE_NAME + " WHERE employee_id=?";
        jdbcTemplate.update(
                sql, employeeId);
    }

    @Override
    public AnswerServiceResponse deleteAllAnswersByQuestionId(Long questionId) {
        String sql = " DELETE FROM " + ANSWER_TABLE_NAME + " WHERE question_id=?";
        jdbcTemplate.update(
                sql, questionId);
        return null;
    };


}
