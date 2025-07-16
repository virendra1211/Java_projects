package vk.learning.string;

public class StringCountduplicateCharCount {

	public static void main(String[] args) {
		String str = "abbcdddef";
		strPintCount(str);
	}

	public static void strPintCount(String str) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			char c = str.charAt(i);
			while (i < str.length() - 1 && str.charAt(i + 1) == c) {
				i++;
				count++;
			}
			sb.append(c);
			  if (count > 1) sb.append(count);
			 

		}
		System.out.println(sb.toString());

	}

}
