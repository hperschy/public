/**
 * 
 */
package edu.ncsu.csc216.pack_scheduler.course;

/**
 * Creates a Course object 
 * @author Hunter Perschy
 * @author Zach Scott
 */
public class Course extends Activity implements Comparable<Course> {
	
	/** Length of section number. */
	private static final int SECTION_LENGTH = 3;
	/** Max length of course name. */
	private static final int MAX_NAME_LENGTH = 6;
	/** Min length of course name. */
	private static final int MIN_NAME_LENGTH = 4;
	/** Max credit hours for a course. */
	private static final int MAX_CREDITS = 5;
	/** Min credit hours for a course. */
	private static final int MIN_CREDITS = 1;
	/** Course's name. */
	private String name;
	/** Course's section. */
	private String section;
	/** Course's credit hours */
	private int credits;
	/** Course's instructor */
	private String instructorId;
	/**
	 * Returns the Course's name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Course's name.  If the name is null, has a length less than 4 or 
	 * greater than 6, an IllegalArgumentException is thrown.
	 * @param name the name to set
	 * @throws IllegalArgumentException if name is null or length is less than 4 or 
	 * greater than 6
	 */
	private void setName(String name) {
	    if (name == null) {
	        throw new IllegalArgumentException();
	    }
	    if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
	        throw new IllegalArgumentException();
	    }
	    this.name = name;
	}

	/**
	 * Returns the Course's section
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * Sets the Course's section. If the section is null, an empty string, more than 3 numbers,
	 * or if it consists of characters other than digits an IllegalArgumentException is thrown.
	 * @param section the section to set
	 * @throws IllegalArgumentException if section is null or empty.
	 */
	public void setSection(String section) {
		if (section == null || section.equals("")) {
			throw new IllegalArgumentException();
		}
		if (section.length() != SECTION_LENGTH) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < section.length() - 1; i++) {
			if (!Character.isDigit(section.charAt(i))) {
				throw new IllegalArgumentException();
			}
		}
		this.section = section;
	}

	/**
	 * Returns the Course's credits hours
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets the Course's credit hours. If the number of credits is less than 1
	 * or greater than 5 an exception is thrown.
	 * @param credits the credits to set
	 * @throws IllegalArgumentException if credits are below 1 or greater than 5
	 */
	public void setCredits(int credits) {
		if (credits < MIN_CREDITS || credits > MAX_CREDITS) {
			throw new IllegalArgumentException();
		}
		this.credits = credits;
	}

	/**
	 * Returns the Course's instructor
	 * @return the instructorId
	 */
	public String getInstructorId() {
		return instructorId;
	}

	/**
	 * Sets the Course's instructor
	 * @param instructorId the instructorId to set
	 */
	public void setInstructorId(String instructorId) {
		if (instructorId == null || instructorId.equals("")) {
			throw new IllegalArgumentException();
		}
		this.instructorId = instructorId;
	}

	/**
	 * Constructs a Course object with values for all fields.
	 * @param name name of Course
	 * @param title title of Course
	 * @param section section of Course
	 * @param credits credit hours for Course
	 * @param instructorId instructor's unity id
	 * @param meetingDays meeting days for Course as series of chars
	 * @param startTime start time for Course
	 * @param endTime end time for Course
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays,
	        int startTime, int endTime) {
	    super(title, meetingDays, startTime, endTime);
		setName(name);
	    setSection(section);
	    setCredits(credits);
	    setInstructorId(instructorId);
	}

	/**
	 * Creates a Course with the given name, title, section, credits, instructorId, and meetingDays for 
     * courses that are arranged.
	 * @param name Name of the course
	 * @param title Title of the course
	 * @param section Section of the course
	 * @param credits Number of credits for the course
	 * @param instructorId Instructor's id
	 * @param meetingDays Days the course meets
	 */
	public Course(String name, String title, String section, int credits, String instructorId, String meetingDays) {
		super(title, meetingDays, 0, 0);
		setName(name);
	    setSection(section);
	    setCredits(credits);
	    setInstructorId(instructorId);
	}

	/**
	 * Sets the Course's meeting days
	 * Throws an exception if meetingDays is null, empty string, contains any character except
	 * 'M', 'T', 'W', 'H', 'F', or 'A' and if 'A' and anything else.
	 * @param meetingDays meeting days to be set
	 * @throws IllegalArgumentException if meetingDays is null or empty.
	 */
	@Override
	public void setMeetingDays(String meetingDays) {
		if (meetingDays == null || meetingDays.equals("")) {
			throw new IllegalArgumentException();
		}
		for (int j = 0; j <= meetingDays.length() - 1; j++) {
			if (meetingDays.charAt(j) != 'M' && meetingDays.charAt(j) != 'T' && meetingDays.charAt(j) != 'W' 
					&& meetingDays.charAt(j) != 'H' && meetingDays.charAt(j) != 'F' && meetingDays.charAt(j) != 'A') {
				throw new IllegalArgumentException();
			}
		}
		for (int i = 0; i <= meetingDays.length() - 1; i++) {
			if (meetingDays.charAt(i) == 'A' && meetingDays.length() != 1) {
				throw new IllegalArgumentException();
			}
		} 
		super.setMeetingDays(meetingDays);
	}
	
	/**
	 * Creates and returns a hash code value for an Course object
	 * @return result hash code value
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + credits;
		result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		return result;
	}

	/**
	 * Checks for equality between to Activity objects
	 * @return true if they are the same, false if not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (credits != other.credits)
			return false;
		if (instructorId == null) {
			if (other.instructorId != null)
				return false;
		} else if (!instructorId.equals(other.instructorId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		return true;
	}

	/**
	 * Returns a comma separated value String of all Course fields.
	 * @return String representation of Course
	 */
	@Override
	public String toString() {
	    if (getMeetingDays().equals("A")) {
	        return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," + getMeetingDays();
	    }
	    return name + "," + getTitle() + "," + section + "," + credits + "," + instructorId + "," + getMeetingDays() + "," + getStartTime() + "," + getEndTime(); 
	}

	/**
	 * Returns a String array of the Course fields name, section, title, and meeting string.
	 * @return String[] containing above fields
	 */
	@Override
	public String[] getShortDisplayArray() {
		String [] shortDisplay = new String[4];
		shortDisplay[0] = getName();
		shortDisplay[1] = getSection();
		shortDisplay[2] = getTitle();
		shortDisplay[3] = getMeetingString();
		return shortDisplay;
	}
	
	/**
	 * Returns a String array of all the Course fields.
	 * @return String[] containing all fields
	 */
	@Override
	public String[] getLongDisplayArray() {
		String [] longDisplay = new String[7];
		longDisplay[0] = getName();
		longDisplay[1] = getSection();
		longDisplay[2] = getTitle();
		longDisplay[3] = "" + getCredits();
		longDisplay[4] = getInstructorId();
		longDisplay[5] = getMeetingString();
		longDisplay[6] = "";
		return longDisplay;
	}

	/**
	 * Checks to see if one course has the same name as another
	 * @return true if the same name else false
	 */
	@Override
	public boolean isDuplicate(Activity activity) {
		if (activity instanceof Course) {
			Course course = (Course) activity;
			if (course.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Compares this Course to another for sorting purposes
	 * @param c Course to be compared to this Course
	 * @return integer less than 0 if less than, 0 if equal, and an integer greater than 0 if greater
	 */
	@Override
	public int compareTo(Course c) {
		if(!this.name.equals(c.getName())){
			return this.name.compareTo(c.getName());
		} else {
			if(!this.section.equals(c.getSection())){
				return this.section.compareTo(c.getSection());
			}
		}
		return 0;
	}
}
