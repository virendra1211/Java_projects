package vk.learning.string;

public class Mastercard_StringConcatTrim {
	public static String testString(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();

		if (a.length() < b.length()) {
			// Trim `b` to match `a.length()` from the beginning or end
			return a + b.substring(0, a.length());
		} else if (b.length() < a.length()) {
			return a.substring(a.length() - b.length()) + b;
		} else {
			return a + b;
		}

	}

	// Test cases
	public static void main(String[] args) {
		System.out.println(testString("Hello", "Hi")); // ? "loHi"
		System.out.println(testString("Hi", "Hello")); // ? "HiHe"
		System.out.println(testString("abc", "xyz")); // ? "abcxyz"
		System.out.println(testString("a", "xyz")); // ? "az"
		System.out.println(testString("java", "")); // ? ""
		System.out.println(testString("", "")); // ? ""
	}
}
