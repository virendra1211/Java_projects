package vk.learning.string;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ExtractDigitFromStringAndSum {
	public static void main(String[] args) {
		String str = "a1b2c3d9";

		int result = str.chars().mapToObj(c -> (char) c).filter(Character::isDigit)
				.map(Character::getNumericValue).mapToInt(Integer::intValue).sum();
		System.out.println(result);

		List<Integer> list = List.of(1, 2, 3, 4);

		CopyOnWriteArrayList<Integer> otherList = new CopyOnWriteArrayList<>(list);

		List<Integer> result1 = list.stream().map(p -> {
			list.add(9); // UnsupportedOperationException
			return p;
		}).collect(Collectors.toList());

		System.out.println(list);
		System.out.println(result1);
		System.out.println(otherList);
	}
}
