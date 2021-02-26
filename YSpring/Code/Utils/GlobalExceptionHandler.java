package com.module.admin_module.Utils;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    
    @ExceptionHandler
    public ResponseEntity<Object> handleException(Exception e) {
        APIResponse api=new APIResponse();
        api.setErrorMessage("Oops..Something went wrong...");
        api.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.unprocessableEntity().body(api);
    }

    @ExceptionHandler
    public ResponseEntity<Object> badRequestException(BadRequestException e){
        APIResponse api=new APIResponse();
        api.setErrorMessage(e.getError());
        api.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.unprocessableEntity().body(api);
    }


}
