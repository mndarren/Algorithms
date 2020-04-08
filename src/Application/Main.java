package Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Algorithms.AmazonAssession;
import Algorithms.CheckPalindrome;
import Algorithms.IntToRoman;
import Algorithms.LowestCommonAncestorBST;
import Algorithms.RemoveNthFromEnd;
import Algorithms.SortingAlgorithms;
import Algorithms.SwapNodesPairs;
import Algorithms.TwoSum;
import DataStructures.BSTNode;
import DataStructures.BinarySearchTree;
import DataStructures.LinkedList;
import DataStructures.MatrixNet;

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
		//Test Roman
		testRoman();
		// Test Remove Nth from end
		testRemoveNthFromEnd();
		// Test Matrix Net
		testMatrixNet();
		// Test swap pairs
		testSwapPairs();
	}
	
	//Test find core nodes
	private static void testFindCoreNodes() {
	    ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        
        grid.add(0, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1)));
        grid.add(1, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1)));
        grid.add(2, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1)));
        grid.add(3, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1)));
        
        
	}
	
	// Test swap pairs
	private static void testSwapPairs() {
	    // Create List for test
        LinkedList ll = new LinkedList();
        int[] numbers = new int[] {1, 3, 5, 7, 8, 7, 5, 3, 1};
        for (int i = 0; i < numbers.length; i++) {
            ll.add(numbers[i]);
        }
        System.out.println("Before swap pairs: ");
        ll.traverseItems();
        
        ll.setHead(new SwapNodesPairs().swapPairs(ll.getHead()));
        System.out.println("After swap pairs: ");
        ll.traverseItems();
	}
	
	// Test Matrix Net
	private static void testMatrixNet() {
		ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
		
		grid.add(0, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1)));
		grid.add(1, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1)));
		grid.add(2, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1)));
		grid.add(3, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1)));
		
		MatrixNet matrix = new MatrixNet();
		System.out.println("Original matrix: ");
		for(ArrayList<Integer> list : grid) {
			for(Integer i : list) {
				System.out.print(" " + i.intValue());
			}
			System.out.println();
		}
		
		AmazonAssession aa = new AmazonAssession();
		int parks = aa.parksNeeded2(4, 5, grid);
		System.out.println("We need to build " + parks + " Parks.");
	}
	
	// Test Remove Nth From End
	private static void testRemoveNthFromEnd() {
		// Create List for test
		LinkedList ll = new LinkedList();
		int[] numbers = new int[] {1, 3, 5, 7, 8, 7, 5, 3, 1};
		for (int i = 0; i < numbers.length; i++) {
			ll.add(numbers[i]);
		}
		ll.traverseItems();
		
		// Test remove Nth from end
		RemoveNthFromEnd removeNth = new RemoveNthFromEnd();
		ll.setHead(removeNth.removeNthFromEnd(ll.getHead(), 9));
		System.out.println();
		ll.traverseItems();
		ll.setHead(removeNth.removeNthFromEnd(ll.getHead(), 5));
		System.out.println();
		ll.traverseItems();
		ll.setHead(removeNth.removeNthFromEnd(ll.getHead(), 1));
		System.out.println();
		ll.traverseItems();
		ll.setHead(removeNth.removeNthFromEnd(ll.getHead(), 0));
		System.out.println();
		ll.traverseItems();
		ll.remove(7);
		System.out.println();
		ll.traverseItems();
		System.out.println();
	}
	
	// Test Roman to int convertion
	private static void testRoman() {
		int a = 3874;
		IntToRoman itr = new IntToRoman();
		String roman = itr.intToRoman(a);
		System.out.println("The Roman of " + a + " is " + roman);
		
		// Test Roman to int
		int n = itr.romanToInt(roman);
		System.out.println("The Integer of " + roman + " is " + n);
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
		System.out.println("\nThe result of Insertion Sorting = ");
		printArray(a);
		
		// Test Insertion sort
		for (int i=0; i<a.length; i++) {
			a[i] = orig[i];
		}
		sorting.selectionSort(a);
		System.out.println("\nThe result of Selection Sorting = ");
		printArray(a);
		
		// Test Insertion sort
		for (int i=0; i<a.length; i++) {
			a[i] = orig[i];
		}
		sorting.heapSort(a);
		System.out.println("\nThe result of Heap Sorting = ");
		printArray(a);
	}
	// Tool - to print out array elements
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
		
		// Test integer is a Palindrome
		int x = 123454321;
		int y = 1234543210;
		Boolean isP = cp.isPalintrome(x);
		System.out.println("\nThe integer X isPalindrome = " + (isP ? "True\n": "False\n"));
		isP = cp.isPalintrome(y);
		System.out.println("\nThe integer Y isPalindrome = " + (isP ? "True\n": "False\n"));
		
		// Test String is a Palindrome
		String s1 = "asd ff,ds a";
		String s2 = "asdfhk ,ll";
		isP = cp.isPalintrome(s1);
		System.out.println("\nThe integer S1 isPalindrome = " + (isP ? "True\n": "False\n"));
		isP = cp.isPalintrome(s2);
		System.out.println("\nThe integer S2 isPalindrome = " + (isP ? "True\n": "False\n"));
		
		// Test finding longest substring Palindrome
		String s3 = "uuiasdffdsa1234321";
		String longest = cp.longestPalindrome(s3);
		System.out.println("The longest Palindrome = " + longest);
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
