package entities;

public class Teacher extends User {
	public String course;

	public Teacher(String name, String userID, String password, String course) {
		super(name, userID, password);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String subject) {
		this.course = subject;
	}

}
