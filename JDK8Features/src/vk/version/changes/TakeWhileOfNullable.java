package vk.version.changes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

// java 9
public class TakeWhileOfNullable {

	public static void main(String[] args) {
		String value1 = "Hello";
		String value2 = null;

		List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c")); // Using ofNullable with
																			// takeWhile
		int count = 0;
		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			String element = iterator.next();
			if (element.equals("b"))
				iterator.remove();
		}
		System.out.println(list);
		Stream.of(value1, value2).flatMap(val -> Stream.ofNullable(val)) // Filters out null
																			// values
				.takeWhile(val -> !val.equals("World")) // Takes elements until "World" is
														// encountered
				.forEach(System.out::println);

		// Output:
		// Hello
		// Example with an initial null value
		Stream.ofNullable(value2).takeWhile(Objects::nonNull).forEach(System.out::println);
		// No output as the stream is empty
	}
}
/*
 * Java 9 Features define a code where you can use any cloud and deploy your
 * code any any cloud
 * 
 * Java 9 Features: 1. List.of or Map.of method to add any value/object 2.
 * Jshell, Interactive read evaluate print loop(REPL), jshell you can launch
 * from the console
 * 
 * 3. Stream API improvement, added below methods. takeWhile,
 * dropwhile,ofNullable
 * 
 * 4. private method in interface public interface Card{
 * 
 * private Long createCardID(){ // Method implementation goes here. }
 * 
 * private static void displayCardDetails(){ // Method implementation goes here.
 * }
 * 
 * }
 * 
 * 5. Support HTTP client, As existing or legacy HTTP api client API has
 * enoronous issues(support HTTP1 protocol but doesn't support HTTP2 protocol
 * and web socket, they are replacing with this HttpURLConnection API with new
 * HTTP client.It support both synchronous and asynchronous modes.
 * 
 * 6.Miscellaneous java 9 features GC imporvemnts stak-walkign api parser API
 * for nashorn
 **************************************************
 * 
 * java 11 features
 **************************************************
 * 1. Running java file with single command 2. New utility methods in String
 * class - isBlank,, isLines 3. var list = new ArrayList<String>();
 * 
 * JEP 323 allows var to be used to declare the formal parameters of an
 * implicitly typed lambda expression. 4.
 * 
 */