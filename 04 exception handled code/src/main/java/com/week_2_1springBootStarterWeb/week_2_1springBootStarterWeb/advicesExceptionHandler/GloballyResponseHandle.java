package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.advicesExceptionHandler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class GloballyResponseHandle implements ResponseBodyAdvice<Object> {

    // Supports all controller methods
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    // Modify the response body before sending it
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // If the body is already an instance of ApiResponse, return it as is
        if (body instanceof ApiResponse<?>) {
            return body;
        }
        // Wrap the body in an ApiResponse object
        return new ApiResponse<>(body);
    }
}
