package com.nhnacademy.exam.advice;

import com.nhnacademy.exam.dto.ErrorDto;
import com.nhnacademy.exam.exception.DataNotFoundException;
import com.nhnacademy.exam.exception.NotSupportAcceptException;
import com.nhnacademy.exam.exception.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({KeyAlreadyExistsException.class, IllegalArgumentException.class})
    public ResponseEntity<ErrorDto> keyAlreadyExistException(Exception ex) {
        ErrorDto errorDto = new ErrorDto(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorDto> exception(Exception ex) {
        ErrorDto errorDto = new ErrorDto(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorDto> unauthorizedException(Exception ex) {
        ErrorDto errorDto = new ErrorDto(
                "Unauthorized",
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotSupportAcceptException.class)
    public ResponseEntity<ErrorDto> notSupportAcceptException(NotSupportAcceptException ex) {
        ErrorDto errorDto = new ErrorDto(
                "Could not find acceptable representation",
                HttpStatus.NOT_ACCEPTABLE.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_ACCEPTABLE);
    }

}
