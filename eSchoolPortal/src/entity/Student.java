package entity;

import java.util.ArrayList;

public class Student extends User{
	
	private ArrayList<Subject> subjects;



	public Student(String name, String userID, String password) {
		super(name, userID, password);
		this.subjects = new ArrayList<>();	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return this.name;
	}

	
	
	
}
