package com.parwaz.training.exception_handling;

import com.parwaz.training.response.GenericResponse;
import com.parwaz.training.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler implements Constants {

    Logger logger = LoggerFactory.getLogger(ExceptionHandlerClass.class);

    @ExceptionHandler(value = NoSuchElementException.class )
    protected ResponseEntity<Object> handleNoSuchElementException(RuntimeException ex, WebRequest request) {
        String msg = "No Student Found With GIVEN ID";
        logger.warn(msg+" :: "+ex.getMessage());
        return handleExceptionInternal(ex, new GenericResponse(ERROR_MESSAGE,ERROR_CODE,msg),
                new HttpHeaders(), HttpStatus.PRECONDITION_FAILED,request);
    }

    @ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> handleAllRuntimeExceptions(RuntimeException ex, WebRequest request) {
        logger.warn("Something went wrong :: "+ex.getMessage());
        return handleExceptionInternal(ex, new GenericResponse(ERROR_MESSAGE,ERROR_CODE,RUNTIME_EXCEPTION),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,request);
    }
}
