package pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
	public Rook(Color color, Position position) {
		super(color, Type.ROOK, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> list = new ArrayList<Position>();
		Position position = super.getSuperPiecePosition();
		list.addAll(position.findsPosition4Linear());
		return list;
	}
}
