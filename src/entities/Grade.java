package entities;

public class Grade {
	private int point;
	private String date;
	
	public Grade(int point, String date) {
		this.point = point;
		this.date = date;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public String getDate() {
		return date;
	}

	public String toString(){
		return "" + date + ": " + point;
	}
}
