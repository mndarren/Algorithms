package Algorithms;

import Algorithms.TwoSum;

public class Main {

	public static void main(String[] args) {
		int[] numbers = new int[] {2, 3, 5, 7, 9, 11, 23, 15};
		//find the target 18
		TwoSum twoSum = new TwoSum();
		int[] positions = twoSum.twoSumHashTable(numbers, 18);
		
		System.out.println("Found two sum: " + positions[0] + ", " + positions[1]);
	}

}
