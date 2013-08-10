package util.exceptions;

public class CanNotMovePositionException extends RuntimeException {


	private static final long serialVersionUID = -2049507373924865247L;

	/**
     * Constructs a {@code CanNotGoPositionException} with no detail message.
     */
    public CanNotMovePositionException() {
        super();
    }

    /**
     * Constructs a {@code CanNotGoPositionException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public CanNotMovePositionException(String s) {
        super(s);
    }
    
}
