package cl.gabrielcrsoto.bksclient.exception;

public class BksClientException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BksClientException(){
        super();
    }

    public BksClientException(String message){
        super(message);
    }

    public BksClientException(String message, Throwable cause){
        super(message, cause);
    }
}
