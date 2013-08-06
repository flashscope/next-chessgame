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
		list.addAll(position.findsPosition(Direction.NORTH));
		list.addAll(position.findsPosition(Direction.SOUTH));
		list.addAll(position.findsPosition(Direction.WEST));
		list.addAll(position.findsPosition(Direction.EAST));
		return list;
	}
}
