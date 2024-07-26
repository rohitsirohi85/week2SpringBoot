package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter  // for applying getters 
@Setter  // fro applying setters 
@AllArgsConstructor  // for applying all arguments constructor
@NoArgsConstructor   // for applying default constructor
@Table(name = "Employees")
public class employeeEntity {

   @Id       // Marks this field as the primary key.
   @GeneratedValue(strategy = GenerationType.AUTO)         // Configures the way of increment of the specified column(field).

   private  Long id;
   private String name;
   private String email;
   private Integer age;
   private String isActive;
   private String role;
   private Integer prime;

    private double salary;
   private LocalDate dateOfJoining;

  

/* we don't need to make constructor or getter setter manually while we can use lambok dependency annotation */
   
   // public employeeEntity(Long id, String name, String email, Integer age, Boolean isActive, LocalDate dateOfJoining) {
   //    this.id = id;
   //    this.name = name;
   //    this.email = email;
   //    this.age = age;
   //    this.isActive = isActive;
   //    this.dateOfJoining = dateOfJoining;
   // }
   // public employeeEntity() {
      
   // }
   // public Long getId() {
   //    return id;
   // }
   // public void setId(Long id) {
   //    this.id = id;
   // }
   // public String getName() {
   //    return name;
   // }
   // public void setName(String name) {
   //    this.name = name;
   // }
   // public String getEmail() {
   //    return email;
   // }
   // public void setEmail(String email) {
   //    this.email = email;
   // }
   // public Integer getAge() {
   //    return age;
   // }
   // public void setAge(Integer age) {
   //    this.age = age;
   // }
   // public Boolean getIsActive() {
   //    return isActive;
   // }
   // public void setIsActive(Boolean isActive) {
   //    this.isActive = isActive;
   // }
   // public LocalDate getDateOfJoining() {
   //    return dateOfJoining;
   // }
   // public void setDateOfJoining(LocalDate dateOfJoining) {
   //    this.dateOfJoining = dateOfJoining;
   // }



}
