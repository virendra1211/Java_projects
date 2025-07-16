package vk.learning.netjstechpogram;

public class ReverseString {
	public static void main(String[] args) {
		System.out.println(reverseString("string"));
	}

	private static String reverseString(String string) {

		if (string == null || string.length() <= 1)
			return string;
		StringBuilder sb = new StringBuilder();

		for (int i = string.length() - 1; i >= 0; i--) {
			sb.append(string.charAt(i));
		}
		return sb.toString();
	}
}
