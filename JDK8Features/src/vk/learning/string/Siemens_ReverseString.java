package vk.learning.string;

import java.util.stream.IntStream;

public class Siemens_ReverseString {
	public static void main(String[] args) {
		String str = "mukesh&santosh&dinesh";
		String[] arrayOfString = str.split("&");
		for (int i = 0; i < arrayOfString.length / 2; i++) {
			String temp = arrayOfString[i];
			arrayOfString[i] = arrayOfString[arrayOfString.length - 1 - i];
			arrayOfString[arrayOfString.length - 1 - i] = temp;

		}
		String result = String.join("&", arrayOfString);
		System.out.println(result);

		String str1 = "abcdecba";
		System.out.println(findLastRepeating(str1));
		/*
		 * Input: "abcdecba" Output: 'a'
		 */
		MyInterface myInterface = new MyInterface() {
			public void show() {
				System.out.println("pint interface instance");
			}
		};
		myInterface.show();

		MyInterface obj = () -> System.out.println("rt");
		obj.show();
	}

	public static Character findLastRepeating(String str) {

		IntStream.range(str.length() - 1, 0).forEach(p -> {

		});
		// Traverse from right to left
		for (int i = str.length() - 1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (str.lastIndexOf(ch) != str.indexOf(ch)) {
				return ch; // first repeat encountered from right side
			}
		}

		return null; // no repeating character
	}
}

interface MyInterface {

	void show();
}
