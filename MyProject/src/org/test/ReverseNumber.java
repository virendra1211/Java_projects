package org.test;

public class ReverseNumber {
	public static void main(String[] args) {

		int number = 12345;
		int reversenum = 0;
		while (number != 0) {
			int reminder = number % 10;
			reversenum = reversenum * 10 + reminder;
			number = number / 10;
		}
		System.out.println(reversenum);

	}

}
