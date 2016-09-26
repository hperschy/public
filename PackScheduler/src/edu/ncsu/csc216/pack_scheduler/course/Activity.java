package edu.ncsu.csc216.pack_scheduler.course;

/**
 * Parent class to Event and Course
 * @author Hunter Perschy
 * @author Zach Scott 
 */
public abstract class Activity implements Conflict {

	/** Max military time. */
	private static final int UPPER_TIME = 2359;
	/** Course's title. */
	private String title;
	/** Course's meeting days */
	private String meetingDays;
	/** Course's starting time */
	private int startTime;
	/** Course's ending time */
	private int endTime;

	/**
	 * Constructs Activity object with given parameters
	 * @param title the title of the Activity
	 * @param meetingDays days the Activity meets
	 * @param startTime time Activity starts
	 * @param endTime time Activity ends
	 */
	public Activity(String title, String meetingDays, int startTime, int endTime) {
		setTitle(title);
		setMeetingDays(meetingDays);
		setActivityTime(startTime, endTime);
	}

	/**
	 * An array containing fields of an Activity object delegated to Event and Course 
	 * @return array with fields
	 */
	public abstract String[] getShortDisplayArray();
	/** 
	 * An array containing fields of an Activity object delegated to Event and Course
	 * @return array with fields
	 */
	public abstract String[] getLongDisplayArray();
	/**
	 * Checks equality off an Activity object, delegated to Event and Course 
	 * @param activity Activity object to compare
	 * @return true if equal, false if not
	 */
	public abstract boolean isDuplicate(Activity activity);
	
	/**
	 * Returns the Activity's title
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the Activity's title. If the title is null or an empty string an
	 * IllegalArgumentException is thrown.
	 * @param title the title to set
	 * @throws IllegalArgumentException if title is null or empty string
	 */
	public void setTitle(String title) {
		if (title == null || title.equals("")) {
	        throw new IllegalArgumentException();
		}
		this.title = title;
	}

	/**
	 * Returns the Activity's meeting days
	 * @return the meetingDays
	 */
	public String getMeetingDays() {
		return meetingDays;
	}

	/**
	 * Sets the Activity's meeting days. If it is null, empty string, contains characters other than
	 * 'M', 'T', 'W', 'H', 'F', and 'A' or if contains 'A' and it is not the only character,
	 * the method throws an exception.
	 * @param meetingDays the meetingDays to set
	 * @throws IllegalArgumentException if meetingDays is null, empty, or contains characters other than
	 * 'M', 'T', 'W', 'H', 'F', or 'A', or if meetingDays contains 'A' with any other character.
	 */
	public void setMeetingDays(String meetingDays) {
		this.meetingDays = meetingDays;
	}

	/**
	 * Sets the Activity's start time
	 * @return the startTime
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Returns the Activity's end time
	 * @return the endTime
	 */
	public int getEndTime() {
		return endTime;
	}

	/**
	 * Sets the Activity's start and end time. If the start time or end time is less than 0 or greater than 2359, 
	 * the end time is less than the start time, startTime or endTime are invalid military times, 
	 * or if meetingDays is "A" and startTime and endTime are not 0, the method throws an exception.
	 * @param startTime the startTime to set
	 * @param endTime the endTime to set
	 * @throws IllegalArgumentException if startTime and endTime are less than 0 or greater than 2359, if their
	 * digit in the tens place exceeds 5, or if Arranged courses are assigned start and end times.
	 */
	public void setActivityTime(int startTime, int endTime) {
		if(startTime < 0 || startTime > UPPER_TIME || endTime < 0 || endTime > UPPER_TIME) {
			throw new IllegalArgumentException();
		}
		if(startTime % 100 > 59 || endTime % 100 > 59) {
			throw new IllegalArgumentException();
		}
		if (endTime < startTime) {
			throw new IllegalArgumentException();
		}
		if (getMeetingDays().equals("A") && startTime != 0 && endTime != 0) {
			throw new IllegalArgumentException();
		}
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * Converts the start time and end time of a course from military time to standard time.
	 * @return the courses meeting days, start time, and end time
	 */
	public String getMeetingString() {
		int standStartTime = 0;
		int standEndTime = 0;
		if (startTime > 1259) {
			standStartTime = startTime - 1200;
		} else {
			standStartTime = startTime;
		}
		if (endTime > 1259) {
			standEndTime = endTime - 1200;
		} else {
			standEndTime = endTime;
		}
		String startFirstNum = (standStartTime % 10) + "";
		String startSecondNum = ((standStartTime / 10) % 10) + "";
		String startThirdNum = ((standStartTime / 100) % 10) + "";
		String startFourthNum = ((standStartTime / 1000) % 10) + "";
		String endFirstNum = (standEndTime % 10) + "";
		String endSecondNum = ((standEndTime / 10) % 10) + "";
		String endThirdNum = ((standEndTime / 100) % 10) + "";
		String endFourthNum = ((standEndTime / 1000) % 10) + "";
		String startAmOrPm = "";
		String endAmOrPm = "";
		if (startTime > 1159) {
			startAmOrPm = "PM";
		} else {
			startAmOrPm = "AM";
		}
		if (endTime > 1159) {
			endAmOrPm = "PM";
		} else {
			endAmOrPm = "AM";
		}
		String standStartString = "";
		String standEndString = "";
		if (!startFourthNum.equals("0")) {
			standStartString = startFourthNum + startThirdNum + ":" + startSecondNum + startFirstNum + startAmOrPm;
		} else {
			standStartString = startThirdNum + ":" + startSecondNum + startFirstNum + startAmOrPm;
		}
		if (!endFourthNum.equals("0")) {
			standEndString = endFourthNum + endThirdNum + ":" + endSecondNum + endFirstNum + endAmOrPm;
		} else {
			standEndString = endThirdNum + ":" + endSecondNum + endFirstNum + endAmOrPm;
		}
		if (meetingDays.equals("A")) {
			return "Arranged";
		}
		return getMeetingDays() + " " + standStartString + "-" + standEndString;
	}
	
	/**
	 * Checks if there is a conflict in time between two Activities
	 * @param possibleConflictingActivity Activity to check
	 * @throws ConflictException if there is a conflict
	 */
	@Override
	public void checkConflict(Activity possibleConflictingActivity) throws ConflictException {
		char[] thisMeetingDays = this.meetingDays.toCharArray();
		char[] oMeetingDays = possibleConflictingActivity.getMeetingDays().toCharArray();	
		if (!this.meetingDays.equals("A") && !possibleConflictingActivity.getMeetingDays().equals("A")) {
			for (int i = 0; i < thisMeetingDays.length; i++) {
				for (int j = 0; j < oMeetingDays.length; j++) {
					if (thisMeetingDays[i] == oMeetingDays[j]) {
						if (this.startTime <= possibleConflictingActivity.getStartTime() && this.endTime <= possibleConflictingActivity.getEndTime()
								&& this.endTime >= possibleConflictingActivity.getStartTime()) {
							throw new ConflictException();
						}
						if (this.startTime >= possibleConflictingActivity.getStartTime() && this.endTime >= possibleConflictingActivity.getEndTime()
								&& this.startTime <= possibleConflictingActivity.getEndTime()) {
							throw new ConflictException();
						}
						if (this.startTime < possibleConflictingActivity.getStartTime() && this.endTime > possibleConflictingActivity.getEndTime()
								&& this.startTime < possibleConflictingActivity.getEndTime() && this.endTime > possibleConflictingActivity.getStartTime()) {
							throw new ConflictException();
						}
						if (this.startTime > possibleConflictingActivity.getStartTime() && this.endTime < possibleConflictingActivity.getEndTime()
								&& this.startTime < possibleConflictingActivity.getEndTime() && this.endTime > possibleConflictingActivity.getStartTime()) {
							throw new ConflictException();
						}
					}
				}
			}	
		}
	}
	/**
	 * Creates and returns a hash code value for an Activity object
	 * @return result hash code value
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + ((meetingDays == null) ? 0 : meetingDays.hashCode());
		result = prime * result + startTime;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (endTime != other.endTime)
			return false;
		if (meetingDays == null) {
			if (other.meetingDays != null)
				return false;
		} else if (!meetingDays.equals(other.meetingDays))
			return false;
		if (startTime != other.startTime)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}