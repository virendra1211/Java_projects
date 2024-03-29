package org.test;

public class StringPractice {
	
	public static void main(String[] args) {
		
		System.out.println("isPalidrome(aba) "+isPalidrome("aba"));
		System.out.println("isPalidrome(abc) "+isPalidrome("abc"));
		System.out.println("isPalidrome(c) "+isPalidrome("c"));
		System.out.println("isPalidrome(abac) "+isPalidrome("abac"));
		System.out.println("isPalidrome(abba) "+isPalidrome("abba"));
		
		System.out.println("==================");
		//System.out.println(decode("raj"));
	}
	public static String decode(String code) {
		String decoded = "";
		int lastCharValue = 'z';
		int alphabetLength = 'z' - 'a' + 1;
		for (char character: code.toCharArray()) {
		    int charNoRotation = character + 5;
		    int charValue = charNoRotation < lastCharValue ? charNoRotation : charNoRotation - alphabetLength;
		    decoded += (char) charValue;
		}
		return decoded;
	}
	public static boolean isPalidrome(String word) {
		int len = word.length();
		int initial=0,end=len-1 ;
		while(end >initial) {

			if(word.charAt(initial) != (word.charAt(end))) {
				return false;
			}
			initial++;end--;
		}
		return true;
	}
}
