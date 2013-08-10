package pieces;

import java.util.ArrayList;
import java.util.List;


public class Bishop extends Piece {
	public Bishop(PieceColor color, Position position) {
		super(color, PieceType.BISHOP, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> list = new ArrayList<Position>();
		Position position = super.getSuperPiecePosition();
		list.addAll(position.findsPosition4Diagonal());
		return list;
	}
}