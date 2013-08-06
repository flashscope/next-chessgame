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
	
}
