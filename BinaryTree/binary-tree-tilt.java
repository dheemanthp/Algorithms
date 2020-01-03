
https://leetcode.com/problems/binary-tree-tilt/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
/*
From the problem statement, it is clear that we need to find the tilt value at every 
node of the given tree and add up all the tilt values to obtain the final result. 
To find the tilt value at any node, we need to subtract the sum of all the nodes in 
its left subtree and the sum of all the nodes in its right subtree.

Thus, to find the solution, we make use of a recursive function traverse which when 
called from any node, returns the sum of the nodes below the current node including itself. 
With the help of such sum values for the right and left subchild of any node, 
we can directly obtain the tilt value corresponding to that node.
*/


*/
public class Solution {
    //result is global
    int result = 0;
    
    public int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }
    
    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        //at every step calculate the tilt of every node, (left - right)
        result += Math.abs(left - right);
            if(root != null){
            System.out.print("the root value is " + root.val + " left is " +left + " right is "+ right);
            System.out.println("the result is  " + result);
        }

        //total sum of the child tree + current node
        return left + right + root.val;
    }
}

/*
//[1,2,3,5,6]
the root value is 5 left is 0 right is 0the result is  0
the root value is 6 left is 0 right is 0the result is  0
the root value is 2 left is 5 right is 6the result is  1
the root value is 3 left is 0 right is 0the result is  1
the root value is 1 left is 13 right is 3the result is  11
*/


https://leetcode.com/problems/univalued-binary-tree/
