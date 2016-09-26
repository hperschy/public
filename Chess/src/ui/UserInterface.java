/**
 * 
 */
package ui;

import java.util.Scanner;

import board.Board;
import player.Player;

/**
 * @author H
 *
 */
public class UserInterface {

	/**
	 * 
	 */
	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		Board.resetBoard();
		System.out.println("Would you like to be white or black?");
		String playerColor = scan.nextLine();
		Player.setPlayerColor(playerColor);
		Board.printBoard();
	}
}
