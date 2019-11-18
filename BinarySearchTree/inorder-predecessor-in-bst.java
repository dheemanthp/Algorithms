
https://leetcode.com/problems/inorder-predecessor-in-bst/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Amazing Solution , iterative without stack
class Solution {
public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
         TreeNode ret = null;
        while (root != null) {
            if (root.val >= p.val) {
                root = root.left;
            } else {
                ret = root;
                root = root.right;
            }
        }
        return ret;
}
}

//Normal inorder ,Uses Stack, and stop when the previous element is equal to p.val
//Inorder Predecessor in BST
class Solution {
  public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
    // the successor is somewhere lower in the right subtree
    // successor: one step right and then left till you can
    if (p.right != null) {
      p = p.right;
      while (p.left != null) p = p.left;
      return p;
    }

    // the successor is somewhere upper in the tree
    Stack<TreeNode> stack = new Stack<>();
    int inorder = Integer.MIN_VALUE;

    // inorder traversal : left -> node -> right
    while (!stack.isEmpty() || root != null) {
      // 1. go left till you can
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      // 2. all logic around the node
      root = stack.pop();
      // if the previous node was equal to p
      // then the current node is its successor
      if (root.val == p.val) return inorder;
      inorder = root.val;

      // 3. go one step right
      root = root.right;
    }

    // there is no successor
    return null;
  }
}
