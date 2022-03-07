package com.aa.act.interview.org;

public class Name {

	private String first;
	private String last;
	
	public Name(String first, String last) {
		if(first == null)
			throw new IllegalArgumentException("first name cannot be null");
		if(last == null)
			throw new IllegalArgumentException("last name cannot be null");
		this.first = first;
		this.last = last;
	}
	
	public String getFirst() {
		return first;
	}
	
	public String getLast() {
		return last;
	}

	public String convertNameToString() {
		return first + " " + last;
	}
}
