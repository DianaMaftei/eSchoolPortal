package entity;

public abstract class User {
	protected String name;
	protected String userID;
	protected String password;
	
	public User(String name, String userID, String password) {
		this.name = name;
		this.userID = userID;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getUserID() {
		return userID;
	}
	
	
	
	
}
