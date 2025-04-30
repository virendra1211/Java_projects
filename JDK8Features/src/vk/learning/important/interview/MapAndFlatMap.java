package vk.learning.important.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMap {
    public static void main(String[] args) {
	map();
	flatMap();

	int x = 5;
	System.out.println(x++);
	System.out.println(x++);
	System.out.println(++x);
	System.out.println(++x);

    }

    static void map() {
	List<String> list = List.of("abcd", "abd", "dabcd", "ggabcd", "hhhabcd", "werewabcd");

	List<Integer> l = list.stream().map(p -> p.length()).collect(Collectors.toList());
	l.forEach(System.out::println);
    }

    static void flatMap() {
	List<String> list = List.of("a", "b", "c");
	List<String> list1 = List.of("a1", "b1", "c1");
	List<String> list2 = List.of("a2", "b2", "c2");
	String s[][] = { { "3", "2" }, { "33", "22" } };

	List<List<String>> listOfLetters = Arrays.asList(list, list1, list2);

	List<String> flatList = listOfLetters.stream().flatMap(List::stream).collect(Collectors.toList());
	System.out.println(flatList);

    }

}
