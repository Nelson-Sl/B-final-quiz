package com.example.demo.common;

import com.example.demo.Exception.TraineeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handler (MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        Map<String, String> details = new HashMap<>();
        for(FieldError error: errors) {
            details.put(error.getField(),  error.getDefaultMessage());
        }
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(Constants.FIELD_INVALID_EXCEPTION_MESSAGE)
                .details(details).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(TraineeNotFoundException.class)
    public ResponseEntity<ErrorMessage> userInfoNotFoundExceptionHandler(TraineeNotFoundException ex) {
        String message = ex.getMessage();
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(message).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
