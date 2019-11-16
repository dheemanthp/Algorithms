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
class Solution {
    
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
