package org.test;

// A simple Java program to find three elements
// whose sum is equal to zero
import java.io.*;
import java.util.*;

class num {
	// Prints all triplets in arr[] with 0 sum
	static void findTriplets(int[] arr, int n) {
		boolean found = false;
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				for (int k = j + 1; k < n-1; k++) {
					for (int l = k + 1; l < n; l++) {
						if (arr[i] + arr[j] + arr[k] + arr[l] == 0) {
							System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[l]);
							found = true;
						}
					}
				}
			}
		}
		// in the subsequence loops we are doing to minimize array elements
		

		// If no triplet with 0 sum found in array
		if (found == false)
			System.out.println(" not exist ");
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 1,6,5,2,0,2,8};
		int n = arr.length;
		findTriplets(arr, n);
	}
}

// This code is contributed by Aditya Kumar (adityakumar129)
