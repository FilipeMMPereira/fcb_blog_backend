package com.fcb_blog_backend.fcb_blog_backend.spring.config.errors;

//import com.fcb_blog_backend.fcb_blog_backend.dtos.global.MessageDTO;
import com.fcb_blog_backend.fcb_blog_backend.dtos.global.ErrorDTO;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorExceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND.toString()));
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ErrorDTO> handleEntityExistsException(EntityExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDTO(e.getMessage(), HttpStatus.CONFLICT.toString()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> validationExceptionHandler(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorDTO errorDTO = new ErrorDTO(errors.toString().replace("{","").replace("}","").replace("="," "), HttpStatus.BAD_REQUEST.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST.toString()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGeneralException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString()));
    }
}
