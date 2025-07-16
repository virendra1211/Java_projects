package vk.learning.netjstechpogram;

public class ArmStrongNumber {
	public static void main(String[] args) {
		int num = 371;
		boolean isArmStrong = isArmStrongNumber(num);
		if (isArmStrong) {
			System.out.println(num + " is an Arm strong number");
		} else {
			System.out.println(num + " is not an Arm Strong number");
		}

		reverSeNumber(num);
	}

	private static void reverSeNumber(int num) {
		int sum = 0;

		while (num != 0) {
			int remainder = num % 10;
			sum = sum * 10 + remainder;
			num = num / 10;
		}
		System.out.println(sum);
	}

	private static boolean isArmStrongNumber(int num) {
		int sum = 0;
		int numLength = String.valueOf(num).length();
		int numCopy = num;

		while (numCopy != 0) {
			int remainder = numCopy % 10;
			sum = sum + (int) Math.pow(remainder, numLength);
			numCopy = numCopy / 10;
		}
		return sum == num;
	}
}
