package org.algoquestion;

// start from the first element one by one
// assume we have lakhs of records if he never found the unnecessary spending time
public class LinearSearch {

	public static void main(String[] args) {
		
		int arr[] = {5,3,6,1,5,2};
		int item =5;
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i] == item) {
				System.out.println("index position "+i+" item "+item);
			}
		}
	}
}
