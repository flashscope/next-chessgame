package pieces;

import java.util.ArrayList;
import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> list = new ArrayList<Position>();
		Position position = super.getSuperPiecePosition();
		
		list.addAll(position.findsPosition(Direction.NORTH));
		list.addAll(position.findsPosition(Direction.SOUTH));
		list.addAll(position.findsPosition(Direction.WEST));
		list.addAll(position.findsPosition(Direction.EAST));
		list.addAll(position.findsPosition(Direction.NORTHEAST));
		list.addAll(position.findsPosition(Direction.NORTHWEST));
		list.addAll(position.findsPosition(Direction.SOUTHEAST));
		list.addAll(position.findsPosition(Direction.SOUTHWEST));
		
		return list;
	}
}
