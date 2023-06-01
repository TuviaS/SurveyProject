package com.example.EmploeeServer.repository.mapper;

import com.example.EmploeeServer.model.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Question(
                rs.getLong("id"),
                rs.getString("questionIs"),
                rs.getString("answerA"),
                rs.getString("answerB"),
                rs.getString("answerC"),
                rs.getString("answerD")
        );
    }
}
