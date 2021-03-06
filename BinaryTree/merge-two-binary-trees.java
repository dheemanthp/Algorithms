https://leetcode.com/problems/merge-two-binary-trees/
//We can also do this using Stack

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if(t1 ==  null && t2 == null) return null;
        else if(t1 != null && t2 == null) return t1;
        else if(t1 == null  && t2 != null) return t2;
        TreeNode n = new TreeNode(t1.val + t2.val);
        n.left = mergeTrees(t1.left,t2.left);
        n.right = mergeTrees(t1.right,t2.right);
        return n;
    }
}
