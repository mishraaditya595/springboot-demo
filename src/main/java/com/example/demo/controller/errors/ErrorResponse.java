package com.example.demo.controller.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {

    private HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd hh:mm:ss")
    private LocalDateTime timeStamp;
    private String message;
    public ErrorResponse() {
        timeStamp = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus httpStatus, LocalDateTime timeStamp, String message) {
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public ErrorResponse(HttpStatus httpStatus, String message) {
        this();
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ErrorResponse(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
