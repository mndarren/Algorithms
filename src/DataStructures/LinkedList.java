package DataStructures;

public class LinkedList {

	private ListNode head;
	public void add(int val) {
		if (getHead() == null) {
			setHead(new ListNode(val));
			return;
		}
		
		ListNode temp = getHead();
		while (temp.getNext() != null) temp = temp.getNext();
		temp.setNext(new ListNode(val));
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
