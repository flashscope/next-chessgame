package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Bishop;
import pieces.Empty;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.PieceColor;
import pieces.PieceOperations;
import pieces.Position;
import pieces.Queen;
import pieces.Rook;

public class Rank {
	private List<PieceOperations> rank = new ArrayList<PieceOperations>();
	
	private int rankPosition;
	
	Rank(int yPosition) {
		this.rankPosition = yPosition;
	}

	void initializeEmpty() {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add( new Empty(PieceColor.NOCOLOR, new Position(i, rankPosition)) );
		}
	}
	
	void initializeWhitePawn() {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add(new Pawn(PieceColor.WHITE, new Position(i, rankPosition)) );
		}
	}
	
	void initializeBlackPawn() {
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			rank.add(new Pawn(PieceColor.BLACK, new Position(i, rankPosition)) );
		}
	}
	
	void initializeWhiteExceptPawn() {
		rank.add(new Rook(PieceColor.WHITE, new Position(0, rankPosition)) );
		rank.add(new Knight(PieceColor.WHITE, new Position(1, rankPosition)) );
		rank.add(new Bishop(PieceColor.WHITE, new Position(2, rankPosition)) );
		rank.add(new Queen(PieceColor.WHITE, new Position(3, rankPosition)) );
		rank.add(new King(PieceColor.WHITE, new Position(4, rankPosition)) );
		rank.add(new Bishop(PieceColor.WHITE, new Position(5, rankPosition)) );
		rank.add(new Knight(PieceColor.WHITE, new Position(6, rankPosition)) );
		rank.add(new Rook(PieceColor.WHITE, new Position(7, rankPosition)) );
	}
	

	void initializeBlackExceptPawn() {
		rank.add(new Rook(PieceColor.BLACK, new Position(0, rankPosition)) );
		rank.add(new Knight(PieceColor.BLACK, new Position(1, rankPosition)) );
		rank.add(new Bishop(PieceColor.BLACK, new Position(2, rankPosition)) );
		rank.add(new Queen(PieceColor.BLACK, new Position(3, rankPosition)) );
		rank.add(new King(PieceColor.BLACK, new Position(4, rankPosition)) );
		rank.add(new Bishop(PieceColor.BLACK, new Position(5, rankPosition)) );
		rank.add(new Knight(PieceColor.BLACK, new Position(6, rankPosition)) );
		rank.add(new Rook(PieceColor.BLACK, new Position(7, rankPosition)) );
	}

	String generate() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Board.COLUMN_SIZE; i++) {
			sb.append(rank.get(i).getSymbol());
		}
		return sb.toString();
	}

	PieceOperations findPiece(Position position) {
		return rank.get(position.getX());
	}

	void changePiece(int xPosition, PieceOperations targetPiece) {
		rank.set(xPosition, targetPiece);
	}

	PieceOperations move(PieceOperations sourcePiece, Position target) {
		sourcePiece.move(target);
		rank.set(target.getX(), sourcePiece);
		return sourcePiece;
	}
}
