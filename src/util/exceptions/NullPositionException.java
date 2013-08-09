package util.exceptions;

public class NullPositionException extends RuntimeException {

	private static final long serialVersionUID = -7840341512658060793L;

	/**
     * Constructs a {@code NullPositionException} with no detail message.
     */
    public NullPositionException() {
        super();
    }

    /**
     * Constructs a {@code NullPositionException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public NullPositionException(String s) {
        super(s);
    }
    
}
