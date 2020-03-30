package Application;

import java.util.List;

import Algorithms.LowestCommonAncestorBST;
import Algorithms.TwoSum;
import DataStructures.BSTNode;
import DataStructures.BinarySearchTree;

public class Main {

	public static void main(String[] args) {
		// Test Two Sum
		testTwoSum();
		// Test LCA of BST
		testLCAofBST();
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
