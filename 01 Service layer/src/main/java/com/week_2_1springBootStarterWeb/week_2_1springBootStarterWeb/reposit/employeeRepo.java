package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.reposit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.entities.employeeEntity;
   // Marks this interface as a Spring Data repository
@Repository
public interface employeeRepo extends JpaRepository<employeeEntity , Long >{
       // This interface now has CRUD methods for employeeEntity.
}
