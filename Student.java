package projects;

import projects.Course;

public class Student{
	
	//data fields
	private int stdID;
	private Course[] courseList;
	
	//get & set methods
	public int getStdID() {
		return stdID;
	}
	public void setStdID(int stdID) {
		this.stdID = stdID;
	}
	
	public Course getCourses(int position) {
		return courseList[position];
	}
	public void setCourses(Course course, int position) {
		this.courseList[position] = course;
	}
	
	//default constructor
	public Student() {
		courseList = new Course[5];
		this.stdID = 00000;
		
		for(int i = 0; i<5; i++) {
			courseList[i] = new Course();
		}
		
	}
	
	/* Name: calcCreditHrs()
	 *		 Input 	: CollegeCourse[]
	 *		 Output : int
	 * 		 Function: calculate the total number of credit hours taken
	 */
	public int calcCreditHrs (Course[] courses) {
		
		int totalCreditHrs = 0;
				
		for(int i = 0; i < courses.length; i++) {
			 totalCreditHrs += courses[i].getCreditHrs();
		}
		
		return totalCreditHrs;
		
	}
	
	/* Name: calcGradePoints()
	 *		 Input 	: CollegeCourse[]
	 *		 Output : int
	 * 		 Function: calculate the total number of points associated with each letter course's letter grade
	 */
	public int calcGradePoints (Course[] courses) {
		
		int totalGradePoints = 0;
		
		for(int i = 0; i < courses.length; i++) {
			
			switch (courses[i].getGrade()) {
				case 'A': 
					totalGradePoints += (4*courses[i].getCreditHrs()); 
					break;
				case 'B': 
					totalGradePoints += (3*courses[i].getCreditHrs()); 
					break;
				case 'C': 
					totalGradePoints += (2*courses[i].getCreditHrs()); 
					break;
				case 'D': 
					totalGradePoints += (1*courses[i].getCreditHrs());
					break;
				default: 
					totalGradePoints += (0*courses[i].getCreditHrs()); 
					break;
			}
			
		}
		
		return totalGradePoints;		
		
	}
	
	/* Name: calcGPA()
	 *		 Input 	: void
	 *		 Output : double
	 * 		 Function: calculate the GPA using the total credit hours and the total grade points earned
	 */	
	public double calcGPA() {
		
		double GPA = calcGradePoints(courseList)/(double)calcCreditHrs(courseList);
		return GPA;
		
	}
	
	/* Name: display()
	 *		 Input 	: void
	 *		 Output : void
	 * 		 Function: display information about the Student object
	 */
	public void display() {
		
		System.out.println("Student ID:   " + getStdID());
		System.out.println("Course List:");
		
		for(int i=0; i<5; i++) {
			
			System.out.println(courseList[i].getCrsId() + "\t" + courseList[i].getCreditHrs() + "  " + courseList[i].getGrade());
		
		}
		
		System.out.printf("GPA: %.2f\n", calcGPA());
		
	}
	
}
