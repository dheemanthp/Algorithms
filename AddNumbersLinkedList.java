//There are 2 variants of this problems
//I have solved both below.
//https://leetcode.com/problems/add-two-numbers/submissions/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if( l1 == null) return l2;
        if( l2 == null) return l1;
        int carry = 0;
        //head is the first node
        //prev is the running pointer
        ListNode head = null;ListNode prev = null;
        while(l1 != null ||l2 != null || carry == 1){
            //if a node is null , just use 0
            int input1 = (l1 !=null) ?l1.val:0;  
            int input2 = (l2 !=null) ?l2.val:0;      
            //always store the reminder
            int val = (input1 + input2 + carry)%10;
            System.out.println("the value is : " + val);
            //always store the quotient
            carry = (input1 +input2 + carry)/10;
            //if head is null store the first node here
            if(head == null) {
                head = new ListNode(val);
                prev = head;
            //otherwise update the prev 
            } else {
                ListNode curr = new ListNode(val);
                prev.next = curr;
                prev = prev.next;
            }
            //move the pointer if we have not reached null
            if(l1 != null ) l1 = l1.next;
            if(l2 != null ) l2 = l2.next;
            
        }
        //return head
        return head;
    }
}
//================================================================================================

https://leetcode.com/problems/add-two-numbers-ii/submissions/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
               
        if( l1 == null) return l2;
        if( l2 == null) return l1;
        int carry = 0;
        //head is the first node
        //prev is the running pointer
        ListNode last = null;ListNode rest = null;
        
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();


        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        while(s1.size() != 0 ||s2.size() != 0 || carry == 1){
            //if a node is null , just use 0
            int input1 = (s1.size() != 0) ?s1.pop():0;  
            int input2 = (s2.size() != 0) ?s2.pop():0;  
            //always store the reminder
            int val = (input1 + input2 + carry)%10;
            System.out.println("the value is : " + val);
            //always store the quotient
            carry = (input1 +input2 + carry)/10;
            //if head is null store the first node here
            if(last == null) {
                last = new ListNode(val);
                //7 -> 8 -> 0 -> 7
            //otherwise update the prev 
            } else {
                //every new node added is pointing to previously added node
                rest = new ListNode(val);
                rest.next = last;
                last = rest;
            }
        }
        //return head
        return last;
    }
}
