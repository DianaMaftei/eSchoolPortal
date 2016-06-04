package Service;

import java.util.Scanner;

import entity.Course;
import entity.Student;

public class StudentService {
	private Scanner userInput = new Scanner(System.in);
	private Student currentStudent = (Student) Login.currentUser;

	public void afiseazaOptiuniVizualizare() {
		System.out.println("For which course do you want to see the grades?");
		System.out.println("For which course do you want to see the absences?");
		System.out.println("For which course do you want to see the final grade?");

		System.out.println("These are the course you are currently enrolled in: ");
		for (Course m : currentStudent.getCourses()) {
			System.out.println(m.getName());
		}
		String subject = userInput.next();
		displayGrades(subject);

		displayAbsences(subject);
		displayFinalGrade(subject);

		System.out.println("You are not enrolled in that course.");
	}

	public void displayGrades(String course) {
		for (int i = 0; i < currentStudent.getCourses().size(); i++) {
			if (course.equalsIgnoreCase(currentStudent.getCourses().get(i).getName())) {
				System.out.printf("%s - ", currentStudent.getCourses().get(i).getName());
				System.out.printf(" %s \n", currentStudent.getCourses().get(i).getGrades());
				return;
			}
		}
	}

	public void displayAbsences(String course) {
		for (int i = 0; i < currentStudent.getCourses().size(); i++) {
			if (course.equalsIgnoreCase(currentStudent.getCourses().get(i).getName())) {
				System.out.printf("%s - ", currentStudent.getCourses().get(i).getName());
				int totalAbsente = 0;
				for(int j = 0; j < currentStudent.getCourses().get(i).getAbsences().size(); j++){
					if (currentStudent.getCourses().get(i).getAbsences().get(j).isAbsent()){
						System.out.printf(" %s ", currentStudent.getCourses().get(i).getAbsences().get(j));		
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

	public void displayFinalGrade(String course) {
		for (int i = 0; i < currentStudent.getCourses().size(); i++) {
			if (course.equalsIgnoreCase(currentStudent.getCourses().get(i).getName())) {
				double total = 0;
				for(int j = 0; j < currentStudent.getCourses().get(i).getGrades().size(); j++){
					total += currentStudent.getCourses().get(i).getGrades().get(j).getPoint();
				}
				total = total / currentStudent.getCourses().get(i).getGrades().size();
				System.out.printf("Your final grade is: %.2f \n", total);
				return;
			}

		}

	}

	public void displayAllData(){
		
	}
}
