https://leetcode.com/problems/recover-binary-search-tree/

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
    public void recoverTree(TreeNode root) {
        
        if(root == null) return;
        
        //current solution is using inorder Traversal iteratively with STACK , SOLUTION IS O(N) for both space and time
        // we can also do this with inorder traversal without recursion and without stack using MORRIS TRAVERSAL
        https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
        //IDEA OF MORRIS TRAVERSAL IS SIMPLE , MAKE THE CURRENT NODE AS THE RIGHT CHILD OF THE INORDER PREDECESSOR
        //this is not intutive , hence going with stack solution
           
              


        
        //find the first element and the second element which is out of order and swap both
//How do we find these two elements? For example, we have the following tree that is printed as in order traversal:
//6, 3, 4, 5, 2
//We compare each node with its next one and we can find out that 6 is the first element to swap because 6 > 3
//and 2 is the second element to swap because 2 < 5.        
        
        TreeNode first = null;
        TreeNode second = null;
        TreeNode curr = root;
        TreeNode prev = null;
        Stack<TreeNode> S = new Stack<>();
        
        //keep push values on to the stack
        while(!S.isEmpty() || curr != null) {
            //keep pushing all the left elements to the stack
            while(curr != null) {
                //System.out.println(" push all values on the left" + curr.val);
                S.push(curr);
                curr = curr.left;
            }
            
            curr = S.pop();
            //System.out.println(" pop " + curr.val);
            if(first == null  && prev != null && prev.val >= curr.val) {
                    //ALWAYS UPDATE FIRST WITH THE GREATEST VALUE
                    first = prev;//FIRST IS UPDATED ONLY ONCE
                    //System.out.println(" first " + first.val);
            }
            if(first != null  && prev != null && prev.val >= curr.val) {
                    //KEEP UPDATING SECOND WITH THE LOWER VALUES
                    second = curr;//SECOND ALWAYS GET's UPDATED WITH THE LOWER VALUE
                    //System.out.println(" second " + second.val);
            }
            prev = curr;
            //System.out.println(" previous is  " + prev.val);
            if(curr != null) {
                curr = curr.right;
            }
        }    
            if(first != null && second != null) {
                int  element = first.val;
                first.val = second.val;
                second.val = element;
                return;
            }
        
        return;
        
    }
}
