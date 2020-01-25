/*
DIAMETER OF A TREE IS THE LENGTH OF THE LONGEST PATH BETWEEN ANY TWO NODES IN A TREE
IT IS REPRESENTED BY THE EDGES BETWEEN THEM


This solution updates the max variable whenever the sum of left subtree and right subtree 
is greater than the previous max sum. The return statement only keep track of the height of a node. 
Brilliant solution!
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    //goal is to return the height of the tree
    //goal is also to compute the diameter with respect to every node
    public int helper(TreeNode root){
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        //System.out.println(root.val);
        //System.out.println("the left depth is " + left);
        //System.out.println("the right depth is " + right); 
        max = Math.max(max, left+right); //left edge + right edge
        //System.out.println("max is " + max); 
        //System.out.println("returning " + (Math.max(left, right) + 1)); 
        //track height of tree from a given node
        return (Math.max(left,right) + 1); //maximum height of a given node from the bottom
    }
    //Example:
    // we go to 4 , finally at 4 we do 2 things
    //calculate max , and also the height and return it
    //max will be 0
    //height 1 returned
    
    //we go to 5 , we do 2 things
    //calculate max , and also height and return it
    //max will be 0
    //height will be 1 returned
    
    // when we go to 2
    // we have l = 1 , and r = 1
    //max will be 2
    //height will be 2 returned 
    
    //we will now go to 3
    //we have l = 0 , and r = 0
    //max will be 2
    //height will be 1 returned
    
    //finally at 1
    //l = 2 , r = 1
    //max will be 3
    //height will be 3
        
        

}
