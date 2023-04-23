package com.booking.theaterservice.exceptions;

import java.util.AbstractMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handle(Exception exception) {
    LOG.error("Request could not be processed: ", exception);
    AbstractMap.SimpleEntry<String, String> response =
        new AbstractMap.SimpleEntry<>("message", "Request could not be processed");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }

  @ExceptionHandler
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> notFoundException(NotFoundException exception) {
    LOG.error("Request could not be processed: ", exception);
    AbstractMap.SimpleEntry<String, String> response =
        new AbstractMap.SimpleEntry<>("message", exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> invalidDataException(InvalidDataException exception) {
    LOG.error("Request could not be processed: ", exception);
    AbstractMap.SimpleEntry<String, String> response =
        new AbstractMap.SimpleEntry<>("message", exception.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> dataIntegrityViolationException(
      DataIntegrityViolationException exception) {
    LOG.error("Request could not be processed: ", exception);
    AbstractMap.SimpleEntry<String, String> response =
        new AbstractMap.SimpleEntry<>("message", "violates unique constraint");
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
  @ResponseStatus( value = HttpStatus.BAD_REQUEST )
  @ExceptionHandler( value = {MissingServletRequestParameterException.class, HttpMessageNotReadableException.class } )
  public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handleRejectedValuesInRequestParamException(MissingServletRequestParameterException e) {
    LOG.error( "Request could not be processed: ", e.getClass().getName(), e.getMessage() );

    AbstractMap.SimpleEntry<String, String> response =
        new AbstractMap.SimpleEntry<>("message", e.getMessage());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
}
