package com.test.codility;

public class Test {
	public static void main(String[] args) {
		//solution(16);
		solution(19);
	}

	private static void solution(int N) {
		int i=1;
		while(true) {
			if(getSum(i) == N) {
				System.out.println(i);
				break;
			}
			i++;
		}
		
	}

	private static int getSum(int i) {
		int sum = 0;
		while(i>0) {
			sum = sum + i %10;
			i = i/10;
		}
		return sum;
	}


}
