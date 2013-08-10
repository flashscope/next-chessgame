package util.exceptions;

public class SameColorPositionException extends RuntimeException {


	private static final long serialVersionUID = 1643549495658353983L;

	/**
     * Constructs a {@code SameColorPositionException} with no detail message.
     */
    public SameColorPositionException() {
        super();
    }

    /**
     * Constructs a {@code SameColorPositionException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public SameColorPositionException(String s) {
        super(s);
    }
    
}
