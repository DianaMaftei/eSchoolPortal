package entity;

import java.util.ArrayList;

import Service.ePortalMain;

public class Database {

	private ArrayList<User> useri;

	public Database() {

		useri = new ArrayList<>();

		initDatabase();

	}

	public ArrayList<User> getUseri() {
		return useri;
	}

	public void initDatabase() {
		Student diana = new Student("Maftei Diana", "dianaM", "0000");
		useri.add(diana);
		Student anca = new Student("Stefanescu Anca", "ancaS", "0000");
		useri.add(anca);
		Teacher dorian = new Teacher("Pavus Dorian", "dodo", "1111", "ART");
		useri.add(dorian);

		ArrayList<Course> materiiDiana = new ArrayList<Course>();

		materiiDiana.add(new Course("MATH", "Stefanescu Liviu", new ArrayList<>(), new ArrayList<>()));
		materiiDiana.add(new Course("P.E", "Vasiliu Cornel", new ArrayList<>(), new ArrayList<>()));
		materiiDiana.add(new Course("ART", "Popescu Irina", new ArrayList<>(), new ArrayList<>()));

		diana.setCourses(materiiDiana);

		ArrayList<Course> materiiAnca = new ArrayList<Course>();
		
		materiiAnca.add(new Course("ROMANIAN", "Spiridon Elena", new ArrayList<>(), new ArrayList<>()));
		materiiAnca.add(new Course("ENGLISH", "Buciu Raluca", new ArrayList<>(), new ArrayList<>()));
		materiiAnca.add(new Course("ART", "Popescu Dragos", new ArrayList<>(), new ArrayList<>()));
		materiiAnca.add(new Course("HISTORY", "Tanasescu Virginia", new ArrayList<>(), new ArrayList<>()));
		
		anca.setCourses(materiiAnca);

		diana.getCourses().get(0).getAbsences().add(new Absence("1/06"));
		diana.getCourses().get(0).getAbsences().add(new Absence("8/06"));
		diana.getCourses().get(0).getAbsences().add(new Absence("10/06"));
		diana.getCourses().get(0).getAbsences().get(2).setAbsent(false);
		diana.getCourses().get(0).getGrades().add(new Grade(5, "25/05"));
		diana.getCourses().get(0).getGrades().add(new Grade(8, "2/06"));
		
		diana.getCourses().get(1).getAbsences().add(new Absence("1/06"));
		diana.getCourses().get(1).getGrades().add(new Grade(9, "10/05"));
		diana.getCourses().get(1).getGrades().add(new Grade(8, "5/02"));
		
		diana.getCourses().get(2).getGrades().add(new Grade(10, "25/05"));
		diana.getCourses().get(2).getGrades().add(new Grade(8, "16/04"));
		diana.getCourses().get(2).getGrades().add(new Grade(10, "10/05"));
		diana.getCourses().get(2).getGrades().add(new Grade(9, "1/06"));
		
		anca.getCourses().get(0).getAbsences().add(new Absence("1/06"));
		anca.getCourses().get(0).getGrades().add(new Grade(10, "22/05"));
		anca.getCourses().get(0).getGrades().add(new Grade(10, "2/06"));
		
		anca.getCourses().get(1).getAbsences().add(new Absence("7/05"));
		anca.getCourses().get(1).getGrades().add(new Grade(9, "5/03"));
		anca.getCourses().get(1).getGrades().add(new Grade(10, "30/04"));
		
		anca.getCourses().get(2).getAbsences().add(new Absence("1/06"));
		anca.getCourses().get(2).getAbsences().add(new Absence("5/05"));
		anca.getCourses().get(2).getGrades().add(new Grade(6, "21/03"));
				
		anca.getCourses().get(3).getGrades().add(new Grade(10, "4/03"));
		anca.getCourses().get(3).getGrades().add(new Grade(10, "19/04"));
		anca.getCourses().get(3).getGrades().add(new Grade(10, "27/05"));
		
	}

	public ArrayList<Student> getStudentsList(){
		ArrayList<Student> listaStudenti = new ArrayList<Student>();
		for(int i = 0; i < ePortalMain.currentDatabase.getUseri().size(); i++){
			if(ePortalMain.currentDatabase.getUseri().get(i) instanceof Student){
				listaStudenti.add((Student) ePortalMain.currentDatabase.getUseri().get(i));
			}
		}
		return listaStudenti;
	}
}
