
https://leetcode.com/problems/leaf-similar-trees/

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //Let us have 2 arrayLists
        ArrayList<Integer> A1 = new ArrayList<>();
        ArrayList<Integer> A2 = new ArrayList<>();
        helper(root1, A1);
        System.out.println();
        helper(root2, A2);
        System.out.println();
        System.out.println("The size of A1 is " + A1.size());
        System.out.println("The size of A2 is " + A2.size());
        //we have equal number of leaf values stored and also their sequence is the same
        if(A1.size() == A2.size()) {
            for(int i = 0 ; i < A1.size(); i++) {
                System.out.print(" A1 contains " + A1.get(i) + " ");
                System.out.println(" A2 contains " + A2.get(i));
                if(A1.get(i) != A2.get(i)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
    
    //post order
    public void helper(TreeNode root, ArrayList<Integer> A) {
        if(root == null) return;
        helper(root.left,A);
        helper(root.right,A);
        if(root.left == null && root.right == null){
            System.out.print(" " + root.val);
            A.add(root.val);
            return;
        }
    }
}
