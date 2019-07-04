package com.github.dfontana;

public class Assignment {
	private final String name;
	private final Double earned;
	private final Double total;
	
	Assignment(String passedName, Double passedEarned, Double passedTotal){
		name = passedName;
		earned = passedEarned;
		total = passedTotal;
	}
	
	/**
	 * Returns the name of the assignment when the object wants to be
	 * identified as a string. Main use in for JList.
	 */
	public String toString() {
        return name;
    }

	/***
	 * Computes the decimal value of grade.
	 * @return computed grade in decimal form
	 */
	public Double computeGrade() {
		return earned/total;
	}
}
