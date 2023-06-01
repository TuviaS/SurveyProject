package com.example.EmploeeServer.service;

import com.example.EmploeeServer.model.Employee;

import com.example.EmploeeServer.model.NoticeToUser;
import com.example.EmploeeServer.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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
    public NoticeToUser createEmployee(Employee employee) throws Exception {
        String employeeStringed = objectMapper.writeValueAsString(employee);
        Employee existingEmployee = employeeRepository.getEmployeeByPersonalId(employee.getPersonalId());
        if (existingEmployee.getPersonalId() !=null) {
            return new NoticeToUser(employee.getFirstName() + employee.getLastName() + "Id number " + employee.getPersonalId() + " exists, cannot create another. One is enough, isn't it?!");
        } else {
            employeeRepository.createEmployee(employee);
            return new NoticeToUser(employee.getFirstName() + employee.getLastName() + "Id number " + employee.getPersonalId() + " was created.");
        }


    }



    //Update employee


    @Override
    public NoticeToUser updateEmployeeById(Employee employee) throws Exception {
        String employeeStringed = objectMapper.writeValueAsString(employee);
        try {
            Employee existingEmployee = employeeRepository.getEmployeeByPersonalId(employee.getPersonalId());
            employeeRepository.updateEmployeeById(employee);
            employee = employeeRepository.getEmployeeByPersonalId(employee.getPersonalId());
            return new NoticeToUser(" The details of the employee " + employee.getFirstName() + " " + employee.getLastName()+ " personal ID number " + employee.getPersonalId() + " have been updated");
            }

        catch (EmptyResultDataAccessException error) {
            return new NoticeToUser("An employee with Personal Id number " + employee.getPersonalId() + " doesn't exists, cannot update.");

        }


    }
// Kill employee

    @Override
    public NoticeToUser deleteEmployeeById(long personalId) throws Exception {
        Employee deadManWalking = getEmployeeByPersonalId(personalId);
        if (deadManWalking==null) {return new NoticeToUser("user does not exist. chc your lists");}
        else{employeeRepository.deleteEmployeeById(personalId);
        }
            try {
                fetchedAndManipulatedAnswersService.deleteAllAnswersByEmployeeId(personalId);
            } catch (Exception error) {return new NoticeToUser("Survey service error - Employee was deleted, but his answers are still in the survey server.");}
            return new NoticeToUser(deadManWalking.getFirstName() + " " + deadManWalking.getLastName() + " has been removed from the Database, along with the answers given by that employee");
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
    public NoticeToUser bankruptDeleteAllEmployees() {
        employeeRepository.bankruptDeleteAllEmployees();
        return new NoticeToUser("Wev'e gone bankrupt. Go home yerall. *All employees deleted from the DataBase*");
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
