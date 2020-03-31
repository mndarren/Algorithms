package Algorithms;

/**
 * 
 * @apiSpec Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * @author Darren Zhao Xie
 * @date Mar 30, 2020 Created
 *
 */
public class LongestSubstring {

	// 3 pointers: Time - O(N), Space - O(1), 2 distinct chars
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int n = s.length();
		int start = 0, last = -1, max = 0;
		for (int curr = 1; curr < n; curr++) {
			if (s.charAt(curr) != s.charAt(curr - 1)) {
				if (last >= 0 && s.charAt(curr) != s.charAt(last)) {
					max = Math.max(max, curr - start);
					start = last + 1;
				}
				last = curr - 1;
			}
		}
		return Math.max(n-start, max);
	}
}
