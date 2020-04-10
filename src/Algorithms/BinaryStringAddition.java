package Algorithms;

import DataStructures.LinkedList;
import DataStructures.ListNode;

/**
 * 
 * @apiSpec Given two binary strings, return the sum of them as a string
 * @author Darren Zhao Xie
 * @date Apr 9, 2020 Created
 *
 */
public class BinaryStringAddition {

    /**
     * Time O(Max(na, nb)), Space (1)
     * @param a - string representing a binary number
     * @param b - string representing a binary number
     * @return a string representing the sum of the 2 binary numbers
     */
    public String addBinary(String a, String b) {
        int place = 2; // binary
        int na = a.length(), nb = b.length();
        int carry = 0, digit = 0;
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<Math.max(na, nb); i++) {
            int da = i < na ? Character.getNumericValue(a.charAt(na - 1 - i)) : 0;
            int db = i < nb ? Character.getNumericValue(b.charAt(nb - 1 - i)) : 0;
            int sum = da + db + carry;
            digit = sum % place;
            carry = sum / place;
            str.append(digit);
        }
        if(carry > 0) str.append(carry);
        
        return str.reverse().toString();
    }
    
    /**
     * Add 2 numbers stored in 2 linked lists in reverse order.
     * @param l1
     * @param l2
     * @return the sum as a linked list in reverse order
     */
    public ListNode addLinkedListNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        int carry = 0;
        while(l1 != null || l2 != null) {
            int digit = ((l1 != null) ? l1.getVal() : 0) + ((l2 != null) ? l2.getVal() : 0) + carry;
            carry = digit / 10;
            curr.setNext(new ListNode(digit % 10));
            curr = curr.getNext();
            if(l1 != null) l1 = l1.getNext();
            if(l2 != null) l2 = l2.getNext();
        }
        if(carry > 0) curr.setNext(new ListNode(carry));
        return dummy.getNext();
    }
}
