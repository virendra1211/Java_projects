package org.ask.interview.coding;

public class FirstNonRepeativeCharacter {
    public static void main(String args[]) {
	String inputStr = "teeter";
	// inputStr = "stress";
	inputStr = "STreEs";
//		inputStr = inputStr.toUpperCase();
	for (char i : inputStr.toCharArray()) {
	    if (inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
		System.out.println("First non-repeating character is: " + i);

		String.valueOf(i);
		break;
	    }
	}
	int result = add(10, 20);
	System.out.println(result);
    }

    static int add(int a, int b) {
	return a + b;
    }

    float add(long a, long b) {
	return (float) 50;
    }

}
