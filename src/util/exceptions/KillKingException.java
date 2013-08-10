package util.exceptions;

public class KillKingException extends RuntimeException {

	private static final long serialVersionUID = -4799851612534690649L;

	/**
     * Constructs a {@code KillKingException} with no detail message.
     */
    public KillKingException() {
        super();
    }

    /**
     * Constructs a {@code KillKingException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public KillKingException(String s) {
        super(s);
    }
    
}
