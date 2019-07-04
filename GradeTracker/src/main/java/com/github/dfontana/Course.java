package com.github.dfontana;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;

public class Course {
	
	private final String courseName;
	private final String instructorName;
	private final String year;
	private final String term;
	private Double grade;
	private DefaultListModel listModel; //Stores category objects. Might not need array list in this case....
	
	public Course(String passedCourse, String passedInstructor, String passedYear, String passedTerm){
		courseName = passedCourse;
		instructorName = passedInstructor;
		year = passedYear;
		term = passedTerm;
		listModel = new DefaultListModel();
		grade = 0.0;
	}
	
	/**
	 * @return grade for course
	 */
	public Double computeGrade(){
		double total = 0;
		for(int i=0; i < listModel.getSize(); i++){
			total += ((Category) listModel.getElementAt(i)).weightedGrade();
		}
		grade = total;
		return grade;
	}
	
	public void addCategory(Category category){
		listModel.addElement(category);
	}

	public void deleteCategory(Category category, int index) {
		listModel.remove(index);
	}
	
	public boolean isWithin(String name) {
		boolean isWithin = false;
		for(int i=0; i < listModel.getSize(); i++){
			Category o = (Category) listModel.getElementAt(i);  
			if(o.toString().equals(name)){
				isWithin = true;
				break;
			}
		}
		return isWithin;
	}
	
	/**
	 * Checks if all a category can be added based on the weight it has.
	 * Weights cannot exceed a sum of 1.
	 * @param weight
	 * @return true if overweight
	 */
	public boolean isTotalWeight(Double weight) {
		Double total = 0.0;
		for(int i=0; i < listModel.getSize(); i++){
			Category o = (Category) listModel.getElementAt(i); 
			total += o.getWeight();
		}
		if(total+weight > 1.0){
			return true;
		}
		return false;
	}

	/*********************************************
	 * GETTERS AND IDENTIFIERS
	 *********************************************/
	public DefaultListModel getCategoryModel(){
		return listModel;
	}

	public String toString() {
        return courseName;
    }
	
	public String getInstructor(){
		return instructorName;
	}
	
	public String getYear(){
		return year;
	}
	
	public String getTerm(){
		return term;
	}
}
