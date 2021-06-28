package com.cts.sparemanagement_order.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Slf4j
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       log.error("Exception handleMethodArgumentNotValid");
                return new ResponseEntity<>( new CustomErrorDetails(new Date(), "All Fields are Requred" , ex.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<Object>  handleProductNotFoundException(ProductNotFoundException ex, WebRequest webRequest ){
        log.error("Exception ProductNotFoundException");
        return new ResponseEntity<>(new CustomErrorDetails(new Date() , ex.getMessage() , webRequest.getDescription(false)) , HttpStatus.NOT_FOUND);
    }

}
