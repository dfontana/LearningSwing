package com.github.dfontana;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class Category {
	private final String name;
	private final Double weight;
	private Double grade;
	private int totalAssignments;
	private DefaultListModel listModel;
	
	public Category(String passedName, Double passedWeight){
		name = passedName;
		weight = passedWeight;
		listModel = new DefaultListModel();
		grade = 0.0;
		totalAssignments = listModel.getSize();
	}

	/**
	 * Adds the given assignment to the hashMap and listModel
	 * @param assignment
	 */
	public void addAssignment(Assignment assignment) {
		listModel.addElement(assignment);
	}

	/**
	 * Removes the given assignment and index from the hashmap and listModel 
	 * respectively
	 * @param assignment
	 * @param index
	 */
	public void deleteAssignment(Assignment assignment, int index) {
		Assignment removedAssignment = (Assignment) listModel.remove(index);
	}
	
	/**
	 * Overloaded function - returns grade if no parameters are specified
	 * @return current unweighted grade associated with the category
	 */
	public Double computeGrade(){
		double total = 0;
		int i;
		for(i = 0; i < listModel.getSize(); i++){
			total += ((Assignment) listModel.getElementAt(i)).computeGrade();
		}
		if(i == 0){ grade = 0.0;}
		else{
			grade = total / i;
		}
		return grade;
	}
	
	/**
	 * Returns the weighted grade of the category
	 * @return weighted grade
	 */
	public Double weightedGrade(){
		this.computeGrade();
		return grade * weight;
	}
	
	/**
	 * Determines if the string passed in exists within the listModel. The passed string
	 * should be the name of an assignment to be checked for.
	 * @param name of Assignment
	 * @return true if it exists already
	 */
	public boolean isWithin(String name) {
		boolean isWithin = false;
		for(int i=0; i < listModel.getSize(); i++){
			Assignment o = (Assignment) listModel.getElementAt(i);  
			if(o.toString().equals(name)){
				isWithin = true;
				break;
			}
		}
		return isWithin;
	}

	/*********************************************
	 * GETTERS AND IDENTIFIERS
	 *********************************************/
	
	public DefaultListModel getAssignmentModel() {
		return listModel;
	}
	
	public String toString() {
        return name + " - "+ (weight*100) + "%";
    }
	
	public Double getWeight(){
		return weight;
	}
}
