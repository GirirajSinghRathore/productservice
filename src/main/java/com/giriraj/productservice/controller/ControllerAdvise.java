package com.giriraj.productservice.controller;

import com.giriraj.productservice.dtos.ExceptionHandlerDto;
import com.giriraj.productservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionHandlerDto> productNotFoundHandler(ProductNotFoundException productNotFoundException){
        ExceptionHandlerDto exceptionHandlerDto = new ExceptionHandlerDto(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionHandlerDto, HttpStatus.NOT_FOUND);
    }
}
