package Service;

import entity.Database;

public class ePortalMain {
	public static Database currentDatabase;
	public static StudentService studentService;
	public static TeacherService profesorService;

	public static void main(String[] args) {
		currentDatabase = new Database();
		Login meniu = new Login();
		meniu.displayLoginMenu();
		meniu.doLogin();
		
		
		studentService = new StudentService();
		studentService.displayGrades("math");
		studentService.displayAbsences("math");
		studentService.displayFinalGrade("math");
		
		studentService.displayGrades("art");
		studentService.displayAbsences("art");
		studentService.displayFinalGrade("art");
		
		profesorService = new TeacherService();
		profesorService.addGrade();
		profesorService.displayAbsencesWithoutLeave();

	}

}
