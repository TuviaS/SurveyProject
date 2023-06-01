package com.example.EmploeeServer.service;

import com.example.EmploeeServer.model.Employee;

import com.example.EmploeeServer.model.Notice;
import com.example.EmploeeServer.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;
@Service
public class EmployeeServiceImplement implements EmployeeService{
    @Autowired
    FetchedAndManipulatedAnswersService fetchedAndManipulatedAnswersService;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ObjectMapper objectMapper;


    //Create employee
    @Override
    public Notice createEmployee(Employee employee) throws Exception {
        String employeeStringed = objectMapper.writeValueAsString(employee);
        Employee existingEmployee = employeeRepository.getEmployeeByPersonalId(employee.getPersonalId());
        if (existingEmployee.getPersonalId() !=null) {
            return new Notice(employee.getFirstName() + employee.getLastName() + "Id number " + employee.getPersonalId() + " exists, cannot create another. One is enough, isn't it?!");
        } else {
            employeeRepository.createEmployee(employee);
            return new Notice(employee.getFirstName() + employee.getLastName() + "Id number " + employee.getPersonalId() + " was created.");
        }


    }



    //Update employee


    @Override
    public Notice updateEmployeeById(Employee employee) throws Exception {
        String employeeStringed = objectMapper.writeValueAsString(employee);
        try {
            Employee existingEmployee = employeeRepository.getEmployeeByPersonalId(employee.getPersonalId());
            employeeRepository.updateEmployeeById(employee);
            employee = employeeRepository.getEmployeeByPersonalId(employee.getPersonalId());
            return new Notice(" The details of the employee " + employee.getFirstName() + " " + employee.getLastName()+ " personal ID number " + employee.getPersonalId() + " have been updated");
            }

        catch (EmptyResultDataAccessException error) {
            return new Notice("An employee with Personal Id number " + employee.getPersonalId() + " doesn't exists, cannot update.");

        }


    }
// Kill employee

    @Override
    public Notice deleteEmployeeById(long personalId) throws Exception {
        Employee deadManWalking = getEmployeeByPersonalId(personalId);
        if (deadManWalking==null) {return new Notice("user does not exist. chc your lists");}
        else{employeeRepository.deleteEmployeeById(personalId);
        }
            try {
                fetchedAndManipulatedAnswersService.deleteAllAnswersByEmployeeId(personalId);
            } catch (Exception error) {return new Notice("Survey service error - Employee was deleted, but his answers are still in the survey server.");}
            return new Notice(deadManWalking.getFirstName() + " " + deadManWalking.getLastName() + " has been removed from the Database, along with the answers given by that employee");
}



    @Override
    public Employee getEmployeeByPersonalId(long personalId) throws Exception {
        return employeeRepository.getEmployeeByPersonalId(personalId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Notice bankruptDeleteAllEmployees() {
        employeeRepository.bankruptDeleteAllEmployees();
        return new Notice("Wev'e gone bankrupt. Go home yerall. *All employees deleted from the DataBase*");
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
