package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

// import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.dto.employeeData;
import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.entities.employeeEntity;
import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.reposit.employeeRepo;

@Service  // Marks this class as a Spring service component
public class employeeService {

    // Dependencies injected via constructor
    private final employeeRepo employeeRepo;
    private final ModelMapper ModelMapper;

    // Constructor for dependency injection
    public employeeService(employeeRepo employeeRepo, ModelMapper ModelMapper) {
        this.employeeRepo = employeeRepo;
        this.ModelMapper = ModelMapper;
    }

    // Method to get an employee by ID
    public employeeData getEmployeeById(Long id) {
        // Find employeeEntity by ID, return null if not found
        employeeEntity employeeEntity = employeeRepo.findById(id).orElse(null);

        // Map employeeEntity to employeeData and return
        return ModelMapper.map(employeeEntity, employeeData.class);
    }

    // Method to get all employees
    public List<employeeData> getAllEmployees() {
        // Fetch all employee entities
        List<employeeEntity> employeeEntities = employeeRepo.findAll();

        // Map each employeeEntity to employeeData and collect as a List
        return employeeEntities                     
                            .stream()
                            .map(employeeEntity -> ModelMapper.map(employeeEntity, employeeData.class))
                            .toList();
    }

    // Method to create a new employee
    public employeeData createNewEmployee(employeeData inputEmployee) {
        // Map inputEmployee (DTO) to employeeEntity
        employeeEntity toSaveEntity = ModelMapper.map(inputEmployee, employeeEntity.class);

        // Save employeeEntity to the repository
        employeeEntity savedEmployeeEntity = employeeRepo.save(toSaveEntity);

        // Map the saved employeeEntity back to employeeData and return
        return ModelMapper.map(savedEmployeeEntity, employeeData.class);
    }

    // Method to update an existing employee by ID
    public employeeData updateEmployeeById(employeeData employeeData, Long employeeId) {
        // Map the provided employeeData (DTO) to employeeEntity
        employeeEntity employeeEntity = ModelMapper.map(employeeData, employeeEntity.class);

        // Set the ID of the employeeEntity to the provided employeeId
        employeeEntity.setId(employeeId);

        // Save the updated employeeEntity to the repository
        employeeEntity savedEmployeeEntity = employeeRepo.save(employeeEntity);

        // Map the saved employeeEntity back to employeeData and return
        return ModelMapper.map(savedEmployeeEntity, employeeData.class);
    }

       /* making a boolean function to call when want to check the existing id available or not for DRY(do not repeat) */
       public boolean isIdExist(Long employeeId){
        return employeeRepo.existsById(employeeId);
       }

          // Method to delete an existing employee by ID
    public boolean deleteEmployeeById(Long employeeId) {   

      boolean exist=employeeRepo.existsById(employeeId);  // it will check the existing employee id
      employeeRepo.deleteById(employeeId);  // deleting id

      if (exist) {  // check if the id is present
        return true;
      }else{
        return false;
      }


    }

public employeeData updatePartiallyEmployeeById(long employeeId, Map<String, Object> update) {
    
    // Check if the employee with the given ID exists in the repository
    boolean exist = employeeRepo.existsById(employeeId);
    
    // If the employee does not exist, return null
    if (!exist) {
        return null;
    }
    
    // Fetch the existing employee entity from the repository
    employeeEntity employeeEntity = employeeRepo.findById(employeeId).get();
    
    // Iterate over each field to be updated and its new value in the update map
    update.forEach((field, value) -> {
        
        // Find the field in the employeeEntity class by its name
        Field fieldToBeUpdated = ReflectionUtils.findField(employeeEntity.class, field);
        
        // Make the field accessible for reflection operations
        fieldToBeUpdated.setAccessible(true);
        
        // Set the new value for the field in the employeeEntity instance
        ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
    });
    
    // Save the updated employee entity to the repository and map it to employeeData
    return ModelMapper.map(employeeRepo.save(employeeEntity), employeeData.class);
}

    }    
      

