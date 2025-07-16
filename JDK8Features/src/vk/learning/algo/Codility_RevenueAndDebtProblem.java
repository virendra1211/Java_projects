package vk.learning.algo;

import java.util.PriorityQueue;
import java.util.Queue;

/*Problem Statement:
A company has a list of expected revenues and payments for the upcoming year in chronological order.
The problem is that at some moments in time the sum of previous payments can be larger than their previous revenue.
This would put the company in debt. To avoid this problem the company, at the beginning of the year, reschedules some expenses to the end of the year.

You are given an array of integers, where positive numbers represent revenues and negative numbers represent expenses, all in chronological order.
In one move, you can relocate any expense (negative number) to the end of the array.
What is the minimum number of such relocations to ensure that the company never falls into debt?
In other words: you need to make sure that there is no consecutive sequence of elements starting from the beginning of the array,
that sums up to a negative number.

You can assume that the sum of all elements in the array is nonnegative.

Write a function:
class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the minimum number of relocations, so that company falls into no debt.

Examples:
1. Given A = [10, -10, -1, -1, 10], the function should return 1. It is enough to move -10 to the end of the array.
2. Given A = [1, -1, -1, -1, 1, 1, 1], the function should return 3.
3. Given A = [5, -2, 2, -1], the function should return 0.*/
public class Codility_RevenueAndDebtProblem {

	public static void main(String[] args) {
		// int A[] = { 10, -10, -1, -1, 10 };
		int A[] = { 5, -6, -6, -5 };
		int B[] = { 5, -2, 2, -1 };
		// 2. Given A = [1, -1, -1, -1, 1, 1, 1], the function should return 3.
		// 3. Given A = [5, -2, 2, -1], the function should return 0.
		System.out.println(solution(A));
		System.out.println(solution(B));
	}

	public static int solution(int[] transactions) {
		int relocations = 0;
		long balance = 0;

		Queue<Integer> expenses = new PriorityQueue<>();

		for (int transaction : transactions) {
			balance += transaction;

			if (transaction < 0) {
				expenses.add(transaction);
			}

			while (balance < 0 && !expenses.isEmpty()) {
				int removeExpense = expenses.poll();
				balance -= removeExpense;
				relocations++;
			}
		}

		return relocations;
	}
}
