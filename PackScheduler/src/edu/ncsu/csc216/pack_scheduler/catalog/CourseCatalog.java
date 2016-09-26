/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.catalog;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.ncsu.csc216.collections.list.SortedList;
import edu.ncsu.csc216.pack_scheduler.course.Course;
import edu.ncsu.csc216.pack_scheduler.io.CourseRecordIO;

/**
 * A catalog of Courses.
 * @author hjpersch
 * @author Zach Scott
 */
public class CourseCatalog {
	/** a CourseCatalog has a SortedList of Courses that make up the catalog */
	private SortedList<Course> catalog;
	
	/**
	 * Constructs an empty catalog
	 */
	public CourseCatalog() {
		catalog = new SortedList<Course>();
	}
	
	/**
	 * Resets course catalog
	 */
	public void newCourseCatalog() {
		catalog = new SortedList<Course>();
	}
	
	/**
	 * Loads a course catalog from a file
	 * @param fileName name of the file to load
	 * @throws IllegalArgumentException when it cannot load the file
	 */
	public void loadCoursesFromFile(String fileName) {
		try {
			catalog = CourseRecordIO.readCourseRecords(fileName);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Cannot find file.");
		}
	}
	
	/**
	 * Adds a given course to the catalog
	 * @param name name of the course
	 * @param title title of the course
	 * @param section course section
	 * @param credits number of credit hours
	 * @param instructorId instructor's id
	 * @param meetingDays days that it meets
	 * @param startTime time it starts
	 * @param endTime time it ends
	 * @return true if the course can be added else false if cannot
	 */
	public boolean addCourseToCatalog(String name, String title, String section, int credits, String instructorId, String meetingDays, int startTime, int endTime) {
		for (int i = 0; i <= catalog.size() - 1; i++) {
			if (name.equals(catalog.get(i).getName()) && section.equals(catalog.get(i).getSection())) {
				return false;
			}
		}
		Course c = new Course(name, title, section, credits, instructorId, meetingDays, startTime, endTime);
		catalog.add(c);
		return true;
	}
	
	/**
	 * Removes a course from the catalog
	 * @param name name of the course to be removed
	 * @param section course section
	 * @return true if can be removed else false if cannot
	 */
	public boolean removeCourseFromCatalog (String name, String section) {
		for (int i = 0; i <= catalog.size() - 1; i++) {
			if (name.equals(catalog.get(i).getName()) && section.equals(catalog.get(i).getSection())) {
				catalog.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns a course from the catalog
	 * @param name name of the course to return
	 * @param section course section
	 * @return the course
	 */
	public Course getCourseFromCatalog(String name, String section) {
		for (int i = 0; i <= catalog.size() - 1; i++) {
			if (name.equals(catalog.get(i).getName()) && section.equals(catalog.get(i).getSection())) {
				return catalog.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Returns the course catalog in a 2D String array
	 * @return the courses in the catalog with their information
	 */
	public String[][] getCourseCatalog() {
		String [][] courseCatalogString = new String [catalog.size()][4];
		for (int i = 0; i <= catalog.size() - 1; i++) {
			courseCatalogString[i][0] = catalog.get(i).getName();
			courseCatalogString[i][1] = catalog.get(i).getSection();
			courseCatalogString[i][2] = catalog.get(i).getTitle();
			courseCatalogString[i][3] = catalog.get(i).getMeetingString();
		}
		return courseCatalogString;
	}
	
	/**
	 * Writes the catalog to a file
	 * @param exportFile the file to write to
	 * @throws IllegalArgumentException if cannot write to the file
	 */
	public void saveCourseCatalog(String exportFile) {
		try {
			CourseRecordIO.writeCourseRecords(exportFile, catalog);
		} catch (IOException e){
			throw new IllegalArgumentException("The file cannot be saved");
		}
	}
}
