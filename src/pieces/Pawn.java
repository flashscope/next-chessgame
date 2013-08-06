package pieces;

import java.util.ArrayList;
import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> list = new ArrayList<Position>();
		Position position = super.getSuperPiecePosition();
		
		if (super.getSuperPieceColor() == Color.BLACK) {
			list.addAll(position.findsPositionOneMove(Direction.SOUTH));
			if (position.getY() == 6) {
				list.addAll(list.get(0).findsPositionOneMove(Direction.SOUTH));
			}
		} else {
			list.addAll(position.findsPositionOneMove(Direction.NORTH));
			if (position.getY() == 1) {
				list.addAll(list.get(0).findsPositionOneMove(Direction.NORTH));
			}
		}
		
		return list;
	}
}
