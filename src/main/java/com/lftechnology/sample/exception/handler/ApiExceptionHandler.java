package com.lftechnology.sample.exception.handler;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lftechnology.sample.exception.ApiException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ResponseEntity exceptionHandler(ApiException ex) {
        HashMap<String, Object> exception = new HashMap<>();
        exception.put("errorCode", ex.getHttpStatus().value());
        exception.put("message", ex.getErrMsg());
        return new ResponseEntity<>(exception, ex.getHttpStatus());
    }
}
