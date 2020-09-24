package com.example.demo.Exception;

public class TraineeNotFoundException extends RuntimeException{
    public TraineeNotFoundException(String message) {
        super(message);
    }
}
