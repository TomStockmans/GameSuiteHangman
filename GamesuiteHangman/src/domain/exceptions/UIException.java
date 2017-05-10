package domain.exceptions;

/**
 * Created by Henok on 10/05/2017.
 */
public class UiException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UiException(String message) {
        super(message);
    }
}
