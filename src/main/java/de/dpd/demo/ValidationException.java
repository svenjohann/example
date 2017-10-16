package de.dpd.demo;

import org.springframework.validation.BindingResult;

/**
 * Created by sven on 16.10.17.
 */
public class ValidationException extends RuntimeException {

    private String errorMessage;

    public ValidationException(BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        bindingResult.getAllErrors().forEach(
                objectError ->  sb.append(objectError.getDefaultMessage()));
        errorMessage = sb.toString();
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
