


https://leetcode.com/problems/average-of-levels-in-binary-tree/
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
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return (new ArrayList<>());
        //BFS
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        List<Double> result = new ArrayList<>();
        
        while(Q.size() > 0) {
        int size = Q.size();
        Double avg = 0.0;
            for(int i = 0 ;i < size ; i++){
                TreeNode top = Q.poll();
                avg = avg + top.val;
                if(top.left !=null ) Q.offer(top.left);
                if(top.right !=null ) Q.offer(top.right);
            }
            result.add((double)avg/size);
        }
        return result;
    }
}
