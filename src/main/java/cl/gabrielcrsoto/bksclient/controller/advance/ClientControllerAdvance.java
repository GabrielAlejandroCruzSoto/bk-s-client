package cl.gabrielcrsoto.bksclient.controller.advance;

import cl.gabrielcrsoto.bksclient.exception.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientControllerAdvance {
    @ExceptionHandler(value = ClientNotFoundException.class)
    public ResponseEntity<Object> exception(ClientNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
