package com.user;

public class Solution {
	public static void main(String[] args) {
		String s1 = "KAYAK";
		String inputString = "12AK123aaaYbbbAcccKaaak";
		// kayak has to be present in a input string, all the character of the s1 in the sequence
		// it will be invalid if missing, any of the s1 character is missing
		if(s1.equals(isValid(inputString,s1))){
			
		}
	
	}
	// SKAYAK
	static String ans ="";
	public static String isValid(String inputString, String s1) {
		boolean flag= false;
		char sequence = s1.charAt(0);
		
		for(int i=0;i<inputString.length();i++) {
			char ch = inputString.charAt(i);
			if(sequence == ch) {
				flag = true;
			}else {
				if(String.valueOf(sequence).equals(String.valueOf(ch).toUpperCase())) {
					flag = false;
				}
			}
		}
		// I cheaking by sequence
		if(!flag) { return "";}
		else {ans = ans + sequence;}
		
		// II checking with other sequence
		isValid(inputString,s1.substring(sequence));
		return null;
	}
	
	
}
