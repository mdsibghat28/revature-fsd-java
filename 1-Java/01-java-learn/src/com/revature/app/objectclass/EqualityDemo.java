package com.revature.app.objectclass;

public class EqualityDemo {
	
	public static void main(String[] args) {
		Person person1 = new Person("John", 15);
		Person person2 = new Person("John", 15);

		//person1 = person2;
		
		System.out.println(person1 == person2);
		
		System.out.println(person1.equals(person2));
		
		/*String name1 = "John";
		String name2 = "John";
		
		System.out.println(name1.equals(name2));*/
	}

}
