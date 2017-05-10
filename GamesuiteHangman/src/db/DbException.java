package db;

/**
 * Created by Henok on 11/05/2017.
 */
public class DbException extends RuntimeException {

    private static final long serialVersionUID = 5L;

    public DbException(String message) {
        super(message);
    }

}
