https://leetcode.com/problems/subtree-of-another-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Logic is to call the isSameTree again and again by going left and right in the main tree
//since it is binary tree running time is O(n*n)


class Solution {
    
//Time complexity for method isSameTree: O(N), where N is a number of nodes in the tree, since one visits each node exactly once.

//Space complexity for method isSameTree: O(log(N)) in the best case of completely balanced tree and O(N)
//in the worst case of completely unbalanced tree, to keep a recursion stack
    
        public static boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        if(p.val == q.val) {
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right); 
        } else {
            return false;
        }
    }
    
    //apply subtree by either going left or right
    //hence final rinning time is O(N*N)
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if (isSameTree(s, t)) return true;
        if(s!= null && t!= null) {
            return(isSubtree(s.left,t) ||
               isSubtree(s.right,t));
        } else {
            return false;
        }
    }
}
