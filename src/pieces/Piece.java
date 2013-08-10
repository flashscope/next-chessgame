package pieces;

import java.util.List;


public class Piece implements PieceOperations{

	private PieceColor color;
	private PieceType type;
	private Position position;
	
	Piece(PieceColor color, PieceType type, Position position) {
		this.color = color;
		this.type = type;
		this.position = position;
	}
	
	boolean matchColor(PieceColor color) {
		return this.color == color ? true : false;
	}

	
	List<Position> getPossibleMoves() {
		return null;
	}
	
	
	protected Position getSuperPiecePosition(){
		return position;
	}
	
	protected PieceColor getSuperPieceColor(){
		return color;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Piece other = (Piece) obj;
		if (color != other.color) {
			return false;
		}
		if (position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!position.equals(other.position)) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Piece [color=" + color + ", type=" + type + ", position="
				+ position + "]";
	}

	@Override
	public char getSymbol() {
		if (isBlack()) {
			return Character.toUpperCase(type.getSymbol());
		}
		return type.getSymbol();
	}

	@Override
	public PieceColor getColor() {
		return color;
	}

	@Override
	public boolean isWhite() {
        if (PieceColor.WHITE == color) {
            return true;
        }
        
        return false;
	}

	@Override
	public boolean isBlack() {
        if (PieceColor.BLACK == color) {
            return true;
        }
        
        return false;
	}

	@Override
	public Piece leave() {
		return new Empty(PieceColor.NOCOLOR, this.position);
	}

	@Override
	public Piece move(Position target) {
		this.position = target;
		return this;
	}

	@Override
	public boolean isCanMove(Position pos) {
		if(getPossibleMoves().contains(pos)) {
			return true;
		}
		return false;
	}
	
}
