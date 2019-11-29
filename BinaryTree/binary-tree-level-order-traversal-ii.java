

https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        if(root == null) return (new ArrayList<>());
        //BFS
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        while(Q.size() > 0) {
        int size = Q.size();
        List<Integer> level = new ArrayList<>();
            for(int i = 0 ;i < size ; i++){
                TreeNode top = Q.poll();
                level.add(top.val);
                if(top.left !=null ) Q.offer(top.left);
                if(top.right !=null ) Q.offer(top.right);
            }
            result.add(0,level);
        }
        return result;
    }
}
