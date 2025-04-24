package org.collections.examples;

public class Main {
	public static void main(String[] args) {
		String str = "columnname = ('1', '2','3')";
		String newString = str.substring(str.indexOf("(")+1, str.length()-1);
		
		String newArray[] = newString.split(",");
		
		
		for (int i = 0; i < 10; i = i++) {
			i += 2;
			System.out.println("Hello World!");
		}
	}

}
