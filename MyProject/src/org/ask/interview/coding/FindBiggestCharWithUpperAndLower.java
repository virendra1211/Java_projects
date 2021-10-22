package org.ask.interview.coding;
public class FindBiggestCharWithUpperAndLower {

	public static void main(String[] args) {
		char ch = findBiggestCharWithUpperAndLower("SachinNinaRanewWyY");
		System.out.println(ch);

	}

	private static char findBiggestCharWithUpperAndLower(String input) {
		
		boolean[] upper = new boolean[26];
		boolean[] lower = new boolean[26];
		char ch = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (Character.isUpperCase(input.charAt(i))) {
				upper[input.charAt(i) - ('A')] = true;
				
			} else if (Character.isLowerCase(input.charAt(i))) {
				lower[input.charAt(i) - ('a')] = true;
			}
		}
		
		for (int i = 25; i >= 0; i--) {
			System.out.println("i>>"+i);
			if (upper[i] && lower[i]) {
				ch =  (char) ('A'+ (i));
				break;
			}
		}
		return ch;
	}

}
