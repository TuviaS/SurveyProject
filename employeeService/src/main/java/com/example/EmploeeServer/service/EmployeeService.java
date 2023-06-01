package com.example.EmploeeServer.service;

import com.example.EmploeeServer.model.Employee;

import com.example.EmploeeServer.model.NoticeToUser;

import java.util.List;

public interface EmployeeService {

    NoticeToUser createEmployee (Employee employee) throws Exception;
    NoticeToUser updateEmployeeById (Employee employee) throws Exception;
    NoticeToUser deleteEmployeeById (long personalId) throws Exception;
    Employee getEmployeeByPersonalId (long personalId) throws Exception;
    List<Employee> getAllEmployees ();
    NoticeToUser bankruptDeleteAllEmployees ();
    List <Employee> getEmployeeWhoDidNotReply ();
    List <Employee> getEmployeesWhoReplied ();

}
