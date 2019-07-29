package org.demo.controllers;

import org.demo.response.BaseResponse;
import org.demo.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHanlder {

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleIOException(IOException ioe) {
        //!!!!!!!LOG
        return "IOException";
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResponse<String> handleRuntimeException(RuntimeException ioe) {
        //!!!!!!!LOG
        ErrorResponse response = new ErrorResponse();
        response.setErrorMessage(ioe.getMessage());
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception ioe) {
        //!!!!!!!LOG
        return "Exception";
    }
}
