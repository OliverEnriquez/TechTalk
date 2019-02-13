package com.example.techtalk.Exceptions;


public class PresentationNotFoundException extends RuntimeException{
    PresentationNotFoundException(Long id) {
        super("Could not find presentations " + id);
    }
}
