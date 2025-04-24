package org.datastructure;

public class BubbleSort {
	public static void main(String[] args) {
		Integer arr[] = { 6, 15, 18, 10, 11, 13, 22 };
		//Integer arr[] = {1,3,2,4,5};
		bubbleSort(arr);
		for (Integer p : arr) {
			System.out.println(p);
		}

	}

	static void bubbleSort(Integer[] arr) {
		int n = arr.length;
		int count =0;
		
		// 	for (int j = 0; j < n - i - 1; j++) condition added for -i
		// because we need to skip last element as it's already compared with all the adjasent
		/*
		 * I In the second loop we have added -i as we don't want to compare last element
		 * II we should use count option to verify that no sorting is required now
		 */
		for (int i = 0; i < n - 1; i++) {
			count = 0;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					count++;
					System.out.println("aacount "+count);

				}
			}
			if(count ==0) break;
		}
		
		System.out.println("count "+count);
	}
	
}
