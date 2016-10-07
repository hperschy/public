package piece;
/**
 * @author H
 *
 */
public class Piece {
	
	/** Symbol of the piece */
	private String symbol;
	/** Direction the piece captures */
	private String captureDirection;
	/** Amount the piece can move vertically */
	private int vertMoveAmount;
	/** Amount the piece can move horizontally the piece */
	private int horzMoveAmount;
	/** The color of the piece */
	private String color;
	
	/**
	 * Constructs a piece object with given parameters.
	 * @param symbol Symbol of the piece
	 * @param color Color of the piece
	 * @param captureDirection Direction of capture
	 * @param vertMoveAmount Amount it can move vertically
	 * @param horzMoveAmount Amount it can move horizontally
	 */
	public Piece(String symbol, String color, String captureDirection, int vertMoveAmount, int horzMoveAmount) {
		setSymbol(symbol);
		setColor(color);
		setCaptureDirection(captureDirection);
		setVertMoveAmount(vertMoveAmount);
		setHorzMoveAmount(horzMoveAmount);
	}

	/**
	 * Constructs a piece with only a symbol. A symbol of "X" is 
	 * used to represent an empty square.
	 * @param symbol
	 */
	public Piece(String symbol) {
		setSymbol(symbol);
	}

	/**
	 * Returns the captureDirection.
	 * @return the attack direction
	 */
	public String getCaptureDirection() {
		return captureDirection;
	}

	/**
	 * Returns the vertical movement amount
	 * @return the vertical move amount
	 */
	public int getVertMoveAmount() {
		return vertMoveAmount;
	}
	
	/**
	 * Returns the horizontal movement amount
	 * @return the horizontal move amount
	 */
	public int getHorzMoveAmount() {
		return horzMoveAmount;
	}

	/**
	 * Returns the color
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the vertical move amount. 99 is used to represent no limit.
	 * @param vertMoveAmount
	 */
	private void setVertMoveAmount(int vertMoveAmount) {
		this.vertMoveAmount = vertMoveAmount;
	}
	
	/**
	 * Sets the horizontal move amount. 99 is used to represent no limit.
	 * @param horzMoveAmount
	 */
	private void setHorzMoveAmount(int horzMoveAmount) {
		this.horzMoveAmount = horzMoveAmount;
	}

	/**
	 * Sets the capture direction. "M" is use to set it the same as its movement.
	 * @param attackDirection
	 */
	private void setCaptureDirection(String captureDirection) {
		this.captureDirection = captureDirection;
	}

	/**
	 * Sets the piece's color
	 * @param color
	 */
	private void setColor(String color) {
		this.color = color;
		
	}

	/**
	 * Sets the piece's symobl
	 * @param symbol
	 */
	private void setSymbol(String symbol) {
		this.symbol = symbol;
		
	}
	
	/**
	 * Returns the symbol
	 * @return
	 */
	public String getSymbol() {
		return symbol;
	}
}
