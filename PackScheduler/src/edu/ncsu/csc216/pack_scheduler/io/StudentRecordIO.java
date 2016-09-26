package edu.ncsu.csc216.pack_scheduler.io;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;

import edu.ncsu.csc216.collections.list.SortedList;
import edu.ncsu.csc216.pack_scheduler.user.Student;
/**
 * Reads and Writes Student Record Files.
 * @author Hunter Perschy
 * @author Zach Scott
 */
public class StudentRecordIO {
	/**
	 * Reads a file containing student information and creates an Array List
	 * @param fileName Name of the file to be read
	 * @return Array of Students
	 * @throws FileNotFoundException if invalid file name is input
	 */
	public static SortedList<Student> readStudentRecords(String fileName) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new FileInputStream(fileName));
		Scanner lineScan = null;
	    SortedList<Student> students = new SortedList<Student>();
	    while (fileReader.hasNextLine()) {
	    	String studentInfo = fileReader.nextLine();
	        lineScan = new Scanner(studentInfo);
	        lineScan.useDelimiter(",");
	        String firstName = lineScan.next();
	        String lastName = lineScan.next();
            String id = lineScan.next();
            String email = lineScan.next();
            String hashedPassword = lineScan.next();
            try {
            	int maxCredits = lineScan.nextInt();
            	try {
                	Student student = new Student(firstName, lastName, id, email, hashedPassword, maxCredits);
                	students.add(student);
                } catch (IllegalArgumentException e) {
                	//skip line
                }
            } catch (NoSuchElementException e){
            	//skip line
            }
	    }
	    fileReader.close();
	    if(lineScan != null){
	    	lineScan.close();
	    }
	    return students;
	}

	/**
	 * Creates a text file with Student Information from an Array List of students
	 * @param fileName name of File to be written
	 * @param sd Sorted list of students
	 * @throws IOException if file cannot be saved
	 */
	public static void writeStudentRecords(String fileName, SortedList<Student> sd) throws IOException {
		PrintStream fileWriter = new PrintStream(new File(fileName));
		for(int i = 0; i < sd.size(); i++){
			fileWriter.print(sd.get(i).getFirstName() + ",");
			fileWriter.print(sd.get(i).getLastName() + ",");
			fileWriter.print(sd.get(i).getId() + ",");
			fileWriter.print(sd.get(i).getEmail() + ",");
			fileWriter.print(sd.get(i).getPassword() + ",");
			fileWriter.println(sd.get(i).getMaxCredits());
		}
	}
}
