package org.datastructure;

public class SecondLargest {
	public static void main(String[] args) {
		int arr[] = {5,7,11,25,22,14,13,23};
		// 5, 7 11,13, 14,22,23, 25
		int max = arr[0];
		int second_largest =0;
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i] >max) {
				second_largest = max;
				max = arr[i];
			}else if(arr[i] >second_largest && arr[i] !=max) {
				second_largest =arr[i];
			}
		}
		System.out.println(max+" - "+second_largest);
		SecondLargest sl = new SecondLargest();
		sl.findOutNthlargest(arr,3);
	}
	
	/*
	 * find out the nth element and once find out break
	 */
	void findOutNthlargest(int[] a,int nth) {
		for(int i=0;i<a.length-1;i++) {
			
			for(int j=i+1;j<a.length;j++) {
				
					if(a[i] < a[j]) {
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
			}
			
			if(i == nth-1) {
				System.out.println(nth+" element is "+a[i]);
				break;
			}
		}
		
	}
}
