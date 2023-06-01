package AnswersDBServerA.repository.mapper;

import AnswersDBServerA.model.Answer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerMapper implements RowMapper {
    @Override
    public Answer mapRow (ResultSet rs, int rowNum) throws SQLException {
        return new Answer(
             rs.getLong("question_id"),
             rs.getString("answer_selected")
        );





    }

}
