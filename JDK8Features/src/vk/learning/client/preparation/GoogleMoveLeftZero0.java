package vk.learning.client.preparation;

import java.util.Comparator;
import java.util.stream.Collectors;

public class GoogleMoveLeftZero0 {

	public static void main(String[] args) {
		String str = "1110010101";
		int zeroCount = 0;
		StringBuilder sb = new StringBuilder();
		for (Character c : str.toCharArray()) {
			if (c == '1') {
				sb.append(c);
			} else {
				zeroCount++;
			}
		}
		while (zeroCount-- > 0) {
			sb.append('0');
		}

		System.out.println(sb.toString());
		String result = str.chars().mapToObj(c -> (char) c).sorted(Comparator.reverseOrder())
				.map(String::valueOf).collect(Collectors.joining());

		System.out.println(Integer.valueOf(1).equals(Long.valueOf(1)));
		System.out.println(result);
	}

}
