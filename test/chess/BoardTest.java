package chess;

import junit.framework.TestCase;
import pieces.Empty;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Position;
import util.exceptions.EmptyPositionException;

public class BoardTest extends TestCase {
	private Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
	}
	
	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}
	
	public void testPrint() throws Exception {
		board.initialize();
		String expected = 
			RankTest.BLACK_EXCEPT_PAWN_RANK + Board.NEW_LINE +
			RankTest.BLACK_PAWN_RANK + Board.NEW_LINE +
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() + 
			createEmptyRank() +
			RankTest.WHITE_PAWN_RANK + Board.NEW_LINE +
			RankTest.WHITE_EXCEPT_PAWN_RANK + Board.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}
	
	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + Board.NEW_LINE;
	}
	
	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}
	
	public void testInitializeEmpty() throws Exception {
		board.initializeEmpty();
		System.out.println(board.generateBoard());
	}
	
	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Piece sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);
		
		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		System.out.println(board.generateBoard());
	}
	
	public void testSelectEmptyPlaceToMove() throws Exception {
		board.initialize();
		Position source = new Position("d5");
		Position target = new Position("a2");
		
		try{
			board.movePiece(source, target);
			fail("만약 빈칸을 건드리지 '않으면' 이게 실행되겠지...");
		}catch(EmptyPositionException e){
			System.out.println("ERROR:"+e);
		}
	}
	
	public void testMoveTargetValid() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("a9");
		
		try{
			board.movePiece(source, target);
			fail("만약 타겟이 잘못된 곳으로 이끌지 '않으면' 이게 실행되겠지...");
		}catch(Exception e){
			System.out.println("ERROR:"+e);
		}
		
		System.out.println(board.generateBoard());
	}
	
	
	public void testMoveOurSide() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("b2");
		
		try{
			board.movePiece(source, target);
			fail("만약 타겟에 같은 팀이 있지 '않으면' 이게 실행되겠지...");
		}catch(Exception e){
			System.out.println("ERROR:"+e);
		}
		
		System.out.println(board.generateBoard());
	}
	
	
	public void testCanNotMovePosition() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		Position target = new Position("b5");
		
		try{
			board.movePiece(source, target);
			fail("그 말이 갈 수 있는 곳이지 '않으면' 이게 실행되겠지...");
		}catch(Exception e){
			System.out.println("ERROR:"+e);
		}
		
		System.out.println(board.generateBoard());
	}
}
