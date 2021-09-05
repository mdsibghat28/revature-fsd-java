package com.revature.app.inheritance;

public class Parent {

	// Protected 
	//   When Parent class is used in another class, age is private.
	//   When age is used in Child class it can directly access the instance variables of parent.
	protected int age;

	public Parent(int age) {
		System.out.println("Parent constructor");
		this.age = age;
	}
	
	public void instanceMethod() {
		System.out.println("Parent instanceMethod()");
	}
	
	public static void staticMethod() {
		System.out.println("Parent staticMethod()");
	}

}
