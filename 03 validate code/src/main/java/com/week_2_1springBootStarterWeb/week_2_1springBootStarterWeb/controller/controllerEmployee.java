// controllerEmployee.java
package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.controller;

import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.dto.employeeData;
import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.services.employeeService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController       // Marks this class as a REST controller
@RequestMapping(path = "/Employees")     // Maps all requests starting with /Employees to this controller.
public class controllerEmployee {

    private final employeeService employeeService;

    
    public controllerEmployee(employeeService employeeService) {
        this.employeeService = employeeService;
    }

     // Maps GET requests to /Employees/{employeeId}
     @GetMapping(path = "/{employeeId}")
     public ResponseEntity<employeeData> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
         // Call the service method to get the employee by ID, wrapped in an Optional
         Optional<employeeData> employeeData = employeeService.getEmployeeById(id);
 
         // If employeeData is present, return a 200 OK response with the employee data
         // If not present, return a 404 Not Found response
         return employeeData
                 .map(employeeData01 -> ResponseEntity.ok(employeeData01))
                 .orElse(ResponseEntity.notFound().build());
     }
 
     // Maps GET requests to /Employees to fetch all employees
     @GetMapping
     public ResponseEntity<List<employeeData>> getAllEmployees() {
         // Call the service method to get all employees and return a 200 OK response with the list of employees
         return ResponseEntity.ok(employeeService.getAllEmployees());
     }
 
     // Maps POST requests to /Employees to create a new employee
     @PostMapping
     public ResponseEntity<employeeData> createNewEmployee(@RequestBody @Valid employeeData inputEmployee) {
         // Call the service method to create a new employee and get the saved employee data
         employeeData savedData = employeeService.createNewEmployee(inputEmployee);
 
         // Return a 201 Created response with the saved employee data
         return new ResponseEntity<>(savedData, HttpStatus.CREATED);
     }
 

    @PutMapping(path = "/{employeeId}")    // using the put mapping to update  the whole data
    public ResponseEntity<employeeData> updateEmployeeById(@PathVariable Long employeeId, @RequestBody employeeData employeeData) {
        
        //if update complete return 200 ok
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeData , employeeId));   
    }

    // Annotation to map HTTP DELETE requests to this method
    @DeleteMapping(path = "/{employeeId}")   // for deleting the data


    /* but if we want to check that a specific id present in database */
public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {

    // Calls the service method to delete the employee by the given ID
    Boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);

    // If the deletion was successful (gotDeleted is true), return a 200 OK response with true
    if (gotDeleted) {
        return ResponseEntity.ok(true);
    } else {
        // If the deletion was not successful (gotDeleted is false, likely because the employee was not found),
        // return a 404 Not Found response
        return ResponseEntity.notFound().build();
    }
}


    // method to update the particular fields we want.
   @PatchMapping(path = "/{employeeId}")
public ResponseEntity<employeeData> updatePartiallyEmployeeById(@PathVariable Long employeeId, @RequestBody Map<String, Object> update) {
    
    // @PatchMapping: Specifies that this method will handle PATCH requests to "/{employeeId}".
    // @PathVariable: Extracts the employeeId from the URL path.
    // @RequestBody: Indicates that the method parameter update will be populated with the request body.

    // Call the service method to update the employee partially
    employeeData employeeData = employeeService.updatePartiallyEmployeeById(employeeId, update);
    
    // Check if the returned employeeData is null (i.e., the employee with the given ID does not exist)
    if (employeeData == null) {
        // Return a 404 Not Found response if the employee does not exist
        return ResponseEntity.notFound().build();
    } else {
        // Return a 200 OK response with the updated employee data if the update was successful
        return ResponseEntity.ok(employeeData);
    }
}

    }

