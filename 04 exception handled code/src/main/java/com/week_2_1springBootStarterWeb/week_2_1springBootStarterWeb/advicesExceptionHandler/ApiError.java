package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.advicesExceptionHandler;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;



@Data    // it is an lombok annotation which reduce @getter , @setter , and constructor and much more code
@Builder
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> subErrors;

}
