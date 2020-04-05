package Algorithms;

import DataStructures.LinkedList;
import DataStructures.ListNode;

public class CheckPalindrome {
	// Time - O(N), Space - O(1)
	public Boolean isPalindrome(ListNode head) {
		if (head == null) return true;
		
		// Don't change the original list
		ListNode back = new ListNode(head.getVal());
		ListNode t = head, m = back;
		while (t.getNext() != null) {
			t = t.getNext();
			m.setNext(new ListNode(t.getVal()));
			m = m.getNext();
		}
		
		// Find the list center
		ListNode slow = back, fast = back;
		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		// Reverse the 2nd half (inline this way works)
//		fast = slow.getNext();
//		while(fast != null && fast.getNext() != null) {
//			ListNode temp = fast.getNext().getNext();
//			fast.getNext().setNext(slow.getNext());
//			slow.setNext(fast.getNext());
//			fast.setNext(temp);
//		}
		slow.setNext(new LinkedList().reverseList(slow.getNext()));
		// compare 2 list (start from head and slow.next
		while (slow.getNext() != null) {
			slow = slow.getNext();
			if (back.getVal() != slow.getVal()) {
				return false;
			}
			back = back.getNext();
		}
		return true;
	}
	
	/**
	 * Check if an integer is a Palindrome
	 * @param x
	 * @return Boolean
	 */
	public Boolean isPalintrome(int x) {
		if (x < 0) return false;
		int num = x, val = 0;
		while (num != 0) {
			val = val * 10 + num %10;
			num /= 10;
		}
		if (val == x) return true;
		return false;
	}
	
	/**
	 * Check if an String is a Palindrome
	 * @param x
	 * @return Boolean
	 */
	public Boolean isPalintrome(String x) {
		int l = 0, r = x.length() - 1;
		while (l < r) {
			while (l < r && !Character.isLetterOrDigit(x.charAt(l))) l++;
			while (l < r && !Character.isLetterOrDigit(x.charAt(r))) r--;
			if (x.charAt(l) != x.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
	
	/**
	 * Find the longest Palindrome substring. Time O(n^2) Space O(1)
	 * @param s
	 * @return String
	 */
	public String longestPalindrome(String s) {
		int begin = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandCheck(s, i, i);
			int len2 = expandCheck(s, i, i+1);
			int len = Math.max(len1, len2);
			if (len > end - begin) {
				begin = i - (len-1)/2;
				end = i + len/2 +1;
			}
		}
		return s.substring(begin, end);
	}

	// Tool for finding longest Palindrome
	private int expandCheck(String s, int left, int right) {
		int L = left, R = right;
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R-1 - (L+1) +1; 
	}
}
