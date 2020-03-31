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
}
