package com.Capgemini.ui;
import java.util.*;
import com.Capgemini.service.*;

public class Admin {
	
	private static Scanner sc=new Scanner(System.in);
	private static StudentScheduler studSch = new StudentScheduler();

	public static void main(String[] args) {
		
		showMenu();
	}
	
	private static void showMenu() {
			
			int choice;
			
			while(true)
			{
				System.out.println("\n1.Add student");
				System.out.println("2.Show all students");
				System.out.println("3.Show student details by roll number");
				System.out.println("4.Show student details by course name");
				System.out.println("5.Show count by course name");
				System.out.println("6.Exit");
				
				System.out.println("Enter your choice: ");
				choice=sc.nextInt();
				
				switch(choice)
				{
					case 1:addStudentDetails();
					       break;
					case 2:showAllStudents();
					        break;
					case 3:showStudentByRollNumber();
							break;
					case 4:showStudentByCourse();
							break;
					case 5:showCountByCourseName();
							break;
					case 6:System.exit(0);
							break;
					default:System.out.println("Sorry entered wrong choice");
				}
			}
		}
	private static void showCountByCourseName() {
		System.out.println("\nEnter the course name for student count:  ");
		String course = sc.next();
		studSch.showCountByCourseName(course);
		
	}
	
	private static void showStudentByRollNumber() {
		System.out.println("\nEnter the roll number for student details: ");
		int rollNumber = sc.nextInt();
		studSch.showStudentByRollNumber(rollNumber);
		
	}
	private static void showStudentByCourse() {
		System.out.println("\nEnter the course for student details: ");
		String courseName = sc.next();
		studSch.showStudentByCourse(courseName);
	}
	
	private static void showAllStudents() {
		studSch.showAllStudents();
		
	}
	
	private static void addStudentDetails() {
		System.out.println("Enter roll number: ");
		int rollNumber=sc.nextInt();
		if(!(studSch.validateRollNumber(rollNumber))) {
		
			System.out.println("Enter name: ");
			String name = sc.next();
			
			System.out.println("Enter how many courses you know? : ");
			int courseCount = sc.nextInt();
			
			String[]  courses = new String[courseCount];
			System.out.println("Enter Courses You Know : ");
			
			for(int i = 0; i<courseCount;i++) {
				courses[i] = sc.next();
			}
			System.out.println(studSch.addStudent(rollNumber, name,courses));
		}
		else {
			System.out.println("Sorry this roll number already exists.. Enter another roll number..");
		}
	}
}
