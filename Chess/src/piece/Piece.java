package piece;
/**
 * @author H
 *
 */
public class Piece {
	
	private String symbol;
	private String moveDirection;
	private String moveAmount;
	private String color;
	
	public Piece(String symbol, String color, String moveDirection, String moveAmount) {
		setSymbol(symbol);
		setColor(color);
		setMoveDirection(moveDirection);
		setMoveAmount(moveAmount);
	}

	public Piece(String symbol) {
		setSymbol(symbol);
	}

	/**
	 * @return the moveDirection
	 */
	public String getMoveDirection() {
		return moveDirection;
	}

	/**
	 * @return the moveAmount
	 */
	public String getMoveAmount() {
		return moveAmount;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	private void setMoveAmount(String moveAmount) {
		this.moveAmount = moveAmount;
	}

	private void setMoveDirection(String moveDirection) {
		this.moveDirection = moveDirection;
	}

	private void setColor(String color) {
		this.color = color;
		
	}

	private void setSymbol(String symbol) {
		this.symbol = symbol;
		
	}

	public String getSymbol() {
		return symbol;
	}
}
