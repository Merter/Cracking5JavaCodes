
// CtCI5 17.2
public class TicTacToe {
	private static final int BOARD_SIZE = 3;
	private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
	private static final char PLAYER1 = 'X';
	private static final char PLAYER2 = 'O';
	
	public int playerWon() {
		for (int i=0; i<BOARD_SIZE; i++) {
			boolean fullRow = true;
			for (int j=0; j<BOARD_SIZE-1; j++) {
				if (board[i][j] != board[i][j+1]) {
					fullRow = false;
					break;
				}
			}
			if (fullRow)
				return whichPlayer(i, 0);
		}
		
		for (int i=0; i<BOARD_SIZE-1; i++) {
			boolean fullColumn = true;
			for (int j=0; j<BOARD_SIZE; j++) {
				if (board[j][i] != board[j][i+1]) {
					fullColumn = false;
					break;
				}
			}
			if (fullColumn)
				whichPlayer(0, i);
		}
		
		boolean fullDiag = true;
		for (int i=0; i<BOARD_SIZE-1; i++) {
			if (board[i][i] != board[i+1][i+1]) {
				fullDiag = false;
				break;
			}
		}
		if (fullDiag)
			return whichPlayer(0, 0);
		
		fullDiag = true;
		for (int i=0; i<BOARD_SIZE-1; i++) {
			if (board[i][BOARD_SIZE-1-i] != board[i+1][BOARD_SIZE-2-i]) {
				fullDiag = false;
				break;
			}
		}
		if (fullDiag)
			return whichPlayer(0, BOARD_SIZE-1);
		
		return 0;
	}

	private int whichPlayer(int posX, int posY) {
		if (board[posX][posY] == PLAYER1)
			return 1;
		if (board[posX][posY] == PLAYER2)
			return 2;
		return 0;
	}

}
