Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of nodes in the tree.

Space Complexity: O(N)O(N).
   
//medium problem
//https://leetcode.com/problems/check-completeness-of-a-binary-tree/

/*
Use BFS to do a level order traversal,
add childrens to the bfs queue,
until we met the first empty node.
For a complete binary tree,
there should not be any node after we met an empty one.


*/
//keep pushing all nodes and popping until you encounter a null
//after this pop out all elements in queue , 
//and if it is complete binary then expectation is all elements in queue will be null.
//finally if queue is not empty that means it is not a complete binary tree
class Solution {
   public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            //System.out.println("the node value is " + node.val + "left is" + node.left + "right is" + node.right);
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
       //expectation is queue contains only nulls
        while (!bfs.isEmpty() && bfs.peek() == null){
            TreeNode node = bfs.poll();
            if(node != null) {
                //System.out.println("the node value is " + node.val);
            }
        }
            
        return bfs.isEmpty();
    }


//Alternative neat solution , with only one while loop
//keep adding all children until you encounter a null , use a flag to mark it
//now if you encounter any more valid nodes, that means it is not a complete binary tree

  private boolean isCompleteTreeAlternative(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) end = true;
            else{
                if(end) return false;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return true;
    }
}
