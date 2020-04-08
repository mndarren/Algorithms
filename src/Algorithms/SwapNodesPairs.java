package Algorithms;

import DataStructures.ListNode;

/**
 * 
 * @apiSpec Given a linked list, swap every two adjacent nodes and return its head
 * @author Darren Zhao Xie
 * @date Apr 7, 2020 Created
 *
 */
public class SwapNodesPairs {
    
    /**
     * Time O(N), Space O(1) [pointer vs object]
     * @param head - linked list first node
     * @return head with modified list
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.setNext(head);
        
        ListNode prev = dummy, curr = head;
        while(curr != null && curr.getNext() != null) {
            ListNode temp = curr.getNext().getNext();
            curr.getNext().setNext(prev.getNext());
            prev.setNext(curr.getNext());
            curr.setNext(temp);
            
            prev = curr;
            curr = curr.getNext();
        }
        return dummy.getNext();
    }

}
