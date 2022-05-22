package virendra.interview;

public class PalidromeNumber {
	public static void main(String[] args) {
		Integer number = 24542;
		if(isPalidrome(number)) {
			System.out.println("It's Palidrome ");
		}else {
			System.out.println("It's Not Palidrome ");
		}
	}

	public static boolean isPalidrome(Integer number) {
		Integer temp = number;
		// 453
		int sum = 0;
		while (number > 0) {
			int reminder = number % 10; // 3,	5 // 4
			sum = sum * 10 + reminder; // 30 +5 // 35 //350 +4 = 354
			number = number / 10; // 45 //4 // 0
		}
		if(temp == sum) return true;

		return false;

	}
}
