//https://leetcode.com/problems/palindrome-linked-list/
push 2nd half of elements to stack

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
public boolean isPalindrome(ListNode head) {
    
    //https://leetcode.com/problems/palindrome-linked-list/
       //slow pointer , fast pointer technique
        ListNode slow = head;
        ListNode fast = head;
        boolean odd = false;
    
    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        
    }
    
    //now push second 1/2 of elements to stack to compare
    Stack<ListNode> S = new Stack();
    while (slow != null) {
        System.out.println(" pushing the slow value is " + slow.val);
        S.push(slow);
        slow = slow.next;
    }
    while(!S.empty()) {
        ListNode top = S.pop();
        System.out.println(" the top value is " + top.val);
        if(head.val != top.val) {
            return false;
        }
        head = head.next;
    }
    return true;    
    }    
}
