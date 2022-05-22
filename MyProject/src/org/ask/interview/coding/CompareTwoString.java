package org.ask.interview.coding;

public class CompareTwoString {
	public static void main(String[] args) {
		String s1 = "KAYAK";
		String inputString = "12AK123aaaYbbbAcccKaaak";
		// kayak has to be present in a input string, all the character of the s1 in the sequence
		// it will be invalid if missing, any of the s1 character is missing
		if(isValid(inputString,s1)){
			System.out.println("Match with the word ");
		}else {
			System.out.println("No match has found");

		}
	int count=0;
	int count1 =0;
	System.out.println(count++);
	System.out.println(++count1);
	System.out.println(count++);
	System.out.println(++count1); 
	}
	public static boolean isValid(String s1, String s2) {
		
		int j=0;
		for(int i=0;i<s1.length();i++) {
			
			if(s2.charAt(j) == Character.toUpperCase(s1.charAt(i))) {
				j++;
			}
			
			if(j == s2.length()) {
				return true;
			}
		}
		
		
		return false;
	}
	
	
}
