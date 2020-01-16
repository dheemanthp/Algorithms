
https://leetcode.com/problems/convert-bst-to-greater-tree/

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
    public TreeNode convertBST(TreeNode root) {
        //in order to retain the sum value accross function calls , use an array
        //go extreme right , and start storing the values as part of sum
        int[] sum = new int[1];
        helper(root,sum);
        return root;
    }
    
    public void helper(TreeNode root,int[] sum) {
        //root is null
        if(root == null) return;
        //move the right always
        helper(root.right, sum);
        //move to the extreme right , and start updating sum
        sum[0] = sum[0] + root.val;
        //System.out.print("sum is " + sum[0]);
        //System.out.println(" , the root.val is" + root.val);
        //start updating root.val
        root.val = sum[0];
        //now go to the left
        helper(root.left,sum);
    }
}
