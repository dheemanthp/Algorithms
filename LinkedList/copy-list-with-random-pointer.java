
//https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        
        //modify the existing LL by creating a new copy
        Node first = head;
        Node second = null;
        while(first != null) {
            Node temp = first.next;
            second = new Node(first.val);
            first.next = second;
            second.next = temp;
            first = first .next.next;
        }
        //now assign the random pointer
        first = head;
        while(first != null) {
            second = first.next;
            if(first.random != null) {
                second.random = first.random.next;
            }
           first = first.next.next; 
        }
        
        first = head;
        while(first != null) {
            System.out.print(first.val + "->");
            first = first.next;
        }       
        System.out.println();
    
        
        //finally decouple the two LL's
        first = head;
        Node newHead = null;
        if(first != null) {
        newHead = first.next;
        } else {
            return newHead;
        }
        second  = null;
        while(first != null) {
            //1->1'->2->2'->3->3'
            second = first.next;//hold second
            
            //1st LL
            first.next = second.next;//work on first
            first = first.next;
            
            //2nd LL
            if(first != null) {
                second.next = first.next;//work on second
            }
            
        }
        //return the new head here
        first = newHead;
        while(first != null) {
            System.out.print(first.val + "->");
            first = first.next;
        }       
        return newHead;
    }
}
