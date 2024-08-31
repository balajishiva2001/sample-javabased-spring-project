package com.javabasedspringproject.app;

public class Student {
	private int id;
	private HelloWorld helloWorld;
	private JavaWorld javaWorld;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, HelloWorld helloWorld,JavaWorld javaWorld) {
		super();
		this.id = id;
		this.helloWorld = helloWorld;
		this.javaWorld = javaWorld;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HelloWorld getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	public JavaWorld getJavaWorld() {
		return javaWorld;
	}

	public void setJavaWorld(JavaWorld javaWorld) {
		this.javaWorld = javaWorld;
	}
	
}
