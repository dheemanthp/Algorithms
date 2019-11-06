//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Idea is in order traversal , and keep decrementing the count 
//once the count reaches zero return the node value.
class Solution {
    public static  int inorderTraversal(TreeNode root, int k) {
        
        Stack<TreeNode> S = new Stack<>();
        if(root == null) return 0;
        TreeNode curr = root;
        //ensure current is point to root
        while(!S.isEmpty() || curr!= null){
            //push all the left node elements to the stack 
            while(curr!= null){
                S.push(curr);//push always the current, this is pillar
                curr = curr.left;
            }
            
            //now pop the first element
            k--;
            curr = S.pop();
            if(k == 0) return curr.val;
            
            curr = curr.right;
        }
        return 0;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        return inorderTraversal(root,k);
    }
}
