package com.myapp.sds.exception;

import com.myapp.sds.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentServiceExceptionAdvice {

    @ExceptionHandler(StudentServiceException.class)
    public ResponseEntity<ExceptionDTO> exception(StudentServiceException studentServiceException){
        studentServiceException.printStackTrace();
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(studentServiceException.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.valueOf(500));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> exception(Exception exception){
        exception.printStackTrace();
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.valueOf(500));
    }
}
