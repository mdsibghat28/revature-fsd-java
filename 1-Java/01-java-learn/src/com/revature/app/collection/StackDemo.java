package com.revature.app.collection;

import java.util.Vector;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		Person person1 = new Person("John", 15);
		Person person2 = new Person("Smith", 25);
		Person person3 = new Person("Stella", 32);
		Person person4 = new Person("Maria", 42);
		Person person5 = new Person("Maria", 42);
		Person person6 = new Person("Mark", 13);
		Person person7 = new Person("Abhishek", 25);
		
		// Retain the insertion order
		// Duplicate items are allowed
		Stack<Person> personStack = new Stack<>();
		personStack.push(person1);
		personStack.push(person2);
		personStack.push(person3);
		personStack.push(person4);
		personStack.push(person5);
		personStack.push(person6);
		personStack.push(person7);
		
		System.out.println("Search: " + personStack.search(new Person("Abhishek", 25)));
		
		for (Person person : personStack) {
			System.out.println(person);
		}
		
		Person person = personStack.pop();
		System.out.println("Pop: " + person);
		
		for (Person person11 : personStack) {
			System.out.println(person11);
		}
		
		
	}

}
