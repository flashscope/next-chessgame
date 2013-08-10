package chess;

public class BoardGenerateHtml implements BoardGenerator{

	@Override
	public String generateBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = Board.ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(i-1) + Board.NEW_LINE);
		}
		return sb.toString();
	}
	
	@Override
	public String generateRank(int rankIndex) {
		Rank rank = Board.getRanks().get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}
	
	@Override
	public void printMessage(String message) {
		System.out.println("<html>" + message + "</html>?");
	}




}
