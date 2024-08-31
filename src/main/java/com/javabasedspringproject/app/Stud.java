package com.javabasedspringproject.app;

public class Stud {
	
	private int id;
	private Computer computer;
	
	public Stud(int id, Computer computer) {
		super();
		this.id = id;
		this.computer = computer;
	}

	public Stud() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
}
