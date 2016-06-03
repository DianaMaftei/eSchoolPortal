package entity;

public class Teacher extends User{
	public String subject;

	public Teacher(String name, String userID, String password, String subject) {
		super(name, userID, password);
		this.subject = subject;	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
