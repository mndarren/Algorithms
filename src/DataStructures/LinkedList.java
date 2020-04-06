package DataStructures;

public class LinkedList {

	private ListNode head;
	
	// Add a value
	public void add(int val) {
		if (getHead() == null) {
			setHead(new ListNode(val));
			return;
		}
		
		ListNode temp = getHead();
		while (temp.getNext() != null) temp = temp.getNext();
		temp.setNext(new ListNode(val));
	}
	
	// Remove a value
	public void remove(int val) {
		ListNode tmp = head, prev = head;
		int gap = 1;
		while(tmp.getNext() != null && tmp.getVal() != val) {
			tmp = tmp.getNext();
			if(gap > 0) {
				gap--;
			} else {
				prev = prev.getNext();
			}
		}
		if(gap > 0) {
			setHead(head.getNext());
		} else {
			prev.setNext(prev.getNext().getNext());
		}
	}
	
	// iteratively reverse a List
	public ListNode reverseList(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.setNext(head);
		
		ListNode prev = dummy, curr = head;
		while (curr != null && curr.getNext() != null) {
			ListNode nd = curr.getNext().getNext();
			curr.getNext().setNext(prev.getNext());
			prev.setNext(curr.getNext());
			curr.setNext(nd);
		}
		return dummy.getNext();
	}
	
	public ListNode getHead() {
		return head;
	}
	public void setHead(ListNode head) {
		this.head = head;
	}
	public void traverseItems() {
		ListNode l = head;
		while (l != null) {
			System.out.print(" " + l.getVal());
			l = l.getNext();
		}
	}
}
