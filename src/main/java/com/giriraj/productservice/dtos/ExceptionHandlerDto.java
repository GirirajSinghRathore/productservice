package com.giriraj.productservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
public class ExceptionHandlerDto {
    private String message;
    private HttpStatus httpStatus;

}
