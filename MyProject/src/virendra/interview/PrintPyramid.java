package virendra.interview;

public class PrintPyramid {

	public static void main(String[] args) {

		int pyramidCout = 8;
		int count = 1;

		for (int i = pyramidCout; i > 0; i--) { // termination condition

			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			int c = 1;
			for (int p = 0; p < count; p++) {
				// System.out.print(count +" ");
				// other way start
				System.out.print(c++ + " ");
				// System.out.print("* ");
				// other way end
			}
			System.out.println();
			count++;
		}
	}
}
