package org.algoquestion;

// Binary search achieve only when array is sorted
public class BinarySearch {
	static int p[] = {1,6, 7,12,13,16,19,22,25,27,29,33,36,38};
	
	public static void main(String[] args) {
		int item;
		binarySearch(0,p.length-1,29);
	}
	
	public static void binarySearch(int li,int hi,int item) {
		int mi = li + hi/2;

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
