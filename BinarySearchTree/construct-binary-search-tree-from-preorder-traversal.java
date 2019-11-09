//Construct Binary Search Tree from Preorder Traversal
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

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
    public TreeNode bstFromPreorder(int[] preorder) {
        //stack helps in tracking elements
        Stack<TreeNode> S = new Stack<>();
        //push the root
        TreeNode root = new TreeNode(preorder[0]);
        S.push(root);
        TreeNode top = null;
        for (int i = 1 ;i < preorder.length ; i++){
            
            top = S.peek();//top of the stack
            //compare with top of the stack always
            while(!S.isEmpty() && preorder[i] > S.peek().val) {
                //store the poped out element
                //next element will go the right of the poped out element
                top = S.pop();//THIS IS THE IMPORTANT ASPECT
                
            }
            //now add the item to the left or to the right
            if(preorder[i] < top.val) {
                top.left = new TreeNode(preorder[i]);
                S.push(top.left);
            } else {
                top.right = new TreeNode(preorder[i]);
                S.push(top.right);
            }
        }
        
        return root;
    }
}

/*
//another very similar approach
//https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/
class Solution2ndApproach {
    public TreeNode bstFromPreorder(int[] preorder) {
        //stack helps in tracking elements
        Stack<TreeNode> S = new Stack<>();
        //push the root
        TreeNode root = new TreeNode(preorder[0]);
        S.push(root);

        for (int i = 1 ;i < preorder.length ; i++){
        TreeNode lastPopedElement = null;

            //if the current elment is greater than the top of the stack remove it
            while(!S.isEmpty() && preorder[i] > S.peek().val) {
                lastPopedElement = S.pop();//this is the KEY , it will store the last element poped out
                
            }
            // if there is no poped out element , we need to push to the left of the top of the stack
            if(lastPopedElement == null) {
                lastPopedElement = S.peek();
                lastPopedElement.left = new TreeNode(preorder[i]);
                S.push(lastPopedElement.left);                
            //if there is a poped out elment , this means we need to push to the right of the poped out element
            } else {
                lastPopedElement.right = new TreeNode(preorder[i]);
                S.push(lastPopedElement.right);
            }
        }
        return root;
    }
}*/
