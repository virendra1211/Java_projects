package org.ask.interview.coding;

import java.util.Arrays;

public class MergeArray1 {

	public static void main(String[] args) {
		int[] A = { 1, 4, 7, 19, 23,24 };
		int[] B = { 2, 7, 16, 51, 67 ,69,70};

		int[] result = mergeArrays(A, B);
		System.out.println(Arrays.toString(result));

	}

	private static int[] mergeArrays(int[] a, int[] b) {
		int result[] = new int[a.length+b.length];
		int aIndex = 0;
		int bIndex = 0;
		int cursor =0;
		
		while(aIndex <a.length && bIndex < b.length) {
			
			if(a[aIndex] <= b[bIndex]) {
				result[cursor++] = a[aIndex];
				aIndex++;
			}else {
				result[cursor++] = b[bIndex];
				bIndex++;
			}
		}
	
		if(bIndex >= b.length && aIndex < a.length) {
			while(aIndex < a.length) {
				result[cursor++] = a[aIndex++];
			}
		}else {
			while(bIndex < b.length) {
				result[cursor++] = b[bIndex++];
			}
		}
		
		// TODO Auto-generated method stub
		return result;
	}

}
