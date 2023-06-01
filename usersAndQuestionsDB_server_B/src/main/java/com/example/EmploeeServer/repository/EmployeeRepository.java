package com.example.EmploeeServer.repository;

import com.example.EmploeeServer.model.Employee;

import com.example.EmploeeServer.model.Notice;

import java.util.List;

public interface EmployeeRepository {
    Notice createEmployee (Employee employee) throws Exception;
    Notice updateEmployeeById (Employee employee) throws Exception;
    void deleteEmployeeById (long personal_id) throws Exception;
    Employee getEmployeeByPersonalId (Long personalId) throws Exception;

    List<Employee> getAllEmployees ();
    Notice bankruptDeleteAllEmployees ();
    List <Employee> getEmployeeWhoDidNotReply ();
    List <Employee> getEmployeesWhoReplied ();
    //List<answers...> getQeustionsEmployeeDidNotAnswer(Employee employee);
}
