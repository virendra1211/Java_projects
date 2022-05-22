package org.ask.interview.coding;

import java.util.ArrayList;
import java.util.List;

public class FindOutMovesEvenOdd {

	public static void main(String[] args) {
		// int []arr = {5,8,11,5,6,10};
		// int []arr = {13, 10, 21, 20};
		int[] arr = { 8, 5, 11, 4, 6 };
		List<Integer> arr1 = List.of( 8, 5, 11, 4, 6);
		System.out.println("moves " + getMoves(arr));

		
		System.out.println("moves1 " + getMoves1(arr1));
	}

	public static int getMoves(int[] arr) {
		int moves = 0;
		List<Integer> evenIndex = new ArrayList<Integer>();
		int size = arr.length;

		for (int i = 0; i < size; i++) {
			if (arr[i] % 2 == 0) {
				evenIndex.add(i);
			}else {
				moves++;
			}
		}
		/*
		 * int totalEven = evenIndex.size(); for (int i = 0; i < totalEven; i++) { if
		 * (!evenIndex.contains(i)) { moves++; } }
		 */
		return moves;
	}

	public static int getMoves1(List<Integer> arr) {
		int moves = 0;
		List<Integer> evenIndex = new ArrayList<Integer>();
		int size = arr.size(); // Lets first find out total even and odds number
		for (int i = 0; i < size; i++) {
			if (arr.get(i) % 2 == 0) {
				evenIndex.add(i);
			}
		} // then see how many evens are missing that many swaps
		int totalEven = evenIndex.size();
		for (int i = 0; i < totalEven; i++) {
			if (!evenIndex.contains(i)) {
				moves++;
			}
		}
		return moves;
	}

}
