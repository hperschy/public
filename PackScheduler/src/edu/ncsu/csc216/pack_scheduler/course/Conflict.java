/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course;

/**
 * Interface for checkConflict
 * @author Hunter Perschy
 */
public interface Conflict {
	/**
	 * Checks if there is a conflict between two Activities
	 * @param possibleConflictingActivity the Activity to check
	 * @throws ConflictException when there is a conflict between two activities
	 */
	void checkConflict(Activity possibleConflictingActivity) throws ConflictException;
}
