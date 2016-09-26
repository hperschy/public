/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.user;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for Student
 * @author Hunter Perschy
 * @author Zach Scott
 */
public class StudentTest {

	/**
	 * Test method for hashCode().
	 */
	@Test
	public void testHashCode() {
		Student st = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez", 4);
		Student goodImposter = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez", 4);
		Student badImposter = new Student("StateParker", "Rivers", "Mississippi", "supgirl@email.com", "PBB&Jsforlifez", 6);
		assertEquals(true, st.hashCode() == goodImposter.hashCode());
		assertEquals(false, st.hashCode() == badImposter.hashCode());
		assertEquals(false, badImposter.hashCode() == goodImposter.hashCode());
	}

	/**
	 * Test method for Student constructor for all fields.
	 */
	@Test
	public void testStudentStringStringStringStringStringInt() {
		Student st = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez", 4);
		assertEquals("Parker", st.getFirstName());
		assertEquals("Brooks", st.getLastName());
		assertEquals("pbrooks", st.getId());
		assertEquals("pbrooks&j@email.com", st.getEmail());
		assertEquals("PB&Jsforlifez", st.getPassword());
		assertEquals(4, st.getMaxCredits());
		Student s = null; //Initialize a student reference to null
		try {
		    s = new Student(null, "last", "id", "email@ncsu.edu", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("", "last", "id", "email@ncsu.edu", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", null, "id", "email@ncsu.edu", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "", "id", "email@ncsu.edu", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", null, "email@ncsu.edu", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "", "email@ncsu.edu", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", null, "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "PB&J.com", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "PB@J", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "PB.J@email", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "email@ncsu.edu", null, 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "email@ncsu.edu", "", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "email@ncsu.edu", null, 2);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "email@ncsu.edu", null, -50);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "email@ncsu.edu", null, 19);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "email@ncsu.edu", null, Integer.MAX_VALUE);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
	}

	/**
	 * Test method for Student construct with maxCredit set as default value 18.
	 */
	@Test
	public void testStudentStringStringStringStringString() {
		Student st = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez");
		assertEquals("Parker", st.getFirstName());
		assertEquals("Brooks", st.getLastName());
		assertEquals("pbrooks", st.getId());
		assertEquals("pbrooks&j@email.com", st.getEmail());
		assertEquals("PB&Jsforlifez", st.getPassword());
		assertEquals(18, st.getMaxCredits());
		Student s = null; //Initialize a student reference to null
		try {
		    s = new Student(null, "last", "id", "email@ncsu.edu", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("", "last", "id", "email@ncsu.edu", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", null, "id", "email@ncsu.edu", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "", "id", "email@ncsu.edu", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", null, "email@ncsu.edu", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "", "email@ncsu.edu", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", null, "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "PB&J.com", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "PB@J", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "PB.J@email", "hashedpassword");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "email@ncsu.edu", null);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "email@ncsu.edu", "");
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
	}

	/**
	 * Test method for setEmail().
	 */
	@Test
	public void testSetEmail() {
		Student st = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez");
		st.setEmail("ParkerB&J@email.com");
		assertEquals("ParkerB&J@email.com", st.getEmail());
		try{
			st.setEmail(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("ParkerB&J@email.com", st.getEmail());
		}
		Student s = null;
		try {
		    s = new Student("first", "last", "id", "", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "PB&J.com", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "PB@J", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
		try {
		    s = new Student("first", "last", "id", "PB.J@email", "hashedpassword", 15);
		    fail();
		} catch (IllegalArgumentException e){
			assertNull(s);
		}
	}

	/**
	 * Test method for setPassword().
	 */
	@Test
	public void testSetPassword() {
		Student st = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez");
		st.setPassword("PB&J5f0r11f35");
		assertEquals("PB&J5f0r11f35", st.getPassword());
		try{
			st.setPassword(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("PB&J5f0r11f35", st.getPassword());
		}
	}

	/**
	 * Test method for setMaxCredits().
	 */
	@Test
	public void testSetMaxCredits() {
		Student st = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez");
		st.setMaxCredits(18);
		assertEquals(18, st.getMaxCredits());
		try{
			st.setMaxCredits(50);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(18, st.getMaxCredits());
		}
	}

	/**
	 * Test method for setFirstName().
	 */
	@Test
	public void testSetFirstName() {
		Student st = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez");
		st.setFirstName("Peanut");
		assertEquals("Peanut", st.getFirstName());
		try{
			st.setFirstName(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Peanut", st.getFirstName());
		}
	}

	/**
	 * Test method for setLastName().
	 */
	@Test
	public void testSetLastName() {
		Student st = new Student("Peanut", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez");
		st.setLastName("Butter");
		assertEquals("Butter", st.getLastName());
		try{
			st.setLastName(null);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Butter", st.getLastName());
		}
	}

	/**
	 * Test method for equals().
	 */
	@Test
	public void testEqualsObject() {
		Student st = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez", 4);
		Student goodImposter = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez", 4);
		Student badImposter = new Student("StateParker", "Rivers", "Mississippi", "supgirl@email.com", "PBB&Jsforlifez", 6);
		Student badImposter2 = new Student("StateParker", "Rivers", "Mississippi", "pbrooks&j@email.com", "PBB&Jsforlifez", 6);
		Student badImposter3 = new Student("Parker", "Rivers", "Mississippi", "pbrooks&j@email.com", "PBB&Jsforlifez", 6);
		Student badImposter4 = new Student("Parker", "Rivers", "Mississippi", "pbrooks&j@email.com", "PB&Jsforlifez", 6);
		Student badImposter5 = new Student("Parker", "Rivers", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez", 6);
		Student doesntExist = null;
		assertEquals(true, st.equals(goodImposter));
		assertEquals(false, st.equals(badImposter));
		assertEquals(false, goodImposter.equals(badImposter));
		assertEquals(false, st.equals(doesntExist));
		assertEquals(true, st.equals(st));
		assertEquals(false, st.equals(badImposter2));
		assertEquals(false, st.equals(badImposter3));
		assertEquals(false, st.equals(badImposter4));
		assertEquals(false, st.equals(badImposter5));
	}

	/**
	 * Test method for toString().
	 */
	@Test
	public void testToString() {
		Student st = new Student("Parker", "Brooks", "pbrooks", "pbrooks&j@email.com", "PB&Jsforlifez", 4);
		String ourBoysInfo = st.getFirstName() + "," + st.getLastName() + "," + st.getId() + "," + st.getEmail() + 
							 "," + st.getPassword() + "," + st.getMaxCredits();
		assertEquals(ourBoysInfo, st.toString());
	}
	
	/**
	 * Test method for compareTo().
	 */
	@Test
	public void testCompareTo() {
		Student s1 = new Student("a", "a", "aa", "11@email.com", "ONE", 4);
		Student s2 = new Student("a", "a", "aa", "11@email.com", "ONE", 4);
		Student s3 = new Student("b", "a", "aa", "11@email.com", "ONE", 4);
		Student s4 = new Student("a", "b", "aa", "11@email.com", "ONE", 4);
		Student s5 = new Student("a", "a", "a", "11@email.com", "ONE", 4);
		Student s6 = new Student("aa", "a", "aa", "11@email.com", "ONE", 4);
		Student s7 = new Student("a", "aa", "aa", "11@email.com", "ONE", 4);
		Student s8 = new Student("a", "a", "aaa", "11@email.com", "ONE", 4);
		assertEquals(0, s1.compareTo(s2));
		assertEquals(1, s3.compareTo(s1));
		assertEquals(1, s4.compareTo(s1));
		assertEquals(-1, s5.compareTo(s1));
		assertEquals(1, s6.compareTo(s1));
		assertEquals(1, s7.compareTo(s1));
		assertEquals(1, s8.compareTo(s1));
	
		Student s11 = new Student("A", "A", "aa", "11@email.com", "ONE", 4);
		Student s22 = new Student("A", "A", "aa", "11@email.com", "ONE", 4);
		Student s33 = new Student("B", "A", "ba", "11@email.com", "ONE", 4);
		Student s44 = new Student("A", "B", "ab", "11@email.com", "ONE", 4);
		Student s55 = new Student("A", "A", "a", "11@email.com", "ONE", 4);
		Student s66 = new Student("Aa", "A", "aa", "11@email.com", "ONE", 4);
		Student s77 = new Student("A", "Aa", "aa", "11@email.com", "ONE", 4);
		Student s88 = new Student("A", "A", "aaa", "11@email.com", "ONE", 4);
		assertEquals(0, s11.compareTo(s22));
		assertEquals(1, s33.compareTo(s11));
		assertEquals(1, s44.compareTo(s11));
		assertEquals(-1, s55.compareTo(s11));
		assertEquals(1, s66.compareTo(s11));
		assertEquals(1, s77.compareTo(s11));
		assertEquals(1, s88.compareTo(s11));
		assertTrue(s11.compareTo(s1) < 0);
	}

}
