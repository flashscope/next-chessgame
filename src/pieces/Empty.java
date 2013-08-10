package pieces;

import java.util.ArrayList;
import java.util.List;

public class Empty extends Piece {
	public Empty(PieceColor color, Position position) {
		super(color, PieceType.EMPTY, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		return new ArrayList<Position>();
	}
	
}
