package cl.gabrielcrsoto.bksclient.exception;

public class ClientNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    ClientNotFoundException(){
        super();
    }

    public ClientNotFoundException(String message){
        super(message);
    }

    ClientNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

}
