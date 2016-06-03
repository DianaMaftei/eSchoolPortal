package Service;

import java.util.Scanner;

import entity.Subject;
import entity.Student;

public class StudentService {
	private Scanner userInput = new Scanner(System.in);
	private Student currentStudent = (Student) Login.currentUser;

	public void afiseazaOptiuniVizualizare() {
		System.out.println("For which subject do you want to see the grades?");
		System.out.println("For which subject do you want to see the absences?");
		System.out.println("For which subject do you want to see the final grade?");

		System.out.println("These are the classes you are currently enrolled in: ");
		for (Subject m : currentStudent.getSubjects()) {
			System.out.println(m.getName());
		}
		String subject = userInput.next();
		displayGrades(subject);

		displayAbsences(subject);
		displayFinalGrade(subject);

		System.out.println("You are not enrolled in that class.");
	}

	public void displayGrades(String subject) {
		for (int i = 0; i < currentStudent.getSubjects().size(); i++) {
			if (subject.equalsIgnoreCase(currentStudent.getSubjects().get(i).getName())) {
				System.out.printf("%s - ", currentStudent.getSubjects().get(i).getName());
				System.out.printf(" %s \n", currentStudent.getSubjects().get(i).getGrades());
				return;
			}
		}
	}

	public void displayAbsences(String subject) {
		for (int i = 0; i < currentStudent.getSubjects().size(); i++) {
			if (subject.equalsIgnoreCase(currentStudent.getSubjects().get(i).getName())) {
				System.out.printf("%s - ", currentStudent.getSubjects().get(i).getName());
				int totalAbsente = 0;
				for(int j = 0; j < currentStudent.getSubjects().get(i).getAbsences().size(); j++){
					if (currentStudent.getSubjects().get(i).getAbsences().get(j).isAbsent()){
						System.out.printf(" %s ", currentStudent.getSubjects().get(i).getAbsences().get(j));		
						totalAbsente++;
					}
				}
				if(totalAbsente == 0){
					System.out.println("You have no absences! Congratulations!");
					return;
				}
				System.out.println();
				return;
			}
		}
	}

	public void displayFinalGrade(String subject) {
		for (int i = 0; i < currentStudent.getSubjects().size(); i++) {
			if (subject.equalsIgnoreCase(currentStudent.getSubjects().get(i).getName())) {
				double total = 0;
				for(int j = 0; j < currentStudent.getSubjects().get(i).getGrades().size(); j++){
					total += currentStudent.getSubjects().get(i).getGrades().get(j).getPoint();
				}
				total = total / currentStudent.getSubjects().get(i).getGrades().size();
				System.out.printf("Your final grade is: %.2f \n", total);
				return;
			}

		}

	}

	public void displayAllData(){
		
	}
}
