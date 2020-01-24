
https://leetcode.com/problems/balanced-binary-tree/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


//This problem is generally believed to have two solutions: the top down approach and the bottom up way.

//1)
//1.The first method checks whether the tree is balanced strictly according to the definition of balanced binary tree: the //difference between the heights of the two sub trees are not bigger than 1, and both the left sub tree and right sub tree are //also balanced. With the helper function depth(), we could easily write the code;

//1) call depth function on each node
//For the current node root, calling depth() for its left and right children actually has to access all of its children, thus //the complexity is O(N). 
//We do this for each node in the tree, so the overall complexity of isBalanced will be O(N^2). 
//This is a top down approach.


//2.The second method is based on DFS. Instead of calling depth() explicitly for each child node, we return the height of the //current node in DFS recursion. When the sub tree of the current node (inclusive) is balanced, the function dfsHeight() returns a non-negative value as the height. Otherwise -1 is returned. According to the leftHeight and rightHeight of the two children, the parent node could check if the sub tree is balanced, and decides its return value.
//In this bottom up approach, each node in the tree only need to be accessed once. Thus the time complexity is O(N), better //than the first solution.

//O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(helper(root) != -1) return true;
        else return false;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        if(left == -1) return -1;
        int right = helper(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
