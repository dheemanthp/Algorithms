/*Complexity Analysis

    Time complexity : O(N)\mathcal{O}(N)O(N) in the worst case when the tree is BST or the "bad" element is a rightmost leaf.

    Space complexity : O(N)\mathcal{O}(N)O(N) to keep stack.
*/


//In order Traversal
class Solution {
  public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack();
    double previous = - Double.MAX_VALUE;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      // If next element in inorder traversal
      // is smaller than the previous one
      // that's not BST.
      if (root.val <= previous) return false;
      previous = root.val;
      root = root.right;
    }
    return true;
  }
}




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

class SolutionRecursion {
  public boolean helper(TreeNode node, Integer min, Integer max) {
      //if node is null return here
    if (node == null) return true;
    
    // now hold the value here
    int curr = node.val;
      System.out.println("curr " + curr + "min " + min + " max " + max);
      //if current value is lesser than lower
    if (min != null && curr <= min) return false;
      //if current value is greater than max
    if (max != null && curr >= max) return false;

    if( helper(node.left, min, curr) && helper(node.right, curr, max) ) {
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
