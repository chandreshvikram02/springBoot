package com.practice.springboot.exception;

import com.practice.springboot.entity.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

// instead of get load puts
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("request method not supported");
        ApiErrors errors = new ApiErrors(message, details, (HttpStatus) status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }
// instead of json sending text
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers, HttpStatusCode status,
                                                                     WebRequest request) {

        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Media type not supported");
        ApiErrors errors = new ApiErrors(message, details, (HttpStatus) status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    //
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Media type not Acceptable");
        ApiErrors errors = new ApiErrors(message, details, (HttpStatus) status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("path variable is missing");
        ApiErrors errors = new ApiErrors(message, details, (HttpStatus) status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }
    // in case of getbookbycategory reqestparam value os category if instead of category we will give like cat
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Missing servlet request");
        ApiErrors errors = new ApiErrors(message, details, (HttpStatus) status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }
     //  pathvariable need to send 1 but sending one
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Type mismatch exception");
        ApiErrors errors = new ApiErrors(message, details, (HttpStatus) status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    // in case of post mapping .need to send body also but no content in the body
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Message not readable");
        ApiErrors errors = new ApiErrors(message, details, (HttpStatus) status, LocalDateTime.now());
        return ResponseEntity.status(status).body(errors);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> bookNotFoundException(BookNotFoundException ex) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("book not found");
        ApiErrors errors = new ApiErrors(message, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> handleBIdNotFoundException(IdNotFoundException ex) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("Id Not Available");
        ApiErrors error = new ApiErrors(message, details, HttpStatus.NOT_FOUND, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherException(Exception ex) {
        String message = ex.getMessage();
        List<String> details = new ArrayList<>();
        details.add("other exception");
        details.add(ex.getMessage());
        ApiErrors error = new ApiErrors(message, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
