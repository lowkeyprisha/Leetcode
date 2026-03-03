/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return null;
        }
        
        ListNode c = a;
        ListNode d = b;
        
        while (c != d) {
            if (c == null) {
                c = b;
            } else {
                c = c.next;
            }
            
            if (d == null) {
                d = a;
            } else {
                d = d.next;
            }
        }
        
        return c;
    }
}