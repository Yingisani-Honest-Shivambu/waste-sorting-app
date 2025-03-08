package com.enviro.assessment.grad001.YingisaniHonestShivambu.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException e){
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error",e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> HandleGeneralException(Exception e){
        Map<String, String> erroorResponse = new HashMap<>();
        erroorResponse.put("error","An unexpected error occured!");
        return new ResponseEntity<>(erroorResponse ,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
