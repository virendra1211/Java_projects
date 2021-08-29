package org.algoquestion;

public class MyMergeSort {
	static int tempArray[];
	public static void main(String[] args) {
		int arr[] = { 90, 23, 101, 45, 69,25};
		MyMergeSort ob = new MyMergeSort();
		tempArray = new int[arr.length]; 
		ob.sort(arr, 0, arr.length - 1);
		System.out.println("\nSorted array");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "");
		}
		
	}
	
	private void sort(int[] arr, int beg, int end) {

		while(beg<end) {
			int mid = (beg+end)/2;
			sort(arr,beg,mid);
			sort(arr,mid+1,end);
			mergeArray(beg,end,mid,arr);
		}
	}

	private void mergeArray(int beg, int end, int mid, int[] arr) {
		
		int l = mid - beg + 1;
		int r = end -mid;
			for(int i=beg;i<=end;i++) {
				tempArray[i] = arr[i];
			}
			int i = 0;
			int j= 0;
			int k = beg;
			
			while(i<=l && j<=r) {
				
				if(tempArray[i] <tempArray[j]) {
					arr[k] = tempArray[i];
					i++;
				}else {
					arr[k] = tempArray[j];
					j++;
				}
				k++;
			}
			
			while(i<mid) {
				arr[k]= tempArray[i];
				i++; k++;
			}
			
			while(j<end) {
				arr[k]= tempArray[j];
				j++; k++;
			}
		
	}
}
