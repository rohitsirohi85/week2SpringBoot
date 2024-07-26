package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.custom_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Retention(RetentionPolicy.RUNTIME) //means we want to run the annotation at runtime
@Target({ElementType.FIELD})  // means we want that our annotation only work on field  we can also create with parameter , method nad etc check with ctrl+click on element type

@Constraint(validatedBy = {employeeRoleValidator.class}) //means connect this validation annotation with employeeRolevalidator.class so it can implement those logic and fields 

/* structure of validation annotation */
public @interface employeeRoleCustomAnnotation {
    String message() default "role can be admin or user";  //this is the default msg

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}

// now we can call @employeeRoleCustomAnnotation and it will check that given String is admin,user,manager or not bcz we give these in employeeRoleValidator.class to validate these ..
