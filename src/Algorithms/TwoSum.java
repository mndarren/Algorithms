package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	/**
	 * @apiNote Sort & Pointers: Time - O(N), Space - O(N)
	 * @param numbers
	 * @param target
	 * @return the index positions
	 */
	public int[] twoSumPointers(int[] numbersIn, int target) {
		int[] index = new int[2];
		int[] numbers = Arrays.copyOf(numbersIn, numbersIn.length);
		// Sorting O(NlogN)
		Arrays.sort(numbers);
		int lo = 0, hi = numbers.length - 1;
	    while (lo < hi) {
	        int sum = numbers[lo] + numbers[hi];
	        if (sum > target)       hi--;
	        else if (sum < target)  lo++;
	        else                    break;
	    }
	    // search index
	    for (int i = 0; i < numbers.length; i++) {
	    	if (numbersIn[i] == numbers[lo]) index[0] = i;
	    }
	    for (int i = 0; i < numbers.length; i++) {
	    	if (numbersIn[i] == numbers[hi] && i != index[0]) index[1] = i;
	    }
	    if (index.length == 2) return new int[] {index[0] + 1, index[1]+ 1};
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	/**
	 * @apiNote HashTable: Time - O(N), Space - O(N)
	 * @param numbers
	 * @param target
	 * @return the index positions
	 */
	public List<List<Integer>> twoSumMutiplePairs(int[] numbers, int target) {
		List<List<Integer>> listSet = new ArrayList<List<Integer>>();
		int n = numbers.length;
		if (n < 2) return listSet;
		
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < n; i++) {
			int key1 = numbers[i], key2 = target - numbers[i];
			
		}
		
	    if (listSet.size() > 0) return listSet;
	    throw new IllegalArgumentException("No two sum solution");
	}
}
