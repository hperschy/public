/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.catalog;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.pack_scheduler.course.Course;

/**
 * Test for the CourseCatalog object
 * @author Hunter Perschy
 * @author Zach Scott
 */
public class CourseCatalogTest {

	/** Valid course records */
	private final String validTestFile = "test-files/course_records.txt";
	/** Invalid course records */
	private final String invalidTestFile = "test-files/invalid_course_records.txt";
	
	
	/**
	 * Resets course_records.txt for use in other tests.
	 */
	@Before
	public void setUp() throws Exception {
		//Reset course_records.txt so that it's fine for other needed tests
		Path sourcePath = FileSystems.getDefault().getPath("test-files", "starter_course_records.txt");
		Path destinationPath = FileSystems.getDefault().getPath("test-files", "course_records.txt");
		try {
			Files.deleteIfExists(destinationPath);
			Files.copy(sourcePath, destinationPath);
		} catch (IOException e) {
			fail("Unable to reset files");
		}
	}
	
	/**
	 * Tests CourseCatalog().
	 */
	@Test
	public void testCourseCatalog() {
		CourseCatalog cc = new CourseCatalog();
		assertEquals(0, cc.getCourseCatalog().length);	
	}
	
	/**
	 * Tests newCourseCatalog().
	 */
	@Test
	public void testNewCourseCatalog() {
		CourseCatalog cc = new CourseCatalog();
		assertEquals(0, cc.getCourseCatalog().length);
		cc.loadCoursesFromFile(validTestFile);
		cc.newCourseCatalog();
		assertEquals(0, cc.getCourseCatalog().length);
	}
	
	/**
	 * Tests loadCoursesFromFile().
	 */
	@Test
	public void testLoadCoursesFromFile() {
		//test invalid course catalog
		CourseCatalog cc = new CourseCatalog();
		assertEquals(0, cc.getCourseCatalog().length);
		cc.loadCoursesFromFile(invalidTestFile);
		assertEquals(0, cc.getCourseCatalog().length);
		
		//test valid course catalog
		cc.loadCoursesFromFile(validTestFile);
		assertEquals(8, cc.getCourseCatalog().length);
		
		//test invalid file
		cc.newCourseCatalog();
		try {
			cc.loadCoursesFromFile("test-files/not_a_file.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals(0, cc.getCourseCatalog().length);
		}
	}
	
	/**
	 * Test getCourseCatalog().
	 */
	@Test
	public void testGetCourseCatalog() {
		CourseCatalog cc = new CourseCatalog();
		cc.loadCoursesFromFile(validTestFile);
		
		//Get the catalog and make sure contents are correct
		//Name, section, title
		String [][] catalog = cc.getCourseCatalog();
		//Row 0
		assertEquals("CSC116", catalog[0][0]);
		assertEquals("001", catalog[0][1]);
		assertEquals("Intro to Programming - Java", catalog[0][2]);
		assertEquals("MW 9:10AM-11:00AM", catalog[0][3]);
		//Row 1
		assertEquals("CSC116", catalog[1][0]);
		assertEquals("002", catalog[1][1]);
		assertEquals("Intro to Programming - Java", catalog[1][2]);
		assertEquals("MW 11:20AM-1:10PM", catalog[1][3]);
		//Row 2
		assertEquals("CSC116", catalog[2][0]);
		assertEquals("003", catalog[2][1]);
		assertEquals("Intro to Programming - Java", catalog[2][2]);
		assertEquals("TH 11:20AM-1:10PM", catalog[2][3]);
		//Row 3
		assertEquals("CSC216", catalog[3][0]);
		assertEquals("001", catalog[3][1]);
		assertEquals("Programming Concepts - Java", catalog[3][2]);
		assertEquals("TH 1:30PM-2:45PM", catalog[3][3]);
		//Row 4
		assertEquals("CSC216", catalog[4][0]);
		assertEquals("002", catalog[4][1]);
		assertEquals("Programming Concepts - Java", catalog[4][2]);
		assertEquals("MW 1:30PM-2:45PM", catalog[4][3]);
		//Row 5
		assertEquals("CSC216", catalog[5][0]);
		assertEquals("601", catalog[5][1]);
		assertEquals("Programming Concepts - Java", catalog[5][2]);
		assertEquals("Arranged", catalog[5][3]);
		//Row 6
		assertEquals("CSC226", catalog[6][0]);
		assertEquals("001", catalog[6][1]);
		assertEquals("Discrete Mathematics for Computer Scientists", catalog[6][2]);
		assertEquals("MWF 9:35AM-10:25AM", catalog[6][3]);
		//Row 7
		assertEquals("CSC230", catalog[7][0]);
		assertEquals("001", catalog[7][1]);
		assertEquals("C and Software Tools", catalog[7][2]);
		assertEquals("MW 11:45AM-1:00PM", catalog[7][3]);
	}
	
	/**
	 * Test addCourseToCatalog().
	 */
	@Test
	public void testAddCourseToCatalog() {
		CourseCatalog cc = new CourseCatalog();
		cc.loadCoursesFromFile(validTestFile);
		
		//Add a course that doesn't exist
		assertTrue(cc.addCourseToCatalog("CSC492", "Programming with PB&J", "001", 4, "pbrooks", "MWF", 1000, 1020));
		assertEquals(9, cc.getCourseCatalog().length);
		
		//Attempt to add a course that does exist
		assertFalse(cc.addCourseToCatalog("CSC216", "Programming Concepts - Java", "001", 4, "sesmith5", "TH", 1330, 1445));
		assertEquals(9, cc.getCourseCatalog().length);
	}
	
	/**
	 * Test removeCourseFromCatalog().
	 */
	@Test
	public void testRemoveCourseFromCatalog() {
		CourseCatalog cc = new CourseCatalog();
		cc.loadCoursesFromFile(validTestFile);
		
		//Remove a course that doesn't exist
		assertFalse(cc.removeCourseFromCatalog("CSC492", "001"));
		assertEquals(8, cc.getCourseCatalog().length);
		
		//Remove a course that does exist
		assertTrue(cc.removeCourseFromCatalog("CSC216", "001"));
		assertEquals(7, cc.getCourseCatalog().length);
	}
	
	/**
	 * Test getCourseFromCatalog().
	 */
	@Test
	public void testGetCourseFromCatalog() {
		CourseCatalog cc = new CourseCatalog();
		cc.loadCoursesFromFile(validTestFile);
		assertEquals(8, cc.getCourseCatalog().length);
		
		//Get a course not in the catalog
		assertNull(cc.getCourseFromCatalog("S101", "001"));
		
		//Get a course from the catalog
		Course actualCourse = new Course("CSC216", "Programming Concepts - Java", "001", 4, "sesmith5", "TH", 1330, 1445);
		Course course = cc.getCourseFromCatalog("CSC216", "001");
		assertTrue(course.equals(actualCourse));
	}
	
	/**
	 * Test saveCourseCatalog().
	 */
	@Test
	public void testSaveCourseCatalog() {
		//Test that empty schedule exports correctly
		CourseCatalog cc = new CourseCatalog();
		cc.saveCourseCatalog("test-files/actual_empty_catalog.txt");
		checkFiles("test-files/expected_empty_export.txt", "test-files/actual_empty_catalog.txt");
		
		//Add courses and test that exports correctly
		cc.addCourseToCatalog("CSC216", "Programming Concepts - Java", "002", 4, "jtking", "MW", 1330, 1445);
		cc.addCourseToCatalog("CSC226", "Discrete Mathematics for Computer Scientists", "001", 3, "tmbarnes", "MWF", 935, 1025);
		assertEquals(2, cc.getCourseCatalog().length);
		cc.saveCourseCatalog("test-files/actual_catalog_export.txt");
		checkFiles("test-files/expected_schedule_export.txt", "test-files/actual_catalog_export.txt");
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try {
			Scanner expScanner = new Scanner(new File (expFile));
			Scanner actScanner = new Scanner(new File(actFile));
			
			while (actScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			if (expScanner.hasNextLine()) {
				fail();
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}
}
