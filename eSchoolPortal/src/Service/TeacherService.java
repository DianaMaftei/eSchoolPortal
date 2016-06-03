package Service;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Absence;
import entity.Grade;
import entity.Teacher;
import entity.Student;

public class TeacherService {
	private Scanner userInput = new Scanner(System.in);
	private Teacher currentProfessor = (Teacher) Login.currentUser;
	private ArrayList<Student> yourStudents;

	public TeacherService() {
		this.yourStudents = new ArrayList<Student>();
		for (int i = 0; i < ePortalMain.currentDatabase.getStudentsList().size(); i++) {
			for (int j = 0; j < ePortalMain.currentDatabase.getStudentsList().get(i).getSubjects().size(); j++) {
				if (currentProfessor.getSubject().equalsIgnoreCase(
						ePortalMain.currentDatabase.getStudentsList().get(i).getSubjects().get(j).getName())) {
					yourStudents.add(ePortalMain.currentDatabase.getStudentsList().get(i));
				}
			}
		}
	}

	public void displayAllGrades() {
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

	public void addGrade() {
		displayStudentsCurrentlyEnrolled();
		System.out.println("For which student do you want to add a grade?");
		String studentName = userInput.nextLine();
		for (int i = 0; i < yourStudents.size(); i++) {
			if (studentName.equalsIgnoreCase(yourStudents.get(i).getName())) {
				Student student = yourStudents.get(i);
				System.out.println("What grade do you want to add?");
				int nota = userInput.nextInt();
				int indexDeMaterie = 0;
				for (int j = 0; j < student.getSubjects().size(); j++) {
					if (currentProfessor.getSubject().equalsIgnoreCase(student.getSubjects().get(j).getName())) {
						indexDeMaterie = j;
					}
				}
				// TODO get actual date
				student.getSubjects().get(indexDeMaterie).getGrades().add(new Grade(nota, "today"));
				return;
			}
		}
		System.out.println("The student name is invalid.");

	}

	private void displayAbsences(Student student, int subjectIndex) {
		for (int x = 0; x < student.getSubjects().get(subjectIndex).getAbsences().size(); x++) {
			if (student.getSubjects().get(subjectIndex).getAbsences().get(x).isAbsent()) {
				System.out.printf("%s ", student.getSubjects().get(subjectIndex).getAbsences().get(x));
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

	public void displayAbsencesWithoutLeave() {
		displayStudentsCurrentlyEnrolled();
		System.out.println("For which student do you want to mark an absence \"with leave\"?");
		String studentName = userInput.nextLine();
		for (int i = 0; i < yourStudents.size(); i++) {
			if (studentName.equalsIgnoreCase(yourStudents.get(i).getName())) {
				Student student = yourStudents.get(i);
				int subjectIndex = 0;
				for (int j = 0; j < student.getSubjects().size(); j++) {
					if (currentProfessor.getSubject().equalsIgnoreCase(student.getSubjects().get(j).getName())) {
						subjectIndex = j;
					}
				}
				displayAbsences(student, subjectIndex);
				System.out.println();
				System.out.println("Which absence do you want to mark? ");
				String date = userInput.next();
				Absence absence = new Absence(date);
				student.getSubjects().get(subjectIndex).getAbsences()
						.get(student.getSubjects().get(subjectIndex).getAbsences().indexOf(absence)).setAbsent(false);
				System.out.println("The absence has been marked \"with leave\".");
				displayAbsences(student, subjectIndex);
				return;
			}
		}
		System.out.println("The student name is invalid.");

	}

}
