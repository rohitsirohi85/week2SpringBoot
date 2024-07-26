package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class employeeData {
   private String name;
   private String email;
   private Integer age;
   private Long id;
   private Boolean isActive;
   private LocalDate dateOfJoining;


   
   /* don't need to do while can use lambok dependency */

   // public employeeData(String name, String email, Integer age, Long id, Boolean isActive, LocalDate dateOfJoining) {
   //    this.name = name;
   //    this.email = email;
   //    this.age = age;
   //    this.id = id;
   //    this.isActive = isActive;
   //    this.dateOfJoining = dateOfJoining;
   // }

   // public employeeData() {
     
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
   // public Long getId() {
   //    return id;
   // }
   // public void setId(Long id) {
   //    this.id = id;
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
