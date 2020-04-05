package Algorithms;

import DataStructures.ListNode;

/**
 * 
 * @apiSpec Remove the Nth list from End
 * @author Darren Zhao Xie
 * @date Apr 5, 2020 Created
 *
 */
public class RemoveNthFromEnd {

	/**
	 * Time O(N) Space O(1). Two pointers
	 * @param head
	 * @param n - the nth item that should be deleted
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n <= 0) return head;
		
		int gap = n;
		ListNode prev = head, curr = head;
		while(curr != null) {
			if(gap >= 0) {
				gap--;
			} else {
				prev = prev.getNext();
			}
			curr = curr.getNext();
		}
		
		if(gap == 0) {
			head.setNext(head.getNext());
		} else {
			prev.setNext(prev.getNext().getNext());
		}
		
		return head;
	}
}
