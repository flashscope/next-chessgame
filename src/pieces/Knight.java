package pieces;

import java.util.List;

public class Knight extends Piece {
	public Knight(PieceColor color, Position position) {
		super(color, PieceType.KNIGHT, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		Position position = super.getSuperPiecePosition();
		return position.findsPositionKnight();
	}
}
