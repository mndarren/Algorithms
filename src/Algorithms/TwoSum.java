package Algorithms;

import java.util.HashMap;

/**
 * @implSpec Given an array of integers, 
 * 		find two numbers such that they add up to a specific target number.
 * @author Darren Xie
 * @since 3/27/2020
 */
public class TwoSum {

	/**
	 * @apiNote HashTable: Time - O(N), Space - O(N)
	 * @param numbers
	 * @param target
	 * @return the index positions
	 */
	public int[] twoSumHashTable(int[] numbers, int target) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for(int i=0; i<numbers.length; i++) {
			int key1 = numbers[i];
			int key2 = target - numbers[i];
			if(h.containsKey(key2)) {
				return new int[] {h.get(key2)+1, i+1};
			}
			h.put(key1, i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
