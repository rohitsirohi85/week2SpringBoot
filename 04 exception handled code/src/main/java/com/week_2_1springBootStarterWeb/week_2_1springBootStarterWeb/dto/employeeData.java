package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.custom_annotation.employeeRoleCustomAnnotation;
import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.custom_annotation.primeValidation;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class employeeData {

   /* for id */
   private Long id;

   /* for name */

   @NotNull(message = "name required")  // name string must be required ....(error when "name":  not using)
   @NotEmpty(message = "name can't be empty")  // name field cannot be empty..(error whenn "name": ""  is blank)
   @NotBlank(message = "name must be a valid name and not null") // (error when "name": "     "  is a space and null)
 /* size annotation used for string and array */  
 @Size(min = 3 , max = 10 , message = "enter a size between 3 to 10") // (error when name smaller than 3 and greater than 10)
   private String name;

   /* for mail */
   @NotNull(message = "email required")
   @Email(message = "enter valid format like - this@gmail.com")
   private String email;
   
   /* for age */
   @NotNull(message = "age required")
   @Max(value = 80 , message = "age cannot greater than 80")
   @Min(value = 18 , message = "cannot smaller than 18")    //used for numbers
   private Integer age;

   /* for isActive */
  @NotNull(message = "isActive required")
   @Pattern(regexp = "^(true|false)$",message = "isActive can be true or false")  // this is just a basic of pattern expression we can make more complex logic with pattern help
   private String isActive;


   /* for role */
   @NotNull(message = "role can't be null")
   @employeeRoleCustomAnnotation
   private String role;

   /* check the prime */
   @primeValidation
   private Integer prime;

   /* for salary */

   @NotNull(message = "salary required")
   @Digits( integer = 5 , fraction = 2, message = "form of XXXXX.YY")
   @DecimalMax(value = "10000.99") // salary must be smaller than this
   @DecimalMin(value = "100.01") // salary must be greater than this
   private double salary;

   /* for date of joining */
   @NotNull(message = "joining date required")
   @PastOrPresent(message = "date must be valid")
   private LocalDate dateOfJoining;

   /* don't need to make constructor and getter setter manually while can use lambok dependency */

   

}
