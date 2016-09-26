package edu.ncsu.csc216.pack_scheduler.user;

/**
 * Creates a Student object
 * @author Hunter Perschy
 * @author Zach Scott
 */
public class Student implements Comparable<Student> {
	/** Highest amount of credits a student may take */
	public static final int MAX_CREDITS = 18;
	
	/** Student's first name */
	private String firstName;
	
	/** Student's last name */
	private String lastName;
	
	/** Student's id number */
	private String id;
	
	/** Student's email address */
	private String email;
	
	/** Student's hashed password */
	private String hashedPassword;
	
	/** How many credits the student is taking */
	private int maxCredits;
	
	/**
	 * Constructs a Student object with all fields
	 * @param firstName first name of the Student
	 * @param lastName last name of the Student
	 * @param id id of the Student
	 * @param email email address of the Student
	 * @param hashedPassword hashed password of the Student
	 * @param maxCredits credit hours of the Student
	 */
	public Student(String firstName, String lastName, String id, String email, String hashedPassword, int maxCredits) {
		setFirstName(firstName);
		setLastName(lastName);
		setId(id);
		setEmail(email);
		setPassword(hashedPassword);
		setMaxCredits(maxCredits);
		
	}
	
	/**
	 * Constructs a Student object with maxCredits set to 18
	 * @param firstName first name of the Student
	 * @param lastName last name of the Student
	 * @param id id of the Student
	 * @param email email address of the Student
	 * @param hashedPassword hashed password of the Student
	 */
	public Student(String firstName, String lastName, String id, String email, String hashedPassword) {
		setFirstName(firstName);
		setLastName(lastName);
		setId(id);
		setEmail(email);
		setPassword(hashedPassword);
		setMaxCredits(18);
		
	}
	
	/**
	 * Gets the Student's Email address
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the Student's hashed Password
	 * @return the hashedPassword
	 */
	public String getPassword() {
		return hashedPassword;
	}

	/**
	 * Gets the Student's credit hours
	 * @return the maxCredits
	 */
	public int getMaxCredits() {
		return maxCredits;
	}

	/**
	 * Sets Student's email. If email is null or an empty String throws exception.
	 * If it does not contain a '@' or '.' or if the '.' is before the '@', throws an exception.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("Invalid email");
		}
		int atSignIndex = -1;
		int periodIndex = -1;
		for (int i = 0; i < email.length(); i++ ) {
			if (email.charAt(i) == '@' && atSignIndex == -1) {
				atSignIndex = i;
			}
			if (email.charAt(i) == '.') {
				periodIndex = i; 
			}
		}
		if (atSignIndex == -1 || periodIndex == -1 || periodIndex < atSignIndex) {
			throw new IllegalArgumentException("Invalid email");
		}
		this.email = email;
	}

	/**
	 * Sets the Students hashed password. If the password is null or empty throws an exception
	 * @param hashedPassword the hashedPassword to set
	 */
	public void setPassword(String hashedPassword) {
		if (hashedPassword == null || hashedPassword.equals("")) {
			throw new IllegalArgumentException("Invalid password");
		}
		this.hashedPassword = hashedPassword;
	}

	/**
	 * Sets Student's maxCredits. If less than 3 or greater than 18, throws an exception.
	 * @param maxCredits the maxCredits to set
	 */
	public void setMaxCredits(int maxCredits) {
		if (maxCredits < 3 || maxCredits > MAX_CREDITS) {
			throw new IllegalArgumentException("Invalid max credits");
		}
		this.maxCredits = maxCredits;
	}

	/**
	 * Sets the Student's first name. If null or empty throws an exception.
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.equals("")) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}

	/**
	 * Sets the Student's last name. If null or empty throws an exception
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if (lastName == null || lastName.equals("")) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}

	/**
	 * Sets the Student's id. If null or empty throws an exception
	 * @param id the id to set
	 */
	private void setId(String id) {
		if (id == null || id.equals("")) {
			throw new IllegalArgumentException("Invalid id");
		}
		this.id = id;
	}
	
	/**
	 * Gets the Student's first name
	 * @return first name of the Student
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the Student's last name
	 * @return last name of the Student
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Gets the Student's id
	 * @return id of the Student
	 */
	public String getId() {
		return id;
	}

	/** 
	 * Generates and returns hashCode.
	 * @return result the hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((hashedPassword == null) ? 0 : hashedPassword.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + maxCredits;
		return result;
	}

	/**
	 * Compares two objects to see if they are equal on all accounts.
	 * @param obj the object to compare
	 * @return true if equal false if not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (hashedPassword == null) {
			if (other.hashedPassword != null)
				return false;
		} else if (!hashedPassword.equals(other.hashedPassword))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (maxCredits != other.maxCredits)
			return false;
		return true;
	}

	/**
	 * Prints all fields and their values
	 * @return fields and their values 
	 */
	@Override
	public String toString() {
		return firstName + "," + lastName + "," + id + "," + email
				+ "," + hashedPassword + "," + maxCredits;
	}

	/**
	 * Compares two students to see which one comes first
	 * @return int 0 if the same, - if less, + if greater 
	 */
	@Override
	public int compareTo(Student s) {
		if(!this.lastName.equals(s.getLastName())){
			return this.lastName.compareTo(s.getLastName());
		} else {
			if(!this.firstName.equals(s.getFirstName())){
				return this.firstName.compareTo(s.getFirstName());
			} else {
				if(!this.id.equals(s.getId())){
					return this.id.compareTo(s.getId());
				}
			}
		}
		return 0;
	}

}
