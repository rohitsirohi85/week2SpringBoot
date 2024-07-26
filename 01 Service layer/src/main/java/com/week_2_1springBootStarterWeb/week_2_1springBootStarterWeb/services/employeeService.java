package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.services;
import java.util.List;
// import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.dto.employeeData;
import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.entities.employeeEntity;
import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.reposit.employeeRepo;

@Service
public class employeeService {
    private final employeeRepo employeeRepo;
    private final ModelMapper ModelMapper;

 public employeeService(employeeRepo employeeRepo, ModelMapper ModelMapper) {
        this.employeeRepo = employeeRepo;
        this.ModelMapper = ModelMapper;
    }
    public employeeData getEmployeeById(Long id) {
          employeeEntity employeeEntity= employeeRepo.findById(id).orElse(null);

        return ModelMapper.map(employeeEntity, employeeData.class);
     }
   public List<employeeData> getAllEmployees() {
       List<employeeEntity> employeeEntities =  employeeRepo.findAll();
       return employeeEntities                     
                            .stream()
                            .map(employeeEntity -> ModelMapper.map(employeeEntity, employeeData.class))
                            .toList();
    }
   public employeeData createNewEmployee(employeeData inputEmployee) {
        
            employeeEntity toSaveEntity = ModelMapper.map(inputEmployee, employeeEntity.class);
            employeeEntity savedEmployeeEntity = employeeRepo.save(toSaveEntity);
            return ModelMapper.map(savedEmployeeEntity, employeeData.class);
           }  
}
