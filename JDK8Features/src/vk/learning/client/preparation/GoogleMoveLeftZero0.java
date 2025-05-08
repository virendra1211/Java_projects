package vk.learning.client.preparation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GoogleMoveLeftZero0 {

	public static void main(String[] args) {
		String str = "1110010101";

		StringBuilder sb = new StringBuilder();
		StringBuilder zeroPadding = new StringBuilder();
		for (Character result : str.toCharArray()) {
			if (result == '1') {
				sb.append(result);
			} else {
				zeroPadding.append(result);
			}
		}

		sb.append(zeroPadding);
		List<Integer> list = Arrays.asList(1, 2, 3, 5);
		IntStream p = Stream.of(1, 2, 3, 4, 5).peek((e) -> System.out.println(e))
				.mapToInt(Integer::intValue).map(g -> g * 2).count();

		System.out.println(p.get);

		System.out.println(sb.toString());

		/* */
		System.out.println(Integer.valueOf(1).equals(Long.valueOf(1)));
	}

}
