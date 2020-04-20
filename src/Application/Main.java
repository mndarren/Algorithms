package Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Algorithms.AmazonAssession;
import Algorithms.BinaryStringAddition;
import Algorithms.CheckPalindrome;
import Algorithms.IntToRoman;
import Algorithms.LowestCommonAncestorBST;
import Algorithms.RecursiveBasic;
import Algorithms.RemoveNthFromEnd;
import Algorithms.SortingAlgorithms;
import Algorithms.Sudoku;
import Algorithms.SwapNodesPairs;
import Algorithms.TwoSum;
import DataStructures.BSTNode;
import DataStructures.BinarySearchTree;
import DataStructures.LinkedList;
import DataStructures.ListNode;
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
		// Test Find Core Nodes from matrix
		testFindCoreNodes();
		// Test Binary String Addition
		testBinaryStringAddition();
		// Test Sudoku
		testSudoku();
		// Test Recursive
		testRecursive();
	}
	
	// Test Recursive methods
	private static void testRecursive() {
	    int n = 8;
	    int a = 16, b = 24;
	    RecursiveBasic recur = new RecursiveBasic();
	    System.out.println("Fibonacci of " + n + " = " + recur.fibonacci(n));
	    System.out.println("Factorial of " + n + " = " + recur.factorial(n));
	    System.out.println("Factorial of " + n + " = " + recur.factorialTail(n));
	    System.out.println("The GCD of " + a + " and " + b + " = " + recur.gcd(b, a));
	}
	
	// Test Sudoku
	private static void testSudoku() {
	    char[][] yesSudoku = new char[][] {
	        {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
            {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
	    };
	    
	    char[][] noSudoku = new char[][] {
	        {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
	        {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
	        {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
	        {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
	        {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
	        {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
	        {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
	        {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
	        {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
	    };
	    
	    char[][] yesSudoku1 = new char[][] {
            {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
	    
	    Sudoku sudoku = new Sudoku();
	    System.out.println("\nthe Yes Sudoku = " + (sudoku.isValidSudoku(yesSudoku) ? "True" : "False"));
	    System.out.println("\nthe No Sudoku = " + (sudoku.isValidSudoku(noSudoku) ? "True" : "False"));
	    System.out.println("\nthe No Sudoku = " + (sudoku.isSolvable(yesSudoku1) ? "True" : "False"));
	    
	}
	
	//Test binary string addition
	private static void testBinaryStringAddition() {
	    String s1 = "111";
	    String s2 = "10001";
	    
	    BinaryStringAddition bsa = new BinaryStringAddition();
	    String sum = bsa.addBinary(s1, s2);
	    System.out.println("The sum of " + s1 + " and " + s2 + " = " + sum);
	    
	    // add 2 linked list numbers
	    int[] listV1 = new int[] {4, 1, 9};
	    int[] listV2 = new int[] {3, 2, 7, 4};
	    
	    LinkedList l1 = new LinkedList();
	    l1.addArray(listV1);
	    LinkedList l2 = new LinkedList();
	    l2.addArray(listV2);
	    
	    ListNode result = bsa.addLinkedListNumbers(l1.getHead(), l2.getHead());
	    System.out.print("The sum of the 2 linked lists = ");
	    LinkedList ll = new LinkedList();
	    ll.setHead(result);
	    ll.traverseItems();
	}
	
	//Test find core nodes
	private static void testFindCoreNodes() {
	    ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
        
        grid.add(0, new ArrayList<Integer>(Arrays.asList(0, 1, 1, 0, 0, 0, 0)));
        grid.add(1, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 0, 0, 0)));
        grid.add(2, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 0, 1, 0)));
        grid.add(3, new ArrayList<Integer>(Arrays.asList(0, 1, 1, 0, 1, 0, 0)));
        grid.add(4, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1, 0, 0, 0)));
        grid.add(5, new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 0, 0, 1)));
        grid.add(6, new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 1, 0)));
        
        System.out.println("\nOriginal Grid:");
        print2DArrayList(grid);
        
        AmazonAssession amazon = new AmazonAssession();
        ArrayList<Integer> coreNodes = amazon.findCoreNodes(7, grid);
        System.out.println("The core Nodes: " + coreNodes.toString());
        
	}
	
	// Test swap pairs
	private static void testSwapPairs() {
	    // Create List for test
        LinkedList ll = new LinkedList();
        int[] numbers = new int[] {1, 3, 5, 7, 8, 7, 5, 3, 1};
        ll.addArray(numbers);
        System.out.println("Before swap pairs: ");
        ll.traverseItems();
        
        ll.setHead(new SwapNodesPairs().swapPairs(ll.getHead()));
        System.out.println("\nAfter swap pairs: ");
        ll.traverseItems();
	}
	
	// Test Matrix Net
	private static void testMatrixNet() {
		ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
		
		grid.add(0, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1)));
		grid.add(1, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1)));
		grid.add(2, new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1)));
		grid.add(3, new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1)));
		
		System.out.println("Original matrix: ");
		print2DArrayList(grid);
		
		AmazonAssession aa = new AmazonAssession();
//		int parks = aa.parksNeeded2(4, 5, grid); // this version is better
		int parks = aa.parksNeeded(4, 5, grid);
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
	
	// Tool: print 2D ArrayList
	private static void print2DArrayList(ArrayList<ArrayList<Integer>> grid) {
	    for(ArrayList<Integer> list : grid) {
            for(Integer i : list) {
                System.out.print(" " + i.intValue());
            }
            System.out.println();
        }
	}

}
