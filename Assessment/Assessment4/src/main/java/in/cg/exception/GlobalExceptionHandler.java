package in.cg.exception;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

 @ExceptionHandler(ResourceNotFoundException.class)

 public ResponseEntity<String> handle(ResourceNotFoundException ex){

  return ResponseEntity.status(HttpStatus.NOT_FOUND)
  .body(ex.getMessage());

 }

}