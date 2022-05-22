package arrayconcept;




public class arraydemo {

	public static void main(String[] args) {
		String[] name1 = new String[] { "abc", "def", "pqr", "xyz" };
		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5, 9, 10, 6, 7, 8 };

		for (int i = 0; i < name1.length; i++) {
			System.out.println(name1[i]);
		}
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.println(intArray[i]);
		}
		
	}

}