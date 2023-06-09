package com.example.EmploeeServer.controller;

import com.example.EmploeeServer.model.NoticeToUser;
import com.example.EmploeeServer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.EmploeeServer.model.Employee;
import java.util.List;
@RestController

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping (value = "employee/create")
    public NoticeToUser createEmployee (@RequestBody Employee employee)throws  Exception {
        return employeeService.createEmployee(employee);

    }

    @PutMapping (value = "employee/update")
    public NoticeToUser updateEmployeeById (@RequestBody Employee employee)throws  Exception {
        return employeeService.updateEmployeeById(employee);

    }

    @GetMapping (value = "employee/{personalId}")
    public Employee getEmployeeByPersonalId (@PathVariable long personalId) throws Exception{
        return employeeService.getEmployeeByPersonalId(personalId);
    }
    @GetMapping (value = "employee/getAllEmployees")
    public List<Employee> getEmployeeByPersonalId () throws Exception{
        return employeeService.getAllEmployees();
    }

    @DeleteMapping (value = "employee/{personalId}/delete")
    public NoticeToUser deleteEmployeeById (@PathVariable long personalId) throws Exception {
        return employeeService.deleteEmployeeById(personalId);
    }
    @DeleteMapping (value = "employee/deleteAllEmployees")
    public NoticeToUser deleteAllEmployees()  {
        return employeeService.bankruptDeleteAllEmployees();
    }

}
