package org.test;

public class StringPractice {
	
	public static void main(String[] args) {
		
		System.out.println("isPalidrome(aba) "+isPalidrome("aba"));
		System.out.println("isPalidrome(abc) "+isPalidrome("abc"));
		System.out.println("isPalidrome(c) "+isPalidrome("c"));
		System.out.println("isPalidrome(abac) "+isPalidrome("abac"));
		System.out.println("isPalidrome(abba) "+isPalidrome("abba"));
		
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
