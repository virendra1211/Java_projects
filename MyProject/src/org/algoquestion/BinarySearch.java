package org.algoquestion;

/**
 * Binary search is the process of searching an element from sorted array by repeatedly dividing the search interval in half.

Binary search is faster than linear search.

Although binary search is very optimized way of searching a particular elemnt but the array must be sorted on which you want to perform search process.
i the array is not sorted in advance then we have to perform "Sorting first" and then we can perform sorting binary search on that.

 * @author Virendra khade
 *
 */
// Binary search achieve only when array is sorted
public class BinarySearch {
	static int p[] = {1,6, 7,12,13,16,19,22,25,27,29,33,36,38};
	
	public static void main(String[] args) {
		int item;
		binarySearch(0,p.length-1,29);
	}
	
	public static void binarySearch(int li,int hi,int item) {
		int mi = (li + hi)/2;

		while(li<=hi) {
			if(p[mi] == item) {
				System.out.println("Index found "+mi +" found"+item);
				break;
			}else if (p[mi] <item) {
				li = mi+1;
			}
			else  {
				hi= mi - 1;
			}
			mi = (li+hi)/2;
		}
		
	}

}
