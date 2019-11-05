//https://leetcode.com/problems/closest-binary-search-tree-value/submissions/

//This store the closest at every step, and goes either left or right.
//Hence running time is height of the tree : O(H)
class Solution {
  public int closestValue(TreeNode root, double target) {
      double closest = root.val;
      while(root!= null) {
          System.out.println(" current " + root.val);
          closest = (Math.abs(root.val-target) < Math.abs(closest-target))?(root.val):closest;
          root = (target < root.val)?root.left:root.right;
      }
      return (int)closest;
  }
}

//Iterative method by doing In order traversal
//worst case O(n)

class Solution {
    public int closestValue(TreeNode root, double target) {
        //do an inorder traversal and for each element compare the element 
        Stack<TreeNode> S = new Stack<>();
        TreeNode curr = root;
        //making the below as double made an input fail
        //[1500000000,1400000000]
        //-1500000000.0
        long previous = Long.MIN_VALUE;

        while(!S.isEmpty()|| curr!= null) {
            while(curr != null) {
                S.push(curr);
                curr = curr.left;
            }
            //Add the poped item in the array list
            curr = S.pop();
            //if target is between previous value and current value, then we can exit
            //we dont have to go over the entire tree
            
            if(previous <= target && target < curr.val) {
                //System.out.println("compare " + Math.abs(previous-target) + "and " + Math.abs(curr.val-target));
                return (Math.abs(previous-target) < Math.abs(curr.val-target) ?(int)previous:curr.val);
            }
            previous = curr.val;
            //System.out.println("prev " + (double)previous + "curr " + (double)curr.val);
            //if the poped item has a right child point to it , so that it will be added to stack
                curr = curr.right;
        }
        return (int)previous;
    }
}

/*
1push 4
1push 2
1push 1
pop1
pop2
2push 3
1push 3
pop3
pop4
2push 5
1push 5
pop5
*/
