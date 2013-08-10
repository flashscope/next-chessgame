package pieces;


public interface PieceOperations {

	public char getSymbol();
	public PieceColor getColor();
	
    boolean isWhite();
    boolean isBlack();

	public Piece leave();
	public Piece move(Position target);
	
	public boolean isCanMove (Position pos);
}
