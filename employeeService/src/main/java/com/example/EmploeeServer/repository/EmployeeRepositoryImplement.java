package com.example.EmploeeServer.repository;

import com.example.EmploeeServer.model.Employee;

import com.example.EmploeeServer.model.NoticeToUser;
import com.example.EmploeeServer.repository.mapper.EmployeeMapper;
import com.example.EmploeeServer.service.FetchedAndManipulatedAnswersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImplement implements EmployeeRepository{
    private static final String EMPLOYEE_TABLE_NAME = "employee";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    FetchedAndManipulatedAnswersService fetchedAndManipulatedAnswersService;


    @Override
    public NoticeToUser createEmployee(Employee employee) throws Exception {
        String sql = "INSERT INTO " + EMPLOYEE_TABLE_NAME +
                "(personal_id, first_name, last_name, email) VALUES (?, ?, ?,?);" +
                " SELECT LAST_INSERT_ID();";
         jdbcTemplate.update(
                sql,
                employee.getPersonalId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
                );
        return null;
        //return (long) insertedId;
    }

    @Override
    public NoticeToUser updateEmployeeById(Employee employee) throws Exception {
        long id = employee.getPersonalId();
        String sql = "UPDATE "+ EMPLOYEE_TABLE_NAME + " SET first_name=?, last_name=?, email=?" +
                " WHERE personal_id=?";
        jdbcTemplate.update(
            sql,
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail(), id);
        return null;
    }


    @Override
    public void deleteEmployeeById(long personal_id) throws Exception {
        String sql = "DELETE FROM " + EMPLOYEE_TABLE_NAME + " WHERE personal_id=?";
        jdbcTemplate.update(sql, personal_id);


    }


    @Override
    public Employee getEmployeeByPersonalId(Long personalId) throws Exception {
        String sql = "SELECT * FROM " + EMPLOYEE_TABLE_NAME + " WHERE personal_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), personalId);
        } catch (EmptyResultDataAccessException error) {
            return new Employee (null,null ,"Such employee personal ID not found. Check your lists using /employee/getAllEmployees","", "");
        }





    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM " + EMPLOYEE_TABLE_NAME;
        try {
            return  jdbcTemplate.query (sql, new EmployeeMapper());
        }
        catch (EmptyResultDataAccessException error) {
           return null;
        }

    }

    @Override
    public NoticeToUser bankruptDeleteAllEmployees() {
        String sql = "DELETE FROM" +  EMPLOYEE_TABLE_NAME;
        jdbcTemplate.update(sql);
        return null;
    }

    @Override
    public List<Employee> getEmployeeWhoDidNotReply() {
        return null;
    }

    @Override
    public List<Employee> getEmployeesWhoReplied() {
        return null;
    }
}
