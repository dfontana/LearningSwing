package com.github.dfontana;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;

public class CourseManager {

	private DefaultListModel listModel; // Tracks Courses
	private Double gpa;
	
	public CourseManager(){
		listModel = new DefaultListModel();
		try {
			readFromFile();
		} catch (IOException e) {
			//File does not have to exist, so we will
			//ignore the exception for now. May need 
			//to be addressed later after testing
		}
	}
	
	public void addCourse(Course newCourse) {
		listModel.addElement(newCourse);
	}
	
	public void deleteCourse(int index){
		listModel.remove(index);
	}
	
	public void writeToFile() throws IOException{
		System.out.println("Writing!");
		File outfile = new File("courseData.txt");
		FileWriter writer = new FileWriter(outfile);
	
		/**
		 * FORMAT PLANNING:
		 * @*
		 * courseName
		 * instructorName
		 * year
		 * term
		 * @**
		 * categoryName
		 * categoryWeight
		 * @***
		 * assignmentName
		 * assignmentEarned
		 * assignmentTotal
		 * @***
		 * assignmentName
		 * assignmentEarned
		 * assignmentTotal
		 * ... (repeat until all assignments written
		 * @**
		 * categoryName
		 * categoryWeight
		 * @***
		 * assignmentName
		 * assignmentEarned
		 * assignmentTotal
		 * ... (repeat until all assignments written
		 */
		
		/*
		 * PseudoCode:
		 * for each COURSE in LISTMODEL
		 * 	write(@*\n+courseName+\n+instructorName+\n...)
		 * 	for each CATEGORY in LISTMODEL
		 * 	 write(@**\n+name+\n+weight+\n)
		 * 	 for each ASSIGNMENT in LISTMODEL
		 *    write(@***+name+\n+earned+\n+total+\n)
		 *    
		 */
		//writer.write(arg0);
		
		
		writer.close();
	}
	
	public void readFromFile() throws IOException{
		FileReader in = null;
		 try {
	         in = new FileReader("courseData.txt");
	         //MIGHT NEED TO DO BUFFERREADER INSTEAD
	     }finally {
	         if (in != null) {
	            in.close();
	         }
	      }
	}
	
	public Double computeGpa(){
		//TODO: Update gpa 
		return gpa;
	}
	
	public boolean isWithin(String name) {
		boolean isWithin = false;
		for(int i=0; i < listModel.getSize(); i++){
			Course o = (Course) listModel.getElementAt(i);  
			if(o.toString().equals(name)){
				isWithin = true;
				break;
			}
		}
		return isWithin;
	}
	
	public int getSize(){
		return listModel.getSize();
	}
	
	public Course getElementAt(int index){
		return (Course)listModel.getElementAt(index);
	}
	
	public DefaultListModel getModel(){
		return listModel;
	}
}
