/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.io;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.collections.list.SortedList;
import edu.ncsu.csc216.pack_scheduler.user.Student;

/**
 * Tests StudentRecordIO
 * @author Zach Scott
 * @author Hunter Perschy
 */
public class StudentRecordIOTest {
	
	/** Valid student records */
	private final String validTestFile = "test-files/student_records.txt";
	/** Invalid student records */
	private final String inValidTestFile = "test-files/invalid_student_records.txt";
	
	/** Expected results for valid students */
	private final String validStudent1 = "Zahir,King,zking,orci.Donec@ametmassaQuisque.com,pw,15";
	private final String validStudent2 = "Cassandra,Schwartz,cschwartz,semper@imperdietornare.co.uk,pw,4";
	private final String validStudent3 = "Shannon,Hansen,shansen,convallis.est.vitae@arcu.ca,pw,14";
	private final String validStudent4 = "Demetrius,Austin,daustin,Curabitur.egestas.nunc@placeratorcilacus.co.uk,pw,18";
	private final String validStudent5 = "Raymond,Brennan,rbrennan,litora.torquent@pellentesquemassalobortis.ca,pw,12";
	private final String validStudent6 = "Emerald,Frost,efrost,adipiscing@acipsumPhasellus.edu,pw,3";
	private final String validStudent7 = "Lane,Berg,lberg,sociis@non.org,pw,14";
	private final String validStudent8 = "Griffith,Stone,gstone,porta@magnamalesuadavel.net,pw,17";
	private final String validStudent9 = "Althea,Hicks,ahicks,Phasellus.dapibus@luctusfelis.com,pw,11";
	private final String validStudent10 = "Dylan,Nolan,dnolan,placerat.Cras.dictum@dictum.net,pw,5";
	/** Array to hold expected results */
	private final String[] validStudents = {validStudent1, validStudent2, validStudent3, validStudent4, validStudent5, validStudent6,
											validStudent7, validStudent8, validStudent9, validStudent10};
	
	private String hashPW;
	private static final String HASH_ALGORITHM = "SHA-256";

	/**
	 * Helper method that generates hashed password for students.
	 */
	@Before
	public void setUp() {
	    try {
	        String password = "pw";
	        MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
	        digest.update(password.getBytes());
	        hashPW = new String(digest.digest());
	        
	        for (int i = 0; i < validStudents.length; i++) {
	            validStudents[i] = validStudents[i].replace(",pw,", "," + hashPW + ",");
	        }
	    } catch (NoSuchAlgorithmException e) {
	        fail("Unable to create hash during setup");
	    }
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try {
			Scanner expScanner = new Scanner(new FileInputStream(expFile));
			Scanner actScanner = new Scanner(new FileInputStream(actFile));
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}
	
	/**
	 * Test method for StudentRecordIO.readStudentRecords() with valid student records.
	 */
	@Test
	public void testReadValidStudentRecords() {
		SortedList<Student> sa;
		try {
			sa = StudentRecordIO.readStudentRecords(validTestFile);
			//test correct number of students
			assertEquals(10, sa.size());
			//test each individual student is as expected
			for (int i = 0; i <= validStudents.length - 2; i++) {
				assertTrue(0 > sa.get(i).compareTo(sa.get(i + 1)));
			}
		} catch (FileNotFoundException e) {
			fail("File could not be read");
		}
	}
	
	/**
	 * Test method for StudentRecordIO.readStudentRecords() with invalid student records.
	 */
	@Test
	public void testReadInvalidStudentRecords() {
		SortedList<Student> sa;
		try {
			sa = StudentRecordIO.readStudentRecords(inValidTestFile);
			//test correct number of students
			assertEquals(0, sa.size());
		} catch (FileNotFoundException e) {
			fail("Fail could not be read");
		}
	}
	
	/**
	 * Test method for StudentRecordIO.readStudentRecords() with invalid file.
	 */
	@Test
	public void testReadInvalidFile() {
		try {
			@SuppressWarnings("unused")
			SortedList<Student> sa = StudentRecordIO.readStudentRecords("test-files/not_a_file.txt");
			fail();
		} catch (FileNotFoundException e){
			//skip line
		}
	}

	/**
	 * Test method for StudentRecordIO.writeStudentRecords() with a valid file.
	 */
	@Test
	public void testWriteStudentRecordsNoPermissions() {
		SortedList<Student> sd = new SortedList<Student>();
		sd.add(new Student ("Zahir", "King", "zking", "orci.Donec@ametmassaQuisque.com", hashPW, 15));
		try {
			StudentRecordIO.writeStudentRecords("test-files/actual_student_records.txt", sd);
		} catch (IOException e) {
			fail("File could not be written");
		}
		checkFiles("test-files/expected_student_records.txt", "test-files/actual_student_records.txt");
	}
	/**
	 * Test method for StudentRecordIO.writeStudentRecords() with an invalid file.
	 */
	@Test
	public void testInvalidWriteStudentRecords() {
		SortedList<Student> sd = new SortedList<Student>();
		sd.add(new Student ("Zahir", "King", "zking", "orci.Donec@ametmassaQuisque.com", hashPW, 15));
		try {
	        StudentRecordIO.writeStudentRecords("/home/sesmith5/actual_student_records.txt", sd);
	        fail("Attempted to write to a directory location that doesn't exist or without the appropriate permissions and the write happened.");
	    } catch (IOException e) {
	        assertEquals("/home/sesmith5/actual_student_records.txt (Permission denied)", e.getMessage());
	        //The actual error message on Jenkins
	    }
	}

}
