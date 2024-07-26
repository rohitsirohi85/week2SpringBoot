package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.advicesExceptionHandler;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse<T> {

    private T data;
    private LocalDateTime TimeStamp;
    private ApiError error;

    // Constructor for initializing with data
    public ApiResponse(T data) {
        this.data = data;
        this.TimeStamp = LocalDateTime.now(); // Set current time
    }

    // Constructor for initializing with error
    public ApiResponse(ApiError error) {
        this.error = error;
        this.TimeStamp = LocalDateTime.now(); // Set current time
    }

    // Constructor for initializing with specific timestamp (not necessary, but for flexibility)
    public ApiResponse(T data, LocalDateTime timeStamp) {
        this.data = data;
        this.TimeStamp = timeStamp;
    }
}
