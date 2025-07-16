package vk.learning.netjstechpogram;

import java.util.Arrays;

public class ArrayWithColumnRemoveBlankAndNull {
	public static void main(String[] args) {

		String[] array = { "name : abc", "email: test@abc.com", "id: 1", " : ", "foo: ", " :bar",
				null };

		Arrays.stream(array).filter(p -> {
			if (extracted(p))
				return true;
			return false;
		}).forEach(System.out::println);

	}

	private static boolean extracted(String p) {
		return p != null && (p.split(":")[0].trim() != null && p.split(":")[0].trim() != "");
	}
}
