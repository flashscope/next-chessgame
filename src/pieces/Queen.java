package pieces;

import java.util.ArrayList;
import java.util.List;


public class Queen extends Piece {
	public Queen(PieceColor color, Position position) {
		super(color, PieceType.QUEEN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> list = new ArrayList<Position>();
		Position position = super.getSuperPiecePosition();
		
		list.addAll(position.findsPosition4Linear());
		list.addAll(position.findsPosition4Diagonal());
		
		return list;
	}
}
