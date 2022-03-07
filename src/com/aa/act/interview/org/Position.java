package com.aa.act.interview.org;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Position {

	private String title;
	private Optional<Employee> employee; //a position does not have to have an employee
	private Set<Position> directReports; //Set of positions called directReports
	
	public Position(String title) {
		this.title = title; //construction position title, not a parameter
		employee = Optional.empty(); //initializes an empty Optional employee object
		directReports = new HashSet<Position>(); //creates a new empty HashSet of positions
	}

	public Position(String title, Employee employee) {
		this(title); //parameter, not a constructor
		if(employee != null) //if there is an employee
			setEmployee(Optional.of(employee)); //set the employee (as an optional)
	}
	
	// ---------------------------------------------------------------------------------------------------------
	
	public String getTitle() {
		return title; //title constructor
	}
	
	public void setEmployee(Optional<Employee> employee) {
		this.employee = employee; //sets an employee provided by the parameter to the declared position
	}
	
	public Optional<Employee> getEmployee() {
		return employee;
	}
	
	//---------------------------------------------------------------------------------------------------------
	
	//Detects if an employee object contains any values
	public boolean isFilled() {
		return employee.isPresent();
	}
	
	//Adds a direct report to an already exisiting condition, throws exception if there is no position
	public boolean addDirectReport(Position position) {
		if(position == null)
			throw new IllegalArgumentException("position cannot be null");
		return directReports.add(position);
	}
	
	//Removes a position specified by the parameter, returns a boolean value
	public boolean removePosition(Position position) {
		return directReports.remove(position);
	}
	
	//Gets an unmodifiable view of all the directReports
	public Collection<Position> getDirectReports() {
		return Collections.unmodifiableCollection(directReports);
	}

	@Override //returns a string comprised of the title and a map of employees, or prints a blank space if there is no value
	public String toString() {
		return title + employee.map(e -> ": " + e.getName().convertNameToString()).orElse("");
	}
}
