
https://leetcode.com/problems/univalued-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//given that we visit each node only once it is O(n)
//top down approach , as we keep going down keep checking if the current node value is the same as parent
//ensure to go left and right at every step
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        //pass the root value
        return isUnivalTreeHelper(root,root.val);
        
    }
    public boolean isUnivalTreeHelper(TreeNode root, int value) {
        if(root == null) return true;
        //compare the current root value with it's parent value
        if(root.val == value) {
               //System.out.println(" the number of times we execute " + root.val);
               return isUnivalTreeHelper(root.left, root.val) &&
               isUnivalTreeHelper(root.right, root.val);                
            
        } else {
            return false;
        }            
    }
}
