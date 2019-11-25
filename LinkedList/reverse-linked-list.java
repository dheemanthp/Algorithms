//https://leetcode.com/problems/reverse-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode first = head;
        ListNode rest = first.next;
        ListNode root = reverseList(rest);
        if(rest == null) {
            //System.out.println("head is " + first.val + "root is null" + root);
            root = first;
        } else {
            rest.next = first;
            first.next = null;
        }
            return root;

    }
    
    public ListNode reverseListIterative(ListNode head) {
        //iteratively
        ListNode prev = null;
        ListNode pres = head;
        ListNode rest = null;
        
        while(pres != null) {
            rest = pres.next;
            pres.next = prev;
            prev = pres;
            pres = rest;
        }
        head = prev;
        return head;
    }
}
