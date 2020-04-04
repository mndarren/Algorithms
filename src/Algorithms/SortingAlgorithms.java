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
					exchange(a, j, j+1);
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
					exchange(a, j, j-1);
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
		for (int i = 0; i < a.length - 1; i++) {
			int smallest = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[smallest]) {
					smallest = j;
				}
			}
			if (smallest != i) {
				exchange(a, i, smallest);
			}
		}
		return a;
	}
	
	/**
	 * Heap Sort: Time O(NlogN), Space O(1)
	 * @param a
	 * @return
	 */
	public int[] heapSort(int[] a) {
		// Build heap
		for (int i = (a.length-1)/2; i>=0; i--) {
			heapify(a, i, a.length - 1);
		}
		
		// Heap sort
		int sizeOfHeap = a.length - 1;
		for (int i = sizeOfHeap; i > 0; i--) {
			exchange(a, 0, i);
			sizeOfHeap = sizeOfHeap - 1;
			heapify(a, 0, sizeOfHeap);
		}
		return a;
	}
	
	// Tool for heap sort
	private void heapify(int[] a, int i, int size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max;
		if (left <= size && a[left] > a[i]) {
			max = left;
		} else {
			max = i;
		}
		if (right <= size && a[right] > a[max]) {
			max = right;
		}
		if (max != i) {
			exchange(a, max, i);
			heapify(a, max, size);
		}
	}
	
	// Tool for exchange element value
	private void exchange(int[] a, int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
