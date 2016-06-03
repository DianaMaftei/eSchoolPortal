package entity;

import java.util.ArrayList;

import Service.eCatalogMain;

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
		Profesor dorian = new Profesor("Pavus Dorian", "dodo", "1111", "DESEN");
		useri.add(dorian);

		ArrayList<Subject> materiiDiana = new ArrayList<Subject>();

		materiiDiana.add(new Subject("MATE", "Stefanescu Liviu", new ArrayList<>(), new ArrayList<>()));
		materiiDiana.add(new Subject("SPORT", "Vasiliu Cornel", new ArrayList<>(), new ArrayList<>()));
		materiiDiana.add(new Subject("DESEN", "Popescu Irina", new ArrayList<>(), new ArrayList<>()));

		diana.setMaterii(materiiDiana);

		ArrayList<Subject> materiiAnca = new ArrayList<Subject>();
		
		materiiAnca.add(new Subject("ROMANA", "Spiridon Elena", new ArrayList<>(), new ArrayList<>()));
		materiiAnca.add(new Subject("ENGLEZA", "Buciu Raluca", new ArrayList<>(), new ArrayList<>()));
		materiiAnca.add(new Subject("DESEN", "Popescu Dragos", new ArrayList<>(), new ArrayList<>()));
		materiiAnca.add(new Subject("ISTORIE", "Tanasescu Virginia", new ArrayList<>(), new ArrayList<>()));
		
		anca.setMaterii(materiiAnca);

		diana.getMaterii().get(0).getAbscences().add(new Absenta("1/06"));
		diana.getMaterii().get(0).getAbscences().add(new Absenta("8/06"));
		diana.getMaterii().get(0).getAbscences().add(new Absenta("10/06"));
		diana.getMaterii().get(0).getAbscences().get(2).setAbsent(false);
		diana.getMaterii().get(0).getGrades().add(new Nota(5, "25/05"));
		diana.getMaterii().get(0).getGrades().add(new Nota(8, "2/06"));
		
		diana.getMaterii().get(1).getAbscences().add(new Absenta("1/06"));
		diana.getMaterii().get(1).getGrades().add(new Nota(9, "10/05"));
		diana.getMaterii().get(1).getGrades().add(new Nota(8, "5/02"));
		
		diana.getMaterii().get(2).getGrades().add(new Nota(10, "25/05"));
		diana.getMaterii().get(2).getGrades().add(new Nota(8, "16/04"));
		diana.getMaterii().get(2).getGrades().add(new Nota(10, "10/05"));
		diana.getMaterii().get(2).getGrades().add(new Nota(9, "1/06"));
		
		anca.getMaterii().get(0).getAbscences().add(new Absenta("1/06"));
		anca.getMaterii().get(0).getGrades().add(new Nota(10, "22/05"));
		anca.getMaterii().get(0).getGrades().add(new Nota(10, "2/06"));
		
		anca.getMaterii().get(1).getAbscences().add(new Absenta("7/05"));
		anca.getMaterii().get(1).getGrades().add(new Nota(9, "5/03"));
		anca.getMaterii().get(1).getGrades().add(new Nota(10, "30/04"));
		
		anca.getMaterii().get(2).getAbscences().add(new Absenta("1/06"));
		anca.getMaterii().get(2).getAbscences().add(new Absenta("5/05"));
		anca.getMaterii().get(2).getGrades().add(new Nota(6, "21/03"));
				
		anca.getMaterii().get(3).getGrades().add(new Nota(10, "4/03"));
		anca.getMaterii().get(3).getGrades().add(new Nota(10, "19/04"));
		anca.getMaterii().get(3).getGrades().add(new Nota(10, "27/05"));
		
	}

	public ArrayList<Student> getStudentsList(){
		ArrayList<Student> listaStudenti = new ArrayList<Student>();
		for(int i = 0; i < eCatalogMain.currentDatabase.getUseri().size(); i++){
			if(eCatalogMain.currentDatabase.getUseri().get(i) instanceof Student){
				listaStudenti.add((Student) eCatalogMain.currentDatabase.getUseri().get(i));
			}
		}
		return listaStudenti;
	}
}
