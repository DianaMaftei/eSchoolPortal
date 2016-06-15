package entities;

public class Absence {

	private String date;
	private boolean absent;
	
	public Absence(String date) {
		this.date = date;
		this.absent = true;
	}

	public String getDate() {
		return date;
	}

	public boolean isAbsent() {
		return absent;
	}

	public void setAbsent(boolean absent) {
		this.absent = absent;
	}
	
	
	public String toString(){
		return date;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return date.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if((obj instanceof Absence) && date.equals(((Absence)obj).getDate())){
			return true;
		}
		return false;
	}


	
	
	
}
