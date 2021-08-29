package org.algoquestion;

/*
 * 	Thre option
	to choose
	pivot element are:-
	left or
	right end.this
	could be

	O(n^2) performance depending on the input so this is a bad choice but easiest to implement.
15,9,7,13,12,16,4,18,11};
use pivot element like here example 12 
- then go to left to lesser value than 12
- then go to right to find greator value than 12
once we found swap the element

 */
public class QuickSort {
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();

		int [] arr = {15,9,7,13,12,16,4,18,11};
		int leng = arr.length;
		qs.quickSortRecursion(arr,0,leng-1);
		qs.display(arr);
	}

	void quickSortRecursion(int[] arr, int low, int high) {

		int pi = partition(arr, low, high);
		if (low < pi - 1) {
			quickSortRecursion(arr, low, pi - 1);
		}
		if (pi < high) {
			quickSortRecursion(arr, pi, high);
		}
	}
	
	int partition(int[] arr, int low, int high) {
/*		we have option to choose pivot element. left or right end . this could give O(n^2)
		performance depending on the input so this is bad choice but easiest to implement
		- Best of 3. left, middle and right. This given substantially better performance than simply choosing and end in the worst case.
		Random. choosing a random pivot is fairly easy to implement and improve performance 		
		*/
		int pivot = arr[(low + high) / 2];

		while (low <= high) {
			while (arr[low] < pivot) {
				low++;
			}
			while (arr[high] > pivot) {
				high--;
			}
			if (low <= high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			}
		}
		return low;
	}

	
	void display(int[] arr) {
			for(int i:arr) {
				System.out.println(i);
			}
	}

}
