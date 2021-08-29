package org.test;

public class Stringtest {

	static String reverString="";

	public static void main(String[] args) {
/*
		for (int i = 1; i < 50; i++) {
			if (i % 10 == 0) {
				System.out.println(i + " ");
			} else {
				System.out.print(i + " ");
			}
		} */
		reverString("ABCD");
	}

	public static void reverString(String str) {
		if (!str.isEmpty()) {
			reverString = reverString + str.charAt(str.length() - 1);
			reverString(str.substring(0, str.length() - 1));

		} else {
			System.out.println(reverString);
		}

	}
}
