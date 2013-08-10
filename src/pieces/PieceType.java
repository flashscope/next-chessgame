package pieces;

public enum PieceType {
	PAWN('p'),
	ROOK('r'),
	KNIGHT('n'),
	BISHOP('b'),
	QUEEN('q'),
	KING('k'),
	EMPTY('.');
	
	private char symbol;
	
	private PieceType(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
