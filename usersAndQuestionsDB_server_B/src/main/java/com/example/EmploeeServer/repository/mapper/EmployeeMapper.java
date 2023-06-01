package com.example.EmploeeServer.repository.mapper;

import com.example.EmploeeServer.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper <Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
                rs.getLong("id"),
                rs.getLong("personal_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email")
        );

    }
}
