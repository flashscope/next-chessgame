package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	public King(PieceColor color, Position position) {
		super(color, PieceType.KING, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> list = new ArrayList<Position>();
		Position position = super.getSuperPiecePosition();
		
		list.addAll(position.findsPositionOneMove(Direction.NORTHWEST));
		list.addAll(position.findsPositionOneMove(Direction.NORTH));
		list.addAll(position.findsPositionOneMove(Direction.NORTHEAST));
		list.addAll(position.findsPositionOneMove(Direction.WEST));
		list.addAll(position.findsPositionOneMove(Direction.EAST));
		list.addAll(position.findsPositionOneMove(Direction.SOUTHWEST));
		list.addAll(position.findsPositionOneMove(Direction.SOUTH));
		list.addAll(position.findsPositionOneMove(Direction.SOUTHEAST));
		
		return list;
	}
}

