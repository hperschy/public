package edu.ncsu.csc216.pack_scheduler.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import edu.ncsu.csc216.collections.list.SortedList;
import edu.ncsu.csc216.pack_scheduler.course.Course;

import java.io.File;

/**
 * Reads Course records from text files.  Writes a set of CourseRecords to a file.
 * 
 * @author Hunter Perschy
 */
public class CourseRecordIO {

	/**
	 * Processes a line of data in a file with courses. If the processed data cannot be made into
	 * a Course object then it throws an exception.
	 * @param line A line of the file
	 * @return a Course object
	 */
    public static Course readCourse(String line) {
    	Scanner lineScan = new Scanner(line);
    	Course course = null;
    	while (lineScan.hasNext()) {
	        lineScan.useDelimiter(",");
	        try {
	        	int courseStartTime = 0;
            	int courseEndTime = 0;
	        	String courseName = lineScan.next();
	        	String courseTitle = lineScan.next();
            	String courseSection = lineScan.next();
            	int courseCredits = lineScan.nextInt();
            	String courseInstructorId = lineScan.next();
            	String courseMeetingDays = lineScan.next();
            	if (courseMeetingDays.equals("A")) {
            		try {
            			course = new Course(courseName, courseTitle, courseSection, courseCredits, courseInstructorId, courseMeetingDays);
            		} catch (IllegalArgumentException e){
            			throw new IllegalArgumentException();
            		}
            	} else {
            		courseStartTime = lineScan.nextInt();
            		courseEndTime = lineScan.nextInt();
            	}
            	try {
    				course = new Course(courseName, courseTitle, courseSection, courseCredits, courseInstructorId, courseMeetingDays, courseStartTime, courseEndTime);
                } catch (IllegalArgumentException e) {
                	throw new IllegalArgumentException();
                }
	        } catch (NoSuchElementException e) {
	        	lineScan.close();
	        	throw new IllegalArgumentException();
	        }
    	}
    	lineScan.close();
    	return course;
    }
	
	/**
     * Reads course records from a file and generates a list of valid Courses.  Any invalid
     * Courses are ignored.  If the file to read cannot be found or the permissions are incorrect
     * a File NotFoundException is thrown.
     * @param fileName file to read Course records from
     * @return a list of valid Courses
     * @throws FileNotFoundException if the file cannot be found or read
     */
    public static SortedList<Course> readCourseRecords(String fileName) throws FileNotFoundException {
    	Scanner fileReader = new Scanner(new File(fileName));
        SortedList<Course> courses = new SortedList<Course>();
        while (fileReader.hasNextLine()) {
            try {
                Course course = readCourse(fileReader.nextLine());
                boolean duplicate = false;
                for (int i = 0; i < courses.size(); i++) {
                    Course c = courses.get(i);
                    if (course.getName().equals(c.getName()) &&
                            course.getSection().equals(c.getSection())) {
                        //it's a duplicate
                        duplicate = true;
                    }
                }
                if (!duplicate) {
                    courses.add(course);
                }
            } catch (IllegalArgumentException e) {
                //skip the line
            }
        }
        fileReader.close();
        return courses;
    }

    /**
     * Writes the given list of Courses to 
     * @param fileName Name of the file to write
     * @param courses SortedList of courses
     * @throws IOException if the file cannot be saved
     */
    public static void writeCourseRecords(String fileName, SortedList<Course> courses) throws IOException {
    	PrintStream fileWriter = new PrintStream(new File(fileName));
    	for (int i = 0; i < courses.size(); i++) {
    	    fileWriter.println(courses.get(i).toString());
    	}
    	fileWriter.close();
    }

}
