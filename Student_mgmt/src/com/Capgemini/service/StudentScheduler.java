package com.Capgemini.service;
import com.Capgemini.beans.Student;

public class StudentScheduler {
	
	private Student[] students = new Student[10];
	private int counterStudent;
	
	public String addStudent(int rollNumber,String name, String[] courses)
	{
		students[counterStudent++] = new Student(rollNumber,name,courses);
		return "Student added successfully :)";
	}
	
	public void showCountByCourseName(String course) {
		int countStudent = 0;
		for(int i=0;i<counterStudent;i++) {
			String[] courses = students[i].getCourses();
			for(int j=0; j<courses.length;j++) {
				if(courses[j].equals(course)) {
					countStudent++;
					break;
				}
			}
		}
		System.out.println("Students enrolled in "+course+" are:"+countStudent);
	}
	public void showAllStudents()
	{
		if(counterStudent == 0)
			System.out.println("Sorry! You have not added any student. Please add a student first.");
		else {
			System.out.println("Showing Details Of All Students: ");
			
			for(int i = 0; i<counterStudent; i++) {
				String[] courses = students[i].getCourses();
				System.out.println("\nRoll No.: "+students[i].getRollNumber()+"\nName: "+students[i].getName()+
						"\nKnown Courses: \t");
				for(int j = 0; j<courses.length; j++) {
					System.out.print(courses[j]+"\t");
				}
			}
		}
	}
	
	public void showStudentByRollNumber(int rollNumber)
	{
		int flag = 0;
		for(int i = 0; i<counterStudent; i++) {
			if(students[i].getRollNumber() == rollNumber) {
				String[] courses = students[i].getCourses();
				System.out.println("\nRoll No.: "+students[i].getRollNumber()+"\nName: "+students[i].getName()+
						"\nKnown Courses: \t");
				for(int j = 0; j<courses.length; j++) {
					System.out.print(courses[j]+"\t");
				}
				flag = 1;
				break;
			}
		}
		if(flag==0)
			System.out.println("Sorry, the entered roll number does not exist. Enter an existing roll number.");
	}
	public boolean validateRollNumber(int rollNumber) {
		int flag =0;
		for(int i=0;i<counterStudent;i++) {
			if(students[i].getRollNumber()==rollNumber) {
				flag =1;
				break;
			}
		}
		if(flag == 1)
			return true;
		else 
			return false;
	}
	public void showStudentByCourse(String courseName) {
		int count = 0;
		String courses[];
		for(int i = 0; i<counterStudent; i++) {
			courses = students[i].getCourses();
			for(int j=0;j<courses.length;j++) {
				if(courses[j].equals(courseName)) {
					System.out.println("\nRoll No.: "+students[i].getRollNumber()+"\nName: "+students[i].getName()+
							"\nKnown Courses: \t");
					for(int k = 0; k<courses.length; k++) {
						System.out.print(courses[k]+"\t");
					}
					count++;
					break;
				}
			}
		}
		if(count==0)
			System.out.println("Sorry the entered course is not enrolled by any student.");
	}
}
