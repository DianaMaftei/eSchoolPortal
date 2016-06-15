package entities;

import java.util.ArrayList;

public class Student extends User {

	private ArrayList<Course> courses;

	public Student(String name, String userID, String password) {
		super(name, userID, password);
		this.courses = new ArrayList<>();
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> subjects) {
		this.courses = subjects;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
