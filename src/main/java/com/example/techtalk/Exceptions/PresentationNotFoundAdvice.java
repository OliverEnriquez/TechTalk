package com.example.techtalk.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PresentationNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PresentationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String presentationNotFoundHandler(PresentationNotFoundException ex) {
        return ex.getMessage();
    }

}
