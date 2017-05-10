package domain.exceptions;

/**
 * Created by Henok on 10/05/2017.
 */
public class UIException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UIException(String message) {
        super(message);
    }
}
