package chess;

public interface BoardGenerator {
	String generateBoard();
	String generateRank(int rankIndex);
	void printMessage(String message);
}
