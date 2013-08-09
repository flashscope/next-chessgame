package util.exceptions;

public class UnValidPositionException extends RuntimeException {

	private static final long serialVersionUID = -2625543663606524168L;

	/**
     * Constructs a {@code UnValidPositionException} with no detail message.
     */
    public UnValidPositionException() {
        super();
    }

    /**
     * Constructs a {@code UnValidPositionException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public UnValidPositionException(String s) {
        super(s);
    }
    
}
