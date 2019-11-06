
//https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> S = new Stack<>();
        List<Integer> L = new LinkedList<>();
        if(root == null) return L;
        TreeNode curr = root;
        //ensure current is point to root
        while(!S.isEmpty() || curr!= null){
            //push all the left node elements to the stack 
            while(curr!= null){
                S.push(curr);//push always the current, this is pillar
                curr = curr.left;
            }
            //now pop the first element
            curr = S.pop();
            L.add(curr.val);
            curr = curr.right;
        }
        return L;
    }
}
                                       //7
                               //5                12
                         //3           6   //8            14
                              //4
                                  
