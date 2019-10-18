https://leetcode.com/problems/binary-search-tree-iterator/
//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//Calling next() will return the next smallest number in the BST.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Approach is inorder , and use a stack to store o(h) elements in the stack

class BSTIterator {
   private static Stack<TreeNode> S = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        //base case root is null
        if(root == null) return;
        //points to the current
        TreeNode cur = root;
        //push the root
        S.push(cur);
 
        //if root has more children on the left , keep pushing them to stack 
        while (cur.left != null) {
            cur = cur.left;
            S.push(cur);
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        //store result
        TreeNode result = null;
        //check if stack is empty
        if(!S.empty()) {
        //pop the element and store it as part of result
        result = S.pop(); //pop out the value
        }
        //if result is null , return 0
        if(result == null) return 0;
        //now store the poped out element
        TreeNode cur = result;
        //check if it has right node, push only one right node
        if(cur.right != null) { //push right , this is an if condition 
           //push the right element 
           cur = cur.right;
           S.push(cur); 
            while(cur.left != null) { //push all left elements to stack
            cur = cur.left;
            S.push(cur);
            }
        }
        return result.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        if(!S.empty()) {
            return true;
        }
        else {
            return false;
        }
        
        //return false;
    }
}

