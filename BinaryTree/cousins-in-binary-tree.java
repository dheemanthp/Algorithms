https://leetcode.com/problems/cousins-in-binary-tree/

//my solution
class Solution {
    //they should be at the same level
    //hence do a BFS
    public boolean isCousins(TreeNode root, int A, int B) {
        
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        //Check if the queue is empty or not
        while(!Q.isEmpty()) {
            int size = Q.size();
            boolean Aexist = false;
            boolean Bexist = false;
            for(int i = 0; i < size; i++) {
                TreeNode top = Q.poll();
                if(top.val == A) { Aexist = true; }
                if(top.val == B) { Bexist = true; }
                //if the value is present in the left and right subchild then they belong to same parent
                //if the value is present in the right and left subchild then they belong to same parent
                //return false in this case
                if(top.left != null  && top.right != null) { //check both are not null
                    if((top.left.val == A && top.right.val == B) || //check the values
                    (top.right.val == A && top.left.val == B)) {
                        return false;
                    }
                }
                //add the values in the queue
                if(top.left != null) Q.offer(top.left);
                if(top.right != null) Q.offer(top.right);
            }
            
            if(Aexist && Bexist) {
                return true;
            }
        }
        return false;
    }
}


class Solution {
public boolean isCousins(TreeNode root, int A, int B) {
    if (root == null) return false;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		boolean isAexist = false;		
		boolean isBexist = false;		
		for (int i = 0; i < size; i++) {
			TreeNode cur = queue.poll();
            if (cur.val == A) isAexist = true;
            if (cur.val == B) isBexist = true;
			if (cur.left != null && cur.right != null) { 
				if (cur.left.val == A && cur.right.val == B) { 
					return false;
				}
				if (cur.left.val == B && cur.right.val == A) { 
					return false;
				}
			}
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
		if (isAexist && isBexist)  return true;
	}
	return false;
}
}
