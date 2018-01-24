package projects;

public class Course {
	
	//data fields
	private String crsId;
	private int creditHrs;
	private char grade;
	
	//get & set methods	
	public String getCrsId() {
		return crsId;
	}
	public void setCrsId(String crsId) {
		this.crsId = crsId;
	}
	public int getCreditHrs() {
		return creditHrs;
	}
	public void setCreditHrs(int creditHrs) {
		this.creditHrs = creditHrs;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	//default constructor
	public Course() {
		
		this.crsId = "";
		this.creditHrs = 0;
		this.grade = 'F';
		
	}
	
	//constructor
	public Course (String crsID, int creditHrs, char grade) {
		
		this.crsId = crsID;
		this.creditHrs = creditHrs;
		this.grade = grade;
		
	}

}