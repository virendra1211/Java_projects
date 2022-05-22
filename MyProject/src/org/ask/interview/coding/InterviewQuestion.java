package org.ask.interview.coding;

import java.util.List;

class InterviewQuestion {
/*
 * a = {1
 */
	static int inf = 10000009;

	// Function to minimize the cost to
	// reduce the array to a single element
	public static int minCost(int a[], int i,
							int j, int k)
	{
		if (i >= j) {

			// Base case
			// If n = 1 or n = 0
			return 0;
		}

		// Initialize cost to maximum value
		int best_cost = inf;

		// Iterate through all possible indices
		// and find the best index
		// to combine the subproblems
		for (int pos = i; pos < j; pos++) {

			// Compute left subproblem
			int left = minCost(a, i, pos, k);

			// Compute right subproblem
			int right = minCost(a, pos + 1, j, k);

			// Calculate the best cost
			best_cost = Math.min(
				best_cost,
				left + right + k * Combine(a, i, j));
		}

		// Return the answer
		return best_cost;
	}

	// Function to combine the sum of the two halves
	public static int Combine(int a[], int i, int j)
	{
		int sum = 0;

		// Calculate the sum from i to j
		for (int l = i; l <= j; l++)
			sum += a[l];

		return sum;
	}

	// Driver code
	public static void main(String[] args)
	{
		//0,1,2,-3
		//0,1,2,-3 -> 0,1,3,0
		
		int n = 4;
		int a[] = { 4, 4,7,1,4 };
		int k = 3;

		System.out.println(minCost(a, 0, n - 1, k));
		
		 //int a1[] = { 1 ,3 ,5 ,2 ,10};
		 int a1[] = {6,10,2,2,6,1,7};
		  //(1-3)2+(3-5)2+(5-2)2+(2-10)2
		 
		int subTotal =0;
		for(int i =0;i<a1.length-1;i++) {
			int subCost  = a1[i] - a1[i+1];
			subTotal += subCost*subCost;
		}
		System.out.println(subTotal);
	}
}
