package board;

import piece.Piece;
/**
 * Creates the game board.
 * @author H
 */
public class Board {
	
	/** Number of rows */
	private static final int ROWS = 8;
	/** Number of columns */
	private static final int COLS = 8;
	/** 2D array representing the board */
	private static Piece[][] board;
	
	/**
	 * Constructs the board
	 */
	public Board() {
		board = new Piece[ROWS][COLS];
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; i++) {
				board[i][j] = new Piece("X");
			}
		}
		
		board[0][0] = new Piece("R", "b", "VH", "99,99");
		board[0][1] = new Piece("Kn", "b", "VH", "3,1");
		board[0][2] = new Piece("B", "b", "D", "99");
		board[0][3] = new Piece("Q", "b", "VHD", "99,99,99");
		board[0][4] = new Piece("K", "b", "VHD", "1,1,1");
		board[0][5] = new Piece("B", "b", "D", "99");
		board[0][6] = new Piece("Kn", "b", "VH", "3,1");
		board[0][7] = new Piece("R", "b", "VH", "99,99");
		for (int i = 0; i < COLS; i++) {
			board[1][i] = new Piece("P", "b", "V", "1");
		}
		
		board[7][0] = new Piece("R", "w", "VH", "99,99");
		board[7][1] = new Piece("Kn", "w", "VH", "3,1");
		board[7][2] = new Piece("B", "w", "D", "99");
		board[7][3] = new Piece("Q", "w", "VHD", "99,99,99");
		board[7][4] = new Piece("K", "w", "VHD", "1,1,1");
		board[7][5] = new Piece("B", "w", "D", "99");
		board[7][6] = new Piece("Kn", "w", "VH", "3,1");
		board[7][7] = new Piece("R", "w", "VH", "99,99");
		for (int i = 0; i < COLS; i++) {
			board[6][i] = new Piece("P", "w", "V", "1");
		}
	}
	
	/**
	 * Resets the board
	 */
	public static void resetBoard() {
		Piece[][] newBoard = new Piece[ROWS][COLS];
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				newBoard[i][j] = new Piece("X");
			}
		}
		
		newBoard[0][0] = new Piece("R", "b", "VH", "99,99");
		newBoard[0][1] = new Piece("Kn", "b", "VH", "3,1");
		newBoard[0][2] = new Piece("B", "b", "D", "99");
		newBoard[0][3] = new Piece("Q", "b", "VHD", "99,99,99");
		newBoard[0][4] = new Piece("K", "b", "VHD", "1,1,1");
		newBoard[0][5] = new Piece("B", "b", "D", "99");
		newBoard[0][6] = new Piece("Kn", "b", "VH", "3,1");
		newBoard[0][7] = new Piece("R", "b", "VH", "99,99");
		for (int i = 0; i < COLS; i++) {
			newBoard[1][i] = new Piece("P", "b", "V", "1");
		}
		
		newBoard[7][0] = new Piece("R", "w", "VH", "99,99");
		newBoard[7][1] = new Piece("Kn", "w", "VH", "3,1");
		newBoard[7][2] = new Piece("B", "w", "D", "99");
		newBoard[7][3] = new Piece("Q", "w", "VHD", "99,99,99");
		newBoard[7][4] = new Piece("K", "w", "VHD", "1,1,1");
		newBoard[7][5] = new Piece("B", "w", "D", "99");
		newBoard[7][6] = new Piece("Kn", "w", "VH", "3,1");
		newBoard[7][7] = new Piece("R", "w", "VH", "99,99");
		for (int i = 0; i < COLS; i++) {
			newBoard[6][i] = new Piece("P", "w", "V", "1");
		}
		
		board = newBoard;
	}
	
	/**
	 * Prints the board with the position of the pieces.
	 * If there is a empty square, it is replaced with an 'X'.
	 */
	public static void printBoard() {
		String[][] printBoard = new String[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (board[i][j].getSymbol().equals("X")) {
					printBoard[i][j] = "Xx";
				} else {
					printBoard[i][j] = board[i][j].getSymbol() + board[i][j].getColor();
				}
			}
		}
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (printBoard[i][j].length() == 3) {
					System.out.print(printBoard[i][j] + " ");
				} else {
					System.out.print(printBoard[i][j] + "  ");
				}
			}
			System.out.println();
		}
	}
}
