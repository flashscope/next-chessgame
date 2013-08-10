package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.PieceOperations;
import pieces.Position;
import util.exceptions.CanNotMovePositionException;
import util.exceptions.EmptyPositionException;
import util.exceptions.IllegalPositionException;
import util.exceptions.KillKingException;
import util.exceptions.SameColorPositionException;

public class Board {
	
	private static final boolean SYSOUT_ON = true;
	private static final boolean BOARD_EMPTY_MODE_ON = false;
	
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;
	
	private static List<Rank> ranks = new ArrayList<Rank>();
	
	
	Board() {
	}

	void initialize() {
		if(BOARD_EMPTY_MODE_ON) {
			for (int i = 0; i < ROW_SIZE; i++) {
				Rank rank = new Rank(i);
				if (i==0) {
					rank.initializeWhiteExceptPawn();
				} else if (i==1) {
					rank.initializeWhitePawn();
				} else if (i==6) {	
					rank.initializeBlackPawn();
				} else if (i==7) {
					rank.initializeBlackExceptPawn();
				} else {
					rank.initializeEmpty();
				}
				ranks.add(rank);
			}
		}else{
			initializeEmpty();
		}
	}
	
	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	PieceOperations findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	PieceOperations findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) {
		PieceOperations targetPiece = findPiece(source);
		
		if (targetPiece.getSymbol()=='.'){
			throw new EmptyPositionException("빈칸을 선택하였습니다.");
		}
		if (!target.isValidPosition()){
			throw new IllegalPositionException("이동 불가능한 칸 입니다.");
		}
		if (targetPiece.getColor() == findPiece(target).getColor()){
			throw new SameColorPositionException("같은 편이 위치한 자리입니다.");
		}
		if (!targetPiece.isCanMove(target)){
			throw new CanNotMovePositionException("그 말이 이동 할 수 없는 곳입니다.");
		}
		if (targetPiece.getSymbol()=='k' || targetPiece.getSymbol()=='K'){
			throw new KillKingException("킹은 잡을 수 없습니다.");
		}
		
		PieceOperations sourcePiece = targetPiece.leave();
		
		Rank sourceRank = ranks.get(source.getY());
		sourceRank.move(sourcePiece, source);
		
		Rank targetRank = ranks.get(target.getY());
		targetRank.move(targetPiece, target);
	}
	
	public static List<Rank> getRanks(){
		return ranks;
	}
	
	public BoardGenerator switchGenerator(){
		if(SYSOUT_ON){
			return new BoardGenerateSysOut();
		}
		return new BoardGenerateHtml();
	}
}
