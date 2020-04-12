


https://leetcode.com/problems/find-largest-value-in-each-tree-row/
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
    //start at 12:54 AM
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null) return output;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.add(root);
        
        //the queue will contain every row , added the first row
        while(!Q.isEmpty()) {
            
            int size = Q.size();
            int max = Integer.MIN_VALUE;
            while(size > 0) {
                TreeNode pres = Q.poll();
                max = Math.max(pres.val,max); //for every level
                if(pres.left != null) Q.add(pres.left);
                if(pres.right != null) Q.add(pres.right);
                size--;
            }
            output.add(max);
        }
        return output;
    }
}
//completed at 1:03 AM
