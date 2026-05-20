package com.telusko;

import org.springframework.beans.factory.annotation.Autowired;

import java.beans.ConstructorProperties;

public class Alien {
	
	private int age;
	@Autowired
	private Computer comp;


	public Alien() {
		System.out.println("Object Created");
	}
	
	@ConstructorProperties({"age","lap"})
	public Alien(int age,Computer comp) {
		System.out.println("Para Constructor Called");
		this.age = age;
		this.comp = comp;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {    // Setter Injection
		//System.out.println("Setter called");
		this.age = age;
	}
	
	public Computer getComp() {
		return comp;
	}
	
	public void setComp(Computer comp) {
		this.comp = comp;
	}
	
	public void code() {
		System.out.println("Coding");
		//comp.compile();
	}
	
}
