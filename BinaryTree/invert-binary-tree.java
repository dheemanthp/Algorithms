
//https://leetcode.com/problems/invert-binary-tree/

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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        //use a temp here, basically a swap
        TreeNode tempRight = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tempRight);
        return root;
    }
}

//Finally we can easly convert the above solution to BFS - or so called level order traversal.
class AlternativeSolution1 {
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}

//i wrote the understandable solution as well
class AlternativeSolution2 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        if(left != null && right != null){
            root.left = right;
            root.right = left;
        }else {
            if(left!= null){
                root.right = left;
                root.left = null;
            } else{
                root.right = null;
                root.left = right;
            }
        }
        return root;
    }
}
