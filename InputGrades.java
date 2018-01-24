package projects;

import projects.Student;
import java.util.Random;
import java.util.Scanner;

public class InputGrades {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//create student array to hold 10 student objects
		Student[] student = new Student[10];
			
		//for loop for data in each student object
		for (int s = 0; s < 10; s++) {
			
			student[s] = new Student();
			
			System.out.println("--------------- Student " + (s+1) + " input data:");
			
			student[s].setStdID(IDgen());
			System.out.println("Student ID is randomly generated as: " + student[s].getStdID());
			
			//for loop for data in each course within a student object
			for (int c = 1; c < 6; c++) {
				
				System.out.print("Enter Course ID " + c + " for Student " + (s+1) + ": ");
				String courseId = input.nextLine();
				
				int creditHours = creditHrsGen();
				System.out.println("Credit Hours is randomly generated as: " + creditHours);
				
				//Verify the professor only uses A, B, C, D, or F for the grade values
				char letterGrade = gradeGen();
				
				if ((letterGrade != 'A') && (letterGrade != 'B') && 
					(letterGrade != 'C') &&	(letterGrade != 'D') &&
					(letterGrade != 'F')) {				
					System.out.println("Error! Invalid Letter Grade Entered.");	
				}
				
				System.out.println("Letter Grade is randomly generated as: " + letterGrade);
					
				//set course information into a new course object
				Course course = new Course(courseId, creditHours, letterGrade);
				//set course object into the course array for the current student
				student[s].setCourses(course, (c-1));	
				
			}
			
		}
		
		input.close();

		System.out.println("--------------- Display Student Array ---------------");
		
		//for loop to go through each student object in the student array and display their info
		for(int s = 0; s < 10; s++) {	
			student[s].display();		
		}
		
		
	}

	/* Name: gradeGen()
	 *		 Input 	: void
	 *		 Output : int
	 * 		 Function: create random grade within normal distribution (mean of 80 & standard deviation of 12)
	 */
	public static char gradeGen() {
		
		int grade;
		char letterGrade = 'N';
		
		Random r = new Random();
		double val = r.nextGaussian()*12 + 80;		//creates a normal distribution
		grade = (int) Math.round(val);
		
		if(grade <= 100 && grade >= 90 ) 
		{
			letterGrade = 'A';
		}
		else if(grade <= 89 && grade >= 80 ) 
		{
			letterGrade = 'B';
		}
		else if(grade <= 79 && grade >= 70 ) 
		{
			letterGrade = 'C';
		}
		else if(grade <= 69 && grade >= 60 ) 
		{
			letterGrade = 'D';
		}
		else
		{
			letterGrade = 'F';
		}

		return letterGrade;
		
	}

	
	/* Name: IDgen()
	 *		 Input 	: void
	 *		 Output : int
	 * 		 Function: create random 5 digit ID number
	 */
	public static int IDgen() {
		
		int ID;
		
		Random r = new Random();
		double val = r.nextDouble()*100000;
		ID = (int) Math.round(val);
			
		return ID;
		
	}
	
	
	/* Name: creditHrsGen()
	 *		 Input 	: void
	 *		 Output : int
	 * 		 Function: randomly picks between 2, 3, and 4 credit hours
	 */
	public static int creditHrsGen() {
		
		int creditHrs;
		
		//Create a random number between 0 and 100.
		Random r = new Random();
		double val = r.nextDouble()*100;
		int pick = (int) Math.round(val);
		
		//Split the range of 0 to 100 evenly into thirds.
		//Depending on where the random number lies, the
		//corresponding credit hours is saved.
		if (pick <= 33) 
		{
			creditHrs = 2;
		}
		else if(pick > 33 && pick <= 66) 
		{
			creditHrs = 3;
		}
		else 
		{
			creditHrs = 4;
		}
		
		return creditHrs;
		
	}
	
	
}
