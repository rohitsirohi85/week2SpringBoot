package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.custom_annotation;



import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/* logic for validation */
public class employeeRoleValidator implements ConstraintValidator<employeeRoleCustomAnnotation , String> { //<validationClassName , Datatype of validation for which you want to make>

    @Override
    public boolean isValid(String inputroles, ConstraintValidatorContext context) {
        List<String>roles=List.of("user" , "admin" , "manager"); // means that only user ,admin, manager contain by roles that true otherwise false
        return roles.contains(inputroles); 
    }
    
}
