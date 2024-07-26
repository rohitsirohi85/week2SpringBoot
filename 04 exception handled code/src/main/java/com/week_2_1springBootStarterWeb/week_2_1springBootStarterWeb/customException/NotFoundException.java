package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.customException;


// here we creating our own exception
public class NotFoundException extends RuntimeException {

   public NotFoundException(String message){
    super(message);
   }

    
    
}
