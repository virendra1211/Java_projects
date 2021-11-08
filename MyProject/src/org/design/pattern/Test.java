package org.design.pattern;

public class Test {
	public static void main(String[] args) {
		String str = "aabcccccaaa";
		// a2blc5a3
		// string+occurences
		StringBuilder sb = new StringBuilder();
		char a[] = str.toCharArray();

		int count = 0;
		char temp = 'a';
		for (int i = 0; i < a.length; i++) {
			char c = a[i];
			/// 1 temp assign 'a'
			if (temp == c) {
				count++;
			} else if (temp != c) {
				sb.append(String.valueOf(temp) + count);
				temp = c;
				count = 1;
			} 
			if(i+1 == a.length) {
				sb.append(String.valueOf(temp) + count);
			} 
		}
		System.out.println(sb);
	}
}
