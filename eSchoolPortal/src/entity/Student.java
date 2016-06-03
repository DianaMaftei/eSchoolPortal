package entity;

import java.util.ArrayList;

public class Student extends User{
	
	private ArrayList<Subject> materii;

	public Student(String nume, String userName, String parola) {
		super(nume, userName, parola);
		this.materii = new ArrayList<>();
	}

	public ArrayList<Subject> getMaterii() {
		return materii;
	}

	public void setMaterii(ArrayList<Subject> materii) {
		this.materii = materii;
	}

	@Override
	public String toString() {
		return this.nume;
	}

	
	
	
}
