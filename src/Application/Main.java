package Application;

import java.util.List;

import Algorithms.CheckPalindrome;
import Algorithms.LowestCommonAncestorBST;
import Algorithms.SortingAlgorithms;
import Algorithms.TwoSum;
import DataStructures.BSTNode;
import DataStructures.BinarySearchTree;
import DataStructures.LinkedList;

public class Main {

	public static void main(String[] args) {
		// Test Two Sum
		testTwoSum();
		// Test LCA of BST
		testLCAofBST();
		// Test Palindrome
		testPalindrome();
		// Test Sorting
		testSorting();
	}
	
	/**
	 * Test Sorting
	 */
	private static void testSorting() {
		int[] orig = new int[] {89, 2, 56, 33, 67, 71, 99, 27, 44};
		int[] a = new int[orig.length];
		SortingAlgorithms sorting = new SortingAlgorithms();
		
		// Test Bubble sort
		for (int i=0; i<a.length; i++) {
			a[i] = orig[i];
		}
		sorting.bubbleSort(a);
		System.out.println("\nThe result of Bubble Sorting = ");
		printArray(a);
		
		// Test Insertion sort
		for (int i=0; i<a.length; i++) {
			a[i] = orig[i];
		}
		sorting.insertionSort(a);
		System.out.println("\nThe result of Bubble Sorting = ");
		printArray(a);
	}
	
	private static void printArray(int[] arr) {
		for (int i = 0; i <arr.length; i++) {
			   System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	/**
	 * Test Palindrome
	 */
	private static void testPalindrome() {
		LinkedList ll = new LinkedList();
		int[] numbers = new int[] {1, 3, 5, 7, 8, 7, 5, 3, 1};
		for (int i = 0; i < numbers.length; i++) {
			ll.add(numbers[i]);
		}
		ll.traverseItems();
		
		CheckPalindrome cp = new CheckPalindrome();
		Boolean isPalindrome = cp.isPalindrome(ll.getHead());
		System.out.println("\nThe list isPalindrome = " + (isPalindrome ? "True\n": "False\n"));
		ll.traverseItems();
	}
	
	/**
	 * Test LCA of BST
	 */
	private static void testLCAofBST() {
		BinarySearchTree bST = new BinarySearchTree();
		int[] numbers = new int[] {6, 2, 8, 0, 4, 7, 9, 3, 5};
		// create a Binary search tree
		for (int i = 0; i < numbers.length; i++) {
			bST.add(numbers[i]);
		}
		
		LowestCommonAncestorBST lCA = new LowestCommonAncestorBST();
		BSTNode node = lCA.lowestCommonAncestorTD(bST.getRoot(), new BSTNode(0), new BSTNode(3));
		System.out.println("The LCA = " + node.toString());
		
		int lowest = bST.findSmallestValue();
		System.out.println("The lowest value = " + lowest);
		bST.delete(lowest);
		int lowestNew = bST.findSmallestValue();
		System.out.println("The lowest value after delete = " + lowestNew);
		bST.add(lowest);
		lowest = bST.findSmallestValue();
		System.out.println("The lowest value after add it back = " + lowest);
		System.out.println("Traverse In Order: ");
		bST.queryInOrder();
		System.out.println("\nTraverse Pre Order: ");
		bST.queryPreOrder();
		System.out.println("\nTraverse Post Order: ");
		bST.queryPostOrder();
		System.out.println("\n");
	}
	
	/**
	 * Test Two Sum algorithms
	 */
	private static void testTwoSum() {
		int[] numbers = new int[] {2, 3, 5, 7, 9, 11, 23, 15};
		//find the target 18
		TwoSum twoSum = new TwoSum();
		int[] positions = twoSum.twoSumHashTable(numbers, 18);
		if (positions.length > 0)
			System.out.println("Found two sum: " + positions[0] + ", " + positions[1]);
		
		positions = twoSum.twoSumPointers(numbers, 18);
		if (positions.length > 0)
			System.out.println("Found two sum: " + positions[0] + ", " + positions[1]);
		
		List<List<Integer>> positionsList = twoSum.twoSumMutiplePairs(numbers, 18);
		if (positionsList.size() > 0) {
			String s = "Found two sum: ";
			for (int i = 0; i < positionsList.size(); i++) {
				List<Integer> ps = positionsList.get(i);
				s = s +  + ps.get(0) + ", " + ps.get(1) + "; ";
			}
			System.out.println(s);
		}
	}

}
