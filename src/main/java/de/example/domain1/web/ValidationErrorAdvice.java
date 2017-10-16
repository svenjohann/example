package de.example.domain1.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sven on 16.10.17.
 */
@ControllerAdvice
public class ValidationErrorAdvice {

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    ResponseEntity<String> handleValidationError(ValidationException ex) {
        return new ResponseEntity<>(ex.getErrorMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
