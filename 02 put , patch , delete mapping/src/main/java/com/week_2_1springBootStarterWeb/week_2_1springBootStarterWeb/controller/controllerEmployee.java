// controllerEmployee.java
package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.controller;

import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.dto.employeeData;
// import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.entities.employeeEntity;
import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.services.employeeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


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

    @PutMapping(path = "/{employeeId}")    // using the put mapping to update  the whole data
    public employeeData updateEmployeeById(@PathVariable Long employeeId, @RequestBody employeeData employeeData) {
        
        
        return employeeService.updateEmployeeById(employeeData , employeeId);   
    }

    @DeleteMapping(path = "/{employeeId}")   // for deleting the data

    // public void deleteEmployeeById(@PathVariable Long employeeId){  // we set void here bcz we want that our delete data does'nt returns
    //     employeeService.deleteEmployeeById(employeeId);
    // }

    /* but if we want to check that a specific id present in database */
    public boolean deleteEmployeeById(@PathVariable Long employeeId){  // we set void here bcz we want that our delete data does'nt returns
       return employeeService.deleteEmployeeById(employeeId);
    }

    // method to update the particular fields we want.
    @PatchMapping(path = "/{employeeId}")
    public employeeData updatePartiallyEmployeeById(@PathVariable Long employeeId, @RequestBody Map<String , Object > update ) {  // update defines that we want to change the particular string and object instead of all data
        
        
        return employeeService.updatePartiallyEmployeeById( employeeId , update);   
    }
    }

