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
     * Time O(N), Space O(1)
     * @param head - linked list first node
     * @return head with modified list
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy, curr = dummy;
        while(curr != null && curr.next != null) {
            ListNode temp = curr.next.next;
            curr.next.next = prev.next;
            prev.next = temp;
            
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

}
