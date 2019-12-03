
//https://leetcode.com/problems/remove-linked-list-elements/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head  == null) return null;
    //Always first element , last element , and middle element

        //if the value is at the beginning
        while (head != null && head.val == val){
            head = head.next;
            
        }
        //middle and end elements
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if(curr.next.val == val) {
                curr.next = curr.next.next;
            } else{
                curr =  curr.next;
            }
        }
        return head;
        
        
        /* using Previous pointer 
        //now the value could be in the middle and the end
        ListNode prevNode = head;
        ListNode curr = (head != null)?head.next:null;
        while(curr != null) {
            
            if(curr.val == val){
                System.out.println(" the curr value is equal to target " + curr.val);
                prevNode.next = curr.next;          
                curr = curr.next;
            } else{
                System.out.println(" the curr value is " + curr.val);
                prevNode = curr;          
                curr = curr.next;
            }
        }*/
        //return head;
    }
}
