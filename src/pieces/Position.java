package pieces;

import java.util.ArrayList;
import java.util.List;

import util.exceptions.IllegalPositionException;
import util.exceptions.NullPositionException;
import chess.Board;

public class Position {
	private static final char COLUMN_START_CHAR = 'a';

	private int x;
	private int y;

	public Position(String position){
		if (position == null) {
			throw new NullPositionException("NULL값이 들어왔습니다.");
		}
		
		if (position.length() != 2) {
			throw new IllegalPositionException("위치 값은 2자리로 입력해야 합니다.(예:b6)");
		}
		
		this.x = generateColumnIndex(position.charAt(0));
		this.y = Integer.parseInt(position.substring(1)) - 1;
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int generateColumnIndex(char columnIndex) {
		int target = Character.getNumericValue(columnIndex);
		int source = Character.getNumericValue(COLUMN_START_CHAR);
		return target - source;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	Position move(Direction direction) {
		return new Position(this.x + direction.getXDegree(), this.y + direction.getYDegree());
	}

	List<Position> findsPosition(Direction direction) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		while(currentPosition.isValid()) {
			positions.add(currentPosition);
			currentPosition = currentPosition.move(direction);
		}
		return positions;
	}

	List<Position> findsPositionOneMove(Direction direction) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Position currentPosition = move(direction);
		
		if(currentPosition.isValid()) {
			positions.add(currentPosition);
		}
		return positions;
	}
	
	List<Position> findsPosition4Linear() {
		ArrayList<Position> positions = new ArrayList<Position>();
		positions.addAll(findsPosition(Direction.NORTH));
		positions.addAll(findsPosition(Direction.SOUTH));
		positions.addAll(findsPosition(Direction.WEST));
		positions.addAll(findsPosition(Direction.EAST));
		return positions;
	}
	
	List<Position> findsPosition4Diagonal() {
		ArrayList<Position> positions = new ArrayList<Position>();
		positions.addAll(findsPosition(Direction.NORTHEAST));
		positions.addAll(findsPosition(Direction.NORTHWEST));
		positions.addAll(findsPosition(Direction.SOUTHEAST));
		positions.addAll(findsPosition(Direction.SOUTHWEST));
		return positions;
	}
	
	List<Position> findsPositionKnight() {
		ArrayList<Position> positions = new ArrayList<Position>();
		
		positions.addAll(findsPositionOneMove(Direction.NORTH).get(0).findsPositionOneMove(Direction.NORTHEAST));
		positions.addAll(findsPositionOneMove(Direction.NORTH).get(0).findsPositionOneMove(Direction.NORTHWEST));
		positions.addAll(findsPositionOneMove(Direction.SOUTH).get(0).findsPositionOneMove(Direction.SOUTHEAST));
		positions.addAll(findsPositionOneMove(Direction.SOUTH).get(0).findsPositionOneMove(Direction.SOUTHWEST));
		positions.addAll(findsPositionOneMove(Direction.WEST).get(0).findsPositionOneMove(Direction.NORTHWEST));
		positions.addAll(findsPositionOneMove(Direction.WEST).get(0).findsPositionOneMove(Direction.SOUTHWEST));
		positions.addAll(findsPositionOneMove(Direction.EAST).get(0).findsPositionOneMove(Direction.NORTHEAST));
		positions.addAll(findsPositionOneMove(Direction.EAST).get(0).findsPositionOneMove(Direction.SOUTHEAST));
		
		return positions;
	}
	
	public boolean isValidPosition() {
		if(this.isValid()){
			return true;
		}
		return false;
	}
	
	boolean isValid() {
		if ( y < 0 || y >= Board.ROW_SIZE) {
			return false;
		}

		if ( x < 0 || x >= Board.COLUMN_SIZE) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Position other = (Position) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}



}
