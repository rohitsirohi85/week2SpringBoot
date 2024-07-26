package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.custom_annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class primeValidator implements ConstraintValidator<primeValidation , Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
       if (value==1 || value <=1) {
        return false;
       }
       
       for (int i = 2; i < value; i++) {  // bcz prime numbers can only divisible by 1 and itself
        if (value%i==0) {
            return false;
        }
    }
    return true;
    }
    
}
