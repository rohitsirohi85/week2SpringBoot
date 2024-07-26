package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.advicesExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

//import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.customException.NotFoundException;

// import jakarta.el.MethodNotFoundException;

@RestControllerAdvice
// it will handle the exception all over globally
public class GloballyHandleException {
      @ExceptionHandler(NotFoundException.class)  // so it will handle the NoSuchElementException from code
     public ResponseEntity<ApiResponse<?>> hadlingResourceNotFound(  NotFoundException exception){
        ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(exception.getMessage()).build();
        return buildErrorResponseEntity(apiError);
     }

     // let say if we want to make an exception msg for all exception
     
    

   @ExceptionHandler(Exception.class) // exception.class contains the all exceptions
     public ResponseEntity<ApiResponse<?>> defaultException(Exception exception){
        ApiError apiError = ApiError.builder().
        status(HttpStatus.INTERNAL_SERVER_ERROR)
        .message(exception.getMessage()).
        build();
        return buildErrorResponseEntity(apiError);
     }

     // for enhancing the list of error occurred

     @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<ApiResponse<?>> handleInput(MethodArgumentNotValidException exception){
        List<String> errors = exception
                    .getBindingResult()
                    .getAllErrors()
                    .stream()
                    .map( error -> error.getDefaultMessage())
                    .collect(Collectors.toList());

                    ApiError apiError =ApiError.builder()
                                              .status(HttpStatus.BAD_REQUEST)
                                              .message("input validation failed")
                                              .subErrors(errors)
                                              .build();

                            return buildErrorResponseEntity(apiError);                  
                            
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
      return new ResponseEntity<>(new ApiResponse<>(apiError) , apiError.getStatus());
    }
}
