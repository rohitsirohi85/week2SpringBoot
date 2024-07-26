// controllerEmployee.java
package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.controller;

import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.dto.employeeData;

import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.services.employeeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController       // Marks this class as a REST controller
@RequestMapping(path = "/Employees")     // Maps all requests starting with /Employees to this controller.
public class controllerEmployee {

    private final employeeService employeeService;

    
    public controllerEmployee(employeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")                 // Maps GET requests to /Employees/{employeeId}.
    public employeeData getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);  // for finding the data of a specific id
    }

    @GetMapping         // Maps GET requests to /Employees.
    public List<employeeData> getAllEmployees() {
        return employeeService.getAllEmployees();   // fetch and return data of all employees
    }

    @PostMapping      // Maps POST requests to /Employees
    public employeeData createNewEmployee(@RequestBody employeeData inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);   // Saves and returns the new employee
    }


    }

