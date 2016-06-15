package service;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Absence;
import entities.Grade;
import entities.Student;
import entities.Teacher;

public class TeacherService {
	private Scanner userInput = new Scanner(System.in);
	private Teacher currentProfessor = (Teacher) Login.currentUser;
	private ArrayList<Student> yourStudents;

	public TeacherService() {
		this.yourStudents = new ArrayList<Student>();
		for (int i = 0; i < ePortalMain.currentDatabase.getStudentsList().size(); i++) {
			for (int j = 0; j < ePortalMain.currentDatabase.getStudentsList().get(i).getCourses().size(); j++) {
				if (currentProfessor.getCourse().equalsIgnoreCase(
						ePortalMain.currentDatabase.getStudentsList().get(i).getCourses().get(j).getName())) {
					yourStudents.add(ePortalMain.currentDatabase.getStudentsList().get(i));
				}
			}
		}
	}

	// TODO finish display all grades - but for currently logged in teacher only
	// - cannot see grades for other subjects
	public void displayGradesForAllStudents() {
		System.out.println("eSchoolPortal");
		for (Student st : ePortalMain.currentDatabase.getStudentsList()) {
			System.out.println(st.getName().toUpperCase());
		}

	}

	private void displayStudentsCurrentlyEnrolled() {
		System.out.println("These are the students enrolled in your class: ");
		for (Student st : yourStudents) {
			System.out.println(st);
		}
	}

	public void addNewGradeToStudent() {
		displayStudentsCurrentlyEnrolled();
		System.out.println("For which student do you want to add a grade?");
		String studentName = userInput.nextLine();
		for (int i = 0; i < yourStudents.size(); i++) {
			if (studentName.equalsIgnoreCase(yourStudents.get(i).getName())) {
				Student student = yourStudents.get(i);
				System.out.println("What grade do you want to add?");
				int nota = userInput.nextInt();
				int indexDeMaterie = 0;
				for (int j = 0; j < student.getCourses().size(); j++) {
					if (currentProfessor.getCourse().equalsIgnoreCase(student.getCourses().get(j).getName())) {
						indexDeMaterie = j;
					}
				}
				// TODO get actual real time date
				student.getCourses().get(indexDeMaterie).getGrades().add(new Grade(nota, "today"));
				return;
			}
		}
		System.out.println("The student name is invalid.");
	}

	//TODO merge this with the one from StudentService
	private void displayStudentAbsences(Student student, int subjectIndex) {
		for (int x = 0; x < student.getCourses().get(subjectIndex).getAbsences().size(); x++) {
			if (student.getCourses().get(subjectIndex).getAbsences().get(x).isAbsent()) {
				System.out.printf("%s ", student.getCourses().get(subjectIndex).getAbsences().get(x));
			}
		}
	}

	public void addNewStudent() {
		System.out.println("Type the new student's name and surname.");
		String studentName = userInput.nextLine();
		System.out.println("Type a userID for the new student.");
		String studentID = userInput.next();
		System.out.println("Assign a default passford for the student.");
		String studentPassword = userInput.next();
		ePortalMain.currentDatabase.getUseri().add(new Student(studentName, studentID, studentPassword));
	}

	public void markAbsenceWithLeave() {
		displayStudentsCurrentlyEnrolled();
		System.out.println("For which student do you want to mark an absence \"with leave\"?");
		//TODO have teacher type number, not full name
		String studentName = userInput.nextLine();
		for (int i = 0; i < yourStudents.size(); i++) {
			if (studentName.equalsIgnoreCase(yourStudents.get(i).getName())) {
				Student student = yourStudents.get(i);
				int subjectIndex = 0;
				for (int j = 0; j < student.getCourses().size(); j++) {
					if (currentProfessor.getCourse().equalsIgnoreCase(student.getCourses().get(j).getName())) {
						subjectIndex = j;
					}
				}
				//TODO see if there are no absences
				displayStudentAbsences(student, subjectIndex);
				System.out.println();
				System.out.println("Which absence do you want to mark? ");
				//TODO have teacher select with number, not write the whole date
				String date = userInput.next();
				Absence absence = new Absence(date);
				student.getCourses().get(subjectIndex).getAbsences()
						.get(student.getCourses().get(subjectIndex).getAbsences().indexOf(absence)).setAbsent(false);
				System.out.println("The absence has been marked \"with leave\".");
				displayStudentAbsences(student, subjectIndex);
				return;
			}
		}
		System.out.println("The student name is invalid.");

	}

}
