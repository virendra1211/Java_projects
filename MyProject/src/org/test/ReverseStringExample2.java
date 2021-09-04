package org.test;

class ReverseStringExample2 {
//recursive function to reverse a string  
	String reverseString ="";
	void reverseString(String string) {
		if(string ==null || string.length() == 0) {
			System.out.println(reverseString);
		}else {
			reverseString = reverseString + string.charAt(string.length()-1);
			reverseString(string.substring(0, string.length() -1));
		}
		
	}

	public static void main(String[] args) {
//string to be reversed  
		String str = "The purpose of our lives is to be happy.";
		System.out.println(str.substring(str.length()-1));
		ReverseStringExample2 rs = new ReverseStringExample2();
//invoking the recursive function and passing the string to be reversed   
		rs.reverseString(str);
	}
}