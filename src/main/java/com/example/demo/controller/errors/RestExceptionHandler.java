package com.example.demo.controller.errors;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return new ResponseEntity<Object>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleSQLIntegrityException(
            HttpServletRequest request,
            SQLIntegrityConstraintViolationException exception) {

        String errorMsg = "Unable to submit post" + exception.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, errorMsg));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(
            HttpServletRequest request,
            NoSuchElementException exception) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND);
        errorResponse.setMessage("The row for the address is not existent" + request.getRequestURI());

        return buildResponseEntity(errorResponse);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Object> handleNumberFormatException(
            HttpServletRequest request,
            NumberFormatException exception) {

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST);
        errorResponse.setMessage("Error in request body" + request.getRequestURI());

        return buildResponseEntity(errorResponse);
    }




}
