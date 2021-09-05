package com.revature.app.objectclass;

public class AnotherClass {

	public static void main(String[] args) {
		Person person = new Person("John", 10);
		System.out.println(person.getAge() + "; " + person.getName());
		System.out.println(person);

	}

}
