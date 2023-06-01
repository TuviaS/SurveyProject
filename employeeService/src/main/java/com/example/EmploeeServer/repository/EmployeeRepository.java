package com.example.EmploeeServer.repository;

import com.example.EmploeeServer.model.Employee;

import com.example.EmploeeServer.model.NoticeToUser;

import java.util.List;

public interface EmployeeRepository {
    NoticeToUser createEmployee (Employee employee) throws Exception;
    NoticeToUser updateEmployeeById (Employee employee) throws Exception;
    void deleteEmployeeById (long personal_id) throws Exception;
    Employee getEmployeeByPersonalId (Long personalId) throws Exception;

    List<Employee> getAllEmployees ();
    NoticeToUser bankruptDeleteAllEmployees ();
    List <Employee> getEmployeeWhoDidNotReply ();
    List <Employee> getEmployeesWhoReplied ();
    //List<answers...> getQeustionsEmployeeDidNotAnswer(Employee employee);
}
