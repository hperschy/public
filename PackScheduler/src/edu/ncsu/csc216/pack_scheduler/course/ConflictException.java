/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course;

/**
 * Constructs exception
 * @author Hunter Perschy
 */
public class ConflictException extends Exception {

	/** Id used for serialization */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs exception with given error message
	 * @param message given error message 
	 */
	public ConflictException(String message) {
		super(message);
	}
	
	/**
	 * Constructs exception with default error message 
	 */
	public ConflictException() {
		super("Schedule conflict.");
	}
}
