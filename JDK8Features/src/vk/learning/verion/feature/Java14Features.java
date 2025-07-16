package vk.learning.verion.feature;

/*
Java 14 Features 
As a developer, we have following new features which are added in Java 14.

1. Record Type (Preview)
2. Switch Expressions
3. Pattern matching for instanceof Operator (Preview)
4. Helpful NullPointerExceptions
5. Text Blocks (Preview)
 */
public class Java14Features {

	public static void main(String[] args) {
// 1. SWith expression
		/*
		 * boolean isTodayHoliday = switch (day) { case "MONDAY", "TUESDAY",
		 * "WEDNESDAY", "THURSDAY", "FRIDAY" -> false; case "SATURDAY", "SUNDAY" ->
		 * true; default -> throw new IllegalArgumentException("What's a " + day); };
		 */
		// 2. Patterm matching for instance of
		Object obj;
		if (obj instanceof String) {
			String str = (String) obj;
			int len = str.length();
			// ...
		}
		// java 14 like this
		/*
		 * if (obj instanceof String str) { int len = str.length(); // ... }
		 */

		// 3. introduced record class, generate essential methods constructor , getter
		// setter, equals , hashcode, and tostring, reduce boilder plat of code,
		// they are implicitly final and immutable, making them suitable for
		// representing data transfer object (DTOs) or value objects.
		// public record User(int id, String password) { };

		// 4. improve NullPointerException, earlier given exception with line number,
		// now " says cannot store to int array because "a" is null like this
		// 5 ZGC, it's low-latency garbage collector wa first introduced in java 11 as
		// experimental feature.

	}

}
