package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testIsWhite() throws Exception {
		Piece whitePawn = new Pawn(Color.WHITE, null);
		assertTrue(whitePawn.isWhite());
	}

	public void testIsBlack() throws Exception {
		Piece blackPawn = new Pawn(Color.BLACK, null);
		assertTrue(blackPawn.isBlack());
	}
	
	public void testMove() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		Piece whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Pawn(Color.WHITE, target), whitePawn.move(target));
	}
	
	public void testLeave() throws Exception {
		Position source = new Position("a1");
		Piece whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Empty(Color.NOCOLOR, source), whitePawn.leave());
	}
	
	public void testEmptyGetPossibleMoves() throws Exception {
		Position source = new Position("a1");
		Empty empty1 = new Empty(Color.WHITE, source);
		assertEquals(0, empty1.getPossibleMoves().size());
	}
	
	public void testRookGetPossibleMoves() throws Exception {
		Position source = new Position("b3");
		Rook rook1 = new Rook(Color.WHITE, source);
		assertEquals(14, rook1.getPossibleMoves().size());
		System.out.println("Rook Possible moves Test : " + rook1.getPossibleMoves().toString());
	}
	
	public void testBishopGetPossibleMoves() throws Exception {
		Position source = new Position("b3");
		Bishop bishop1 = new Bishop(Color.WHITE, source);
		assertEquals(9, bishop1.getPossibleMoves().size());
		System.out.println("Bishop Possible moves Test : " + bishop1.getPossibleMoves().toString());
	}
	
	public void testQueenGetPossibleMoves() throws Exception {
		Position source = new Position("b3");
		Queen queen1 = new Queen(Color.WHITE, source);
		assertEquals(23, queen1.getPossibleMoves().size());
		System.out.println("Queen Possible moves Test : " + queen1.getPossibleMoves().toString());
	}
	
	public void testKingGetPossibleMoves() throws Exception {
		Position source = new Position("b3");
		King king1 = new King(Color.WHITE, source);
		assertEquals(8, king1.getPossibleMoves().size());
		System.out.println("King Possible moves Test : " + king1.getPossibleMoves().toString());
	}
	
	public void testPawnGetPossibleMoves() throws Exception {
		Position source = new Position("b3");
		Pawn pawn1 = new Pawn(Color.WHITE, source);
		assertEquals(1, pawn1.getPossibleMoves().size());
		System.out.println("White Pawn Possible moves Test : " + pawn1.getPossibleMoves().toString());
		
		Position source2 = new Position("c5");
		Pawn pawn2 = new Pawn(Color.BLACK, source2);
		assertEquals(1, pawn2.getPossibleMoves().size());
		System.out.println("Black Pawn Possible moves Test : " + pawn2.getPossibleMoves().toString());
	}
	
	public void testPawnGetPossible2Moves() throws Exception {
		Position source = new Position("b2");
		Pawn pawn1 = new Pawn(Color.WHITE, source);
		assertEquals(2, pawn1.getPossibleMoves().size());
		System.out.println("White Pawn Possible 2moves Test : " + pawn1.getPossibleMoves().toString());
		
		Position source2 = new Position("c7");
		Pawn pawn2 = new Pawn(Color.BLACK, source2);
		assertEquals(2, pawn2.getPossibleMoves().size());
		System.out.println("Black Pawn Possible 2moves Test : " + pawn2.getPossibleMoves().toString());
	}
	
}
