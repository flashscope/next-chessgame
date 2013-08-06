package pieces;

import java.util.ArrayList;
import java.util.List;


public class Bishop extends Piece {
	public Bishop(Color color, Position position) {
		super(color, Type.BISHOP, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> list = new ArrayList<Position>();
		Position position = super.getSuperPiecePosition();
		list.addAll(position.findsPosition(Direction.NORTHEAST));
		list.addAll(position.findsPosition(Direction.NORTHWEST));
		list.addAll(position.findsPosition(Direction.SOUTHEAST));
		list.addAll(position.findsPosition(Direction.SOUTHWEST));
		return list;
	}
}