package vk.learning.basics;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jdk8ExamplesStream {
    public static void main(String[] args) {
	// New DateTime methods:
	LocalDate d = LocalDate.of(2021, 9, 10);
	Instant start = Instant.now();
	Instant end = Instant.now();
	Duration timeElapsed = Duration.between(start, end);
	System.out.println("+++++ " + timeElapsed);
	timeElapsed.toSeconds();
	timeElapsed.toMillis();

	Stream.of(1, 2, 3).reduce(0, (x, y) -> (x + y));
	Stream.of(10, 20, 30).filter(x -> x > 20).forEach(System.out::println);
	Stream.of(10, 20, 30).parallel().filter(x -> x > 20).count();
	Stream.iterate(10, n -> n + 1).limit(100).parallel().filter(x -> x > 20).count();

	// create //transform //collect
	Stream.of("a", "b", "c").map(String::toUpperCase).forEach(System.out::println);
	System.out.println("((((");

	// generate 10 random double numbers
	Stream.generate(Math::random).limit(10).forEach(System.out::println);

	System.out.println("((((");
	// peek - for debugging
	Stream.generate(Math::random).peek(x -> System.out.println("Fetch " + x)).limit(10)
		.forEach(System.out::println);
	// Tip: I found that Java

	streamExample();
	sumOfUniqueElement();
    }

    public static void sumOfUniqueElement() {
	// 3 apple, 2 banana, others 1
	List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

	Map<String, Long> result = items.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));

	System.out.println("*********** " + result);

	// System.out.println(result1);

    }

    public static void streamExample() {

	List<Employee> list = new ArrayList<Employee>();
	list.add(new Employee(11, "a1"));
	list.add(new Employee(12, "a2"));
	list.add(new Employee(13, "a3"));
	list.add(new Employee(14, "a4"));
	list.add(new Employee(15, "a5"));
	list.add(new Employee(15, "a5"));

	// list.stream().sorted(Comparator.comparing(Employee::getEmpName).thenComparing(Comparator.comparing(Employee::getId).reversed())).collect()

	list.parallelStream().forEach(p -> System.out.println(p.getId() + " | " + p.getEmpName()));
	long count = list.stream().distinct().count();
	System.out.println("count " + count);
	boolean b = list.stream().allMatch(s -> s.getId() > 13);

	System.out.println("boolean " + b);

    }
}
