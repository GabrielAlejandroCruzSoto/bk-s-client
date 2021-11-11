package cl.gabrielcrsoto.bksclient.controller.advance;

import cl.gabrielcrsoto.bksclient.exception.BksClientException;
import cl.gabrielcrsoto.bksclient.exception.ClientNotFoundException;
import cl.gabrielcrsoto.bksclient.exception.ClientFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ClientControllerAdvance {
    @ExceptionHandler(value = ClientNotFoundException.class)
    public ResponseEntity<Object> exceptionNotFound(ClientNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BksClientException.class)
    public ResponseEntity<Object> exceptionServerInternalError(BksClientException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = ClientFoundException.class)
    public ResponseEntity<Object> exceptionFound(ClientFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FOUND);
    }
}
