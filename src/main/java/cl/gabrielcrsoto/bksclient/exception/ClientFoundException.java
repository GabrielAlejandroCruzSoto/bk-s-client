package cl.gabrielcrsoto.bksclient.exception;

public class ClientFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ClientFoundException(){
        super();
    }

    public ClientFoundException(String message){
        super(message);
    }

    public ClientFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
