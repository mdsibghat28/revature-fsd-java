package com.revature.app.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.revature.app.collection.Person;

public class LambdaDemo {
	
	// Functional Interface should have a Single Abstract Method (SAM)

	public static void main(String[] args) {
		// Lambda Expression are shorter for function
		// (parameter) -> (function-body)
		// Passing function itself as a parameter.
		// Lambda Expression introduced in JDK 8.
		CustomFunctionalInterface<Object> customInterface = (name1, name2) -> System.out.println(name1);
		customInterface.accept("Hello",  " World");
		
		Person person1 = new Person(1, "John", 15);
		Person person2 = new Person(2, "Smith", 25);
		Person person3 = new Person(3, "Stella", 32);
		Person person4 = new Person(4, "Maria", 42);
		Person person5 = new Person(5, "Janet", 42);
		
		List<Person> personList = new ArrayList<>();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		personList.add(person5);
		
		for (Person person : personList) {
			System.out.println(person);
		}
		
		System.out.println("Printing using forEach()");
		//Consumer<Object> consumer = e -> System.out.println(e);
		personList.forEach(e -> System.out.println(e));
		
		System.out.println("\nMethod Reference");
		personList.forEach(System.out::println);
	}
	
	public void print(String name) {
		System.out.println(name);
	}

}
