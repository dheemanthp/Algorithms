https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    //idea is simple
    //do an inorder traversal
    //
    
    
    //making below static fails in leetcode
    //but individually testing it will work.
    //so leetcode does not like static memebers while doing multiple tests.
    public  Node prev = null; //prev is retained across multiple calls
    public  Node head = null; //head is retained across multiple calls
    
    //inorder
    public void helper(Node root) {
        if(root != null) {
            helper(root.left); //go left
            if(prev == null) {
                head = root; //make the head point to the left most node
            } else {
                prev.right = root; //make sure previous points to current
                root.left = prev; // current points to prev

            }
            prev = root;//keep updating previous to the current
            helper(root.right);//go right
        }
    }
    
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        prev.right = head;
        head.left = prev;
        return head;
     }
}
