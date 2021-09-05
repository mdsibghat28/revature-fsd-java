package com.revature.app.objectclass;

public class ObjectDemo {
	
	@Override
	public String toString() {
		System.out.println("Inside ObjectDemo toString()");
		//return super.toString();
		return "ObjectDemo";
	}

	public static void main(String[] args) {
		ObjectDemo objectDemo = new ObjectDemo();
		System.out.println(objectDemo);
	}

}
