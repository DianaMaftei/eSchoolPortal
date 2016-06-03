package entity;

import java.util.ArrayList;

public class Subject {
	private String name;
	private String teacher;
	private ArrayList<Grade> grades;
	private ArrayList<Absence> absences;
	
	public Subject(String name, String teacher, ArrayList<Grade> grades, ArrayList<Absence> absences) {
		this.name = name;
		this.teacher = teacher;
		this.grades = grades;
		this.absences = absences;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public ArrayList<Grade> getGrades() {
		return grades;
	}


	public ArrayList<Absence> getAbsences() {
		return absences;
	}

}
