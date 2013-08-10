package util.exceptions;

public class EmptyPositionException extends RuntimeException {

	private static final long serialVersionUID = -3536523914470825348L;

	/**
     * Constructs a {@code EmptyPositionException} with no detail message.
     */
    public EmptyPositionException() {
        super();
    }

    /**
     * Constructs a {@code EmptyPositionException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public EmptyPositionException(String s) {
    	super(s);
    }
    
    
}
