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

		ArrayList<Subject> materiiDiana = new ArrayList<Subject>();

		materiiDiana.add(new Subject("MATH", "Stefanescu Liviu", new ArrayList<>(), new ArrayList<>()));
		materiiDiana.add(new Subject("P.E", "Vasiliu Cornel", new ArrayList<>(), new ArrayList<>()));
		materiiDiana.add(new Subject("ART", "Popescu Irina", new ArrayList<>(), new ArrayList<>()));

		diana.setSubjects(materiiDiana);

		ArrayList<Subject> materiiAnca = new ArrayList<Subject>();
		
		materiiAnca.add(new Subject("ROMANIAN", "Spiridon Elena", new ArrayList<>(), new ArrayList<>()));
		materiiAnca.add(new Subject("ENGLISH", "Buciu Raluca", new ArrayList<>(), new ArrayList<>()));
		materiiAnca.add(new Subject("ART", "Popescu Dragos", new ArrayList<>(), new ArrayList<>()));
		materiiAnca.add(new Subject("HISTORY", "Tanasescu Virginia", new ArrayList<>(), new ArrayList<>()));
		
		anca.setSubjects(materiiAnca);

		diana.getSubjects().get(0).getAbsences().add(new Absence("1/06"));
		diana.getSubjects().get(0).getAbsences().add(new Absence("8/06"));
		diana.getSubjects().get(0).getAbsences().add(new Absence("10/06"));
		diana.getSubjects().get(0).getAbsences().get(2).setAbsent(false);
		diana.getSubjects().get(0).getGrades().add(new Grade(5, "25/05"));
		diana.getSubjects().get(0).getGrades().add(new Grade(8, "2/06"));
		
		diana.getSubjects().get(1).getAbsences().add(new Absence("1/06"));
		diana.getSubjects().get(1).getGrades().add(new Grade(9, "10/05"));
		diana.getSubjects().get(1).getGrades().add(new Grade(8, "5/02"));
		
		diana.getSubjects().get(2).getGrades().add(new Grade(10, "25/05"));
		diana.getSubjects().get(2).getGrades().add(new Grade(8, "16/04"));
		diana.getSubjects().get(2).getGrades().add(new Grade(10, "10/05"));
		diana.getSubjects().get(2).getGrades().add(new Grade(9, "1/06"));
		
		anca.getSubjects().get(0).getAbsences().add(new Absence("1/06"));
		anca.getSubjects().get(0).getGrades().add(new Grade(10, "22/05"));
		anca.getSubjects().get(0).getGrades().add(new Grade(10, "2/06"));
		
		anca.getSubjects().get(1).getAbsences().add(new Absence("7/05"));
		anca.getSubjects().get(1).getGrades().add(new Grade(9, "5/03"));
		anca.getSubjects().get(1).getGrades().add(new Grade(10, "30/04"));
		
		anca.getSubjects().get(2).getAbsences().add(new Absence("1/06"));
		anca.getSubjects().get(2).getAbsences().add(new Absence("5/05"));
		anca.getSubjects().get(2).getGrades().add(new Grade(6, "21/03"));
				
		anca.getSubjects().get(3).getGrades().add(new Grade(10, "4/03"));
		anca.getSubjects().get(3).getGrades().add(new Grade(10, "19/04"));
		anca.getSubjects().get(3).getGrades().add(new Grade(10, "27/05"));
		
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
