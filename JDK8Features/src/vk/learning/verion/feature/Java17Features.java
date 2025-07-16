package vk.learning.verion.feature;

public class Java17Features {
	/*
	 * 1. Sealed classes: sealed classes restrict the classes that can extend of
	 * implement them, promoting better control over the inheritance hierarchy
	 */
	public static void main(String[] args) {
		// 1. Sealed class
		/*
		 * public abstract sealed class Shape permits Circle, Rectable{} implementation
		 * public final class Circle extends Shape{}
		 */
		// 2. Pattern matching for switch preview , more expressive an concise

		/*
		 * Swtich(shap){ case Circle c-> "circle with Radius " +c.redius(); case
		 * Rectable r -> rectable with width" +r.redius();" default -> "Unknown shape";
		 * }
		 */

		// 3. In Java 17, Class Data Sharing (CDS) and Parallel Class Loading are two
		// important features aimed at improving startup time and reducing memory usage,
		// particularly beneficial in large-scale or cloud-native applications.
		// key benifit:
		/*
		 * Faster JVM startup.
		 * 
		 * Reduced memory usage by sharing common class metadata across JVM process
		 */

	}

}
