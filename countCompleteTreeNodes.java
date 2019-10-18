/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 **/
/*
https://leetcode.com/problems/count-complete-tree-nodes/submissions/

This is a clean and smart solution, my understanding is as follows:

    A fully completed tree has node number: count = 2 ^ depth - 1
    for example: [1,2,3]
    depth is 2
    count = 2 ^ 2 - 1 = 3
    Compare left height and right height, if equal, use the formular, 
    otherwise recurvisely search left and right at next level
    The search pattern is very similar to binary search, the difference of heights 
    ethier exsits in left side, or right side
    Due to the reason stated in point 3, the time complexity is h ^ 2, there is h times 
    for each level, and h times for calculating height at each level

*/
class Solution {
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);//calculate left Depth
        int rightDepth = rightDepth(root);//calculate right Depth
        
        if(leftDepth == rightDepth) { //2 to the power of the depth -1 , gives the number of nodes
            return (1 << leftDepth) - 1; // if we already know the depth,then return count nodes
        }
        else {//if(root == null) return 0;
            return (countNodes(root.left)+1 +countNodes(root.right));
        }
    }
    
    //calculate left depth
    public int leftDepth(TreeNode root) {
        if(root == null) return 0;
        int dp = 0;
    while(root != null) {
        root = root.left;
        dp++;
    }
        return dp;
    }
    //calculate right depth
    public int rightDepth(TreeNode root) {
        if(root == null) return 0;
        int dp = 0;
    while(root!= null) {
        root = root.right;
        dp++;
    }
        return dp;
    }
}

/*
class Solution {
public int countNodes(TreeNode root) {

    int leftDepth = leftDepth(root);
	int rightDepth = rightDepth(root);

	if (leftDepth == rightDepth)
		return (1 << leftDepth) - 1;
	else
		return 1+countNodes(root.left) + countNodes(root.right);

}

private int rightDepth(TreeNode root) {
	// TODO Auto-generated method stub
	int dep = 0;
	while (root != null) {
		root = root.right;
		dep++;
	}
	return dep;
}

private int leftDepth(TreeNode root) {
	// TODO Auto-generated method stub
	int dep = 0;
	while (root != null) {
		root = root.left;
		dep++;
	}
	return dep;
}
}*/
