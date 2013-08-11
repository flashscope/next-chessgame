package pieces;


public interface PieceOperations {

	char getSymbol();
	PieceColor getColor();
	
    boolean isWhite();
    boolean isBlack();

	Piece leave();
	Piece move(Position target);
	
	boolean isCanMove (Position pos);
}
