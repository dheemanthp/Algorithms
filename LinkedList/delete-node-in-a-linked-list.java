https://leetcode.com/problems/delete-node-in-a-linked-list/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //what if this is the last node?
        //what if this is the first node?
        if(node.next == null) {
            //we may have to track this node
            //tell this to the interviewer
        }
        
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
