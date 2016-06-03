package entity;

import java.util.ArrayList;

public class Subject {
	private String name;
	private String teacher;
	private ArrayList<Nota> grades;
	private ArrayList<Absenta> abscences;
	
	public Subject(String name, String teacher, ArrayList<Nota> grades, ArrayList<Absenta> abscences) {
		this.name = name;
		this.teacher = teacher;
		this.grades = grades;
		this.abscences = abscences;
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

	public ArrayList<Nota> getGrades() {
		return grades;
	}


	public ArrayList<Absenta> getAbscences() {
		return abscences;
	}

}
