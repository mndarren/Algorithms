package Algorithms;

/**
 * 
 * @apiSpec 10 Sorting algorithms: Bubble, Insertion, Selection, Heap, Quick, Merge, Radix, Shell, Counting, Bucket 
 * @author Darren Zhao Xie
 * @date Apr 3, 2020 Created
 *
 */
public class SortingAlgorithms {
	/**
	 * Bubble Sort: Time O(n^2), Space O(1)
	 * @param a - Array
	 * @return array
	 */
	public int[] bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
	
	/**
	 * Insertion Sort: Time O(n^2), Space O(1)
	 * @param a
	 * @return
	 */
	public int[] insertionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j-1] > a[j]) {
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				} else
					break;
				
			}
		}
		return a;
	}
	
	/**
	 * Selection Sort: Time O(n^2), Space O(1)
	 * @param a
	 * @return array
	 */
	public int[] selectionSort(int[] a) {
		
		return null;
	}
}
