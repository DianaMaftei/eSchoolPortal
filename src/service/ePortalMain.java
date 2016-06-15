package service;

import entities.Database;

public class ePortalMain {
	public static Database currentDatabase;
	public static StudentService studentService;
	public static TeacherService profesorService;

	public static void main(String[] args) {
		currentDatabase = new Database();
		Login meniu = new Login();
		
		//test as student
/*		do {
			meniu.doLogin();
		} while (Login.currentUser == null);

		studentService = new StudentService();
		studentService.displayUserMenu();*/
		
		Login.currentUser = null; //sign student out
		
		//test as teacher
		do {
			meniu.doLogin();
		} while (Login.currentUser == null);

		profesorService = new TeacherService();
		//profesorService.addNewGradeToStudent();
		profesorService.markAbsenceWithLeave();


	}

}
