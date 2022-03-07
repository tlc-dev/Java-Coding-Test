package com.aa.act.interview.org;

import java.util.Optional;
import java.util.Random;

public abstract class Organization {

	private Position root;
	public Name person;
	public String title;
	public Optional<Employee> employee;
	
	public Organization() {
		root = createOrganization(); //Creates an organization and assigns it to the root position so sub-positions can be added
	}
	
	protected abstract Position createOrganization();
	/**
	 * hire the given person as an employee in the position that has that title
	 * 
	 * @param person
	 * @param title
	 * @return the newly filled position or empty if no position has that title
	 */
	
	public Optional<Position> hire(Name person, String title) {
		Random rand = new Random();
		Employee testEmp = new Employee(rand.nextInt(10000), person);
		
		//root = new Position(title, testEmp);		
		
		
		Position posit = new Position(title, testEmp);
		
		
		root.setEmployee(Optional.ofNullable(testEmp));
		root.addDirectReport(posit);
		
		if (Optional.of(root).isPresent() == !true) {
			System.out.println("Optional is empty");
			return Optional.empty();
		}
		
		return Optional.ofNullable(root);
		/*TODO: 
		 *
		 * - Doug Parker is not showing as CEO (it's Slick Willie) in the formatted version but is showing up later
		 * - An unformatted version of the company structure is appearing with the correct data, not sure why
		 * - Formatted data is not being populated besides the CEO, why?
		 */
	}

	@Override
	public String toString() {
		return printOrganization(root, ""); //prints a position, empty space
	}
	
	private String printOrganization(Position pos, String prefix) {
		StringBuffer sb = new StringBuffer(prefix + "+-" + pos.toString() + "\n");
		for(Position p : pos.getDirectReports()) {
			sb.append(printOrganization(p, prefix + "\t"));
		}
		return sb.toString();
	}
}
