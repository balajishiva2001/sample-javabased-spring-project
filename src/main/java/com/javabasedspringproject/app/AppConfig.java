package com.javabasedspringproject.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.javabasedspringproject.app")
public class AppConfig {
	
	@Bean(name = "helloWorld")
	@Scope(scopeName = "singleton")
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
	
	@Bean(name = "javaWorld")
	@Scope(scopeName = "prototype")
	public JavaWorld javaWorld() {
		return new JavaWorld();
	}
	
	@Bean(name = "student")
	public Student student(@Autowired HelloWorld helloWorld, @Autowired JavaWorld javaWorld) {
		Student student = new Student();
		student.setId(11);
		student.setJavaWorld(javaWorld);
		student.setHelloWorld(helloWorld);
		return student;
	}
	
	@Bean(name = "student1")
	public Student student1(@Autowired HelloWorld helloWorld, @Autowired JavaWorld javaWorld) {
		return new Student(22, helloWorld, javaWorld);
	}
	
	@Bean(name = "car")
	@Qualifier(value = "car")
	public Car car() {
		return new Car();
	}
	
	@Bean(name = "bike")
	@Qualifier(value = "bike")
	public Bike bike() {
		return new Bike();
	}
	
	@Bean(name = "wheeler")
	public Wheeler wheeler(@Qualifier("bike") Vehicle vehicle) {
		return new Wheeler(33,vehicle);
	}
	
	@Bean(name = "laptop")
	@Primary
	public Laptop laptop() {
		return new Laptop();
	}
	
	@Bean(name = "desktop")
	public Desktop desktop() {
		return new Desktop();
	}
	
	@Bean(name = "stud")
	public Stud stud(Computer computer) {
		return new Stud(44,computer);
	}
	
	@Bean
	@Lazy(value = true)
	public Workday workday() {
		return new Workday();
	}
	
	@Bean
	public Holiday holiday() {
		return new Holiday();
	}
}
