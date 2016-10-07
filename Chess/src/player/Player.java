/**
 * 
 */
package player;

import java.util.ArrayList;

import piece.Piece;

/**
 * @author H
 *
 */
public class Player {
	
	/** Represents no limit in movement */
	private final String MAX_MOVE_AMOUNT = "99";

	/** The player's chosen color */
	private String playerColor;
	
	/** An array containing the player's pieces*/
	private ArrayList<Piece> pieces;
	
	/** Sets the player's color */
	public void setPlayerColor(String playerColor) {
		this.playerColor = playerColor;
	}
	
	/** Returns the player's color */
	public String getPlayerColor() {
		return playerColor;
	}

	/** Sets the player's array of pieces */
	public void setPieces(String playerColor) {
		for (int i = 0; i < 8; i++) {
			pieces.add(new Piece("P", playerColor, "D", 1, 0));
		}
		
	}
	
	/** Returns the array of pieces */
	public ArrayList<Piece> getPieces() {
		return pieces;
	}
}
