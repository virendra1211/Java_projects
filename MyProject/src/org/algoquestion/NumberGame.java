package org.algoquestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberGame {
	public static void main(String[] args) {
		Integer arr[]= {1, 3, 4};
		System.out.println(sumToTarget(arr,5));
	
		System.out.println("----------");
		System.out.println(hasArrayTwoCandidate(arr,arr.length,5));
		
	}

	public static Boolean hasArrayTwoCandidate(Integer A[],int arr_size,int sum) {
		int l,r;
		
		Arrays.sort(A);
		
		l=0;
		r = arr_size -1;
		while(l<r) {
			if(A[l]+A[r]  == sum) {
				return true;
			}else if(A[l]+A[r]  < sum) {
				l++;
			}else {
				// > then value for sum
				r--;
			}
			
		}
		
		return false;
	}
	public static Boolean sumToTarget(Integer[] arr,Integer target) {
		  Map<Integer, Integer> numMap = new HashMap<>();
		  for (int i = 0; i < arr.length; i++) {
		    int complement = target - arr[i];
		    if (numMap.containsKey(complement)) {
		    	System.out.println(arr[numMap.get(complement)]+" - "+arr[i]);
		      return true;
		    } else {
		      numMap.put(arr[i], i);
		    }
		  }
		return false;
	}
}
