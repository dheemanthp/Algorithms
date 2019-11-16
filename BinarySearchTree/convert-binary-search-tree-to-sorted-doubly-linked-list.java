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
    
    
    //making below static fails in leetcode
    //but individually testing it will work.
    //so leetcode does not like static memebers while doing multiple tests.
    public  Node prev = null;
    public  Node head = null;
    

    public void helper(Node root) {
        if(root != null) {
            helper(root.left);
            if(prev == null) {
                head = root;
            } else {
                prev.right = root;
                root.left = prev;

            }
            prev = root;
            helper(root.right);
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
