package vk.learning.array.tough.interview;

public class Sum {
	static int digSum(int n) {
		int sum = 0;

		// Keep summing digits until a single-digit is left
		while (n > 0 || sum > 9) {
			if (n == 0) {
				n = sum;
				sum = 0;
			}
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

	// Driver code
	public static void main(String[] args) {
		int n = 1234;
		System.out.println(digSum(n)); // Output: 1

		int n1 = 5674;
		System.out.println(digSum(n1)); // Output: 1

		// other way around
		int result = getSingleDigitSum(n);
		System.out.println("Single digit sum: " + result);
		int result1 = getSingleDigitSum(n1);
		System.out.println("Single digit sum: " + result1);

	}

	public static int getSingleDigitSum(int num) {
		while (num >= 10) {
			num = String.valueOf(num).chars().peek(p -> System.out.println(p)).map(c -> c - '0').sum();
		}
		return num;
	}
}
