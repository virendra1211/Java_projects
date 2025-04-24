package org.test;

import java.util.Arrays;

public class SumOrMinimumcount {
	public static void main(String[] args) {
	//	int array[] = {1,2,3,9};
		int array[] = {1,2,4,4};
		int sum = 8;
		if(isPairWithSum(array,sum)) {
			System.out.println("Pair has been found for "+sum);
		}else {
			System.out.println("Pair has been Not found for "+sum);
		}
	}

	private static boolean isPairWithSum(int[] array, int sum) {
		int li = 0;
		int hi = array.length -1;
		
		while(li <hi) {
			int s = array[li] - array[hi];
			if(s == sum) return true;
			
			if(s>0)
			li++;
			hi--;
		}
		
		return false;
	}
}
