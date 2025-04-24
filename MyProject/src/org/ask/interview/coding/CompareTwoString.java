package org.ask.interview.coding;

public class CompareTwoString {
    public static void main(String[] args) {
	String s1 = "KAYAK";
	String inputString = "12AK123aaaAYbbbcccKaaak";
	// kayak has to be present in a input string, all the character of the s1 in the
	// sequence
	// it will be invalid if missing, any of the s1 character is missing
	if (isValid(inputString, s1)) {
	    System.out.println("Match with the word ");
	} else {
	    System.out.println("No match has found");

	}
	int count = 0;
	int count1 = 0;
	System.out.println(count++);
	System.out.println(++count1);
	System.out.println(count++);
	System.out.println(++count1);
    }

    public static boolean isValid(String inputString, String s1) {

	int j = 0;
	for (int i = 0; i < inputString.length(); i++) {

	    if (s1.charAt(j) == Character.toUpperCase(inputString.charAt(i))) {
		j++;
	    }

	    if (j == s1.length()) {
		return true;
	    }
	}

	return false;
    }

    public static boolean isValid1(String inputString, String s1) {
	String upperInput = inputString.toUpperCase();
	String upperS1 = s1.toUpperCase();

	final int[] index = { 0 }; // to track position in s1

	return upperInput.chars().anyMatch(c -> {
	    if (index[0] < upperS1.length() && c == upperS1.charAt(index[0])) {
		index[0]++;
	    }
	    return index[0] == upperS1.length(); // stop early if matched fully
	});
    }

}
