// https://leetcode.com/problems/validate-binary-search-tree/submissions/
//https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Always remember:
//When you go left , current node will be max for it
//when you go right , current node will be min for it.


class Solution {
  public boolean helper(TreeNode node, Integer lower, Integer upper) {
      //if node is null return here
    if (node == null) return true;
    
    // now hold the value here
    int val = node.val;
      System.out.println("val " + val + "lower " + lower + " upper " + upper);
      //if current value is lesser than lower
    if (lower != null && val <= lower) return false;
      //if current value is greater than upper
    if (upper != null && val >= upper) return false;

    if(helper(node.right, val, upper) && helper(node.left, lower, val)) {
        return true;
    } else{
        return false;
    }
  }

  public boolean isValidBST(TreeNode root) {
      //helper function is important here
    return helper(root, null, null);
  }
}

/*
//WARNING: Below code will only work for some trees 
//Below code is wrong approach

class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null) {return true; }
        if(root.left == null && root.right == null) {
            return  true;
        }
        if(root.left != null && root.right == null) {
            if(root.left.val < root.val) {
                return  isValidBST(root.left);
            }
            return false;
        }
        if(root.left == null && root.right!= null) {
            if(root.val < root.right.val){
                return  isValidBST(root.right);
            }
            return false;
        }
        if(root.left.val < root.val && root.val < root.right.val){
            //pass the left subtree and the right sub tree
            return (isValidBST(root.left) && isValidBST(root.right));
        } else{
            return false;
        }
    }
}
*/
