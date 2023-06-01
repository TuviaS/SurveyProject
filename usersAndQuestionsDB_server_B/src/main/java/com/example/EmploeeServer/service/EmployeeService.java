package com.example.EmploeeServer.service;

import com.example.EmploeeServer.model.Employee;

import com.example.EmploeeServer.model.Notice;

import java.util.List;

public interface EmployeeService {

    Notice createEmployee (Employee employee) throws Exception;
    Notice updateEmployeeById (Employee employee) throws Exception;
    Notice deleteEmployeeById (long personalId) throws Exception;
    Employee getEmployeeByPersonalId (long personalId) throws Exception;
    List<Employee> getAllEmployees ();
    Notice bankruptDeleteAllEmployees ();
    List <Employee> getEmployeeWhoDidNotReply ();
    List <Employee> getEmployeesWhoReplied ();

}
