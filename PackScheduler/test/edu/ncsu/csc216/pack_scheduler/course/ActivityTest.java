/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests checkConflict()
 * @author Hunter Perschy
 */
public class ActivityTest {

	/**
	 * Tests checkConflict() 
	 */
	@Test
	public void testCheckConflict() {
		Activity a1 = new Course("CSC216", "Programming Concepts - Java", "001", 4, "sesmith5", "MW", 1330, 1445);
		Activity a2 = new Course("CSC216", "Programming Concepts - Java", "001", 4, "sesmith5", "TH", 1330, 1445);
		assertEquals("Incorrect meeting string for this Activity.", "MW 1:30PM-2:45PM", a1.getMeetingString());
        assertEquals("Incorrect meeting string for possibleConflictingActivity.", "TH 1:30PM-2:45PM", a2.getMeetingString());
		
        //test non-conflict
        try {
			a1.checkConflict(a2);
		} catch (ConflictException e) {
		    fail();
		}
		//test commutative non-conflict 
        try {
			a2.checkConflict(a1);
		} catch (ConflictException e) {
		    fail();
		}
        
		//Test conflict same days and time
		a1.setMeetingDays("TH");
		a1.setActivityTime(1445, 1530);
		try {
		    a1.checkConflict(a2);
		    fail(); //ConflictException should have been thrown, but was not.
		} catch (ConflictException e) {
		    //Check that the internal state didn't change during method call.
		    assertEquals("TH 2:45PM-3:30PM", a1.getMeetingString());
		    assertEquals("TH 1:30PM-2:45PM", a2.getMeetingString());
		}
		
		//test conflict on single day
		a1.setMeetingDays("MH");
		try {
			a1.checkConflict(a2);
			fail();
		} catch (ConflictException e) {
		    //
		}
		
		//test time overlap
		a1.setActivityTime(1345, 1450);
		try {
			a1.checkConflict(a2);
			fail();
		} catch (ConflictException e) {
		    //skip line
		}
		a1.setActivityTime(1400, 1500);
		try {
			a1.checkConflict(a2);
			fail();
		} catch (ConflictException e) {
		    //skip line
		}
		a1.setActivityTime(1300, 1450);
		try {
			a1.checkConflict(a2);
			fail();
		} catch (ConflictException e) {
		    //skip line
		}
		a1.setActivityTime(1335, 1400);
		try {
			a1.checkConflict(a2);
			fail();
		} catch (ConflictException e) {
		    //skip line
		}
	}
}
