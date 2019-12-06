
//https://leetcode.com/problems/find-leaves-of-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



//height of a tree with one node is zero
//height of a tree with two node is one , and so on
//trick is to get the height of the tree

class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        int h = height(root,res);
        System.out.println(" the height is " + h);
        return res;
    }
   
    private int height(TreeNode root, List<List<Integer>> res){
        if(root == null) return -1; //there is no tree
        int level  = Math.max(1 + height(root.left,res),1 + height(root.right,res));//height of every root
        System.out.println(" the root is " + root.val + " and level is " +  level);
        // the number if arrays should be equal to level + 1
        if(res.size() < level + 1 ) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        //Below line can be added if we need to cut the tree (ask the interviewer)
        //root.left = root.right = null;
        return level;
    }

}

/*
 Input : [1,2,3,4,5]
 the node is 4 and level is 0
 the node is 5 and level is 0
 the node is 2 and level is 1
 the node is 3 and level is 0
 the node is 1 and level is 2
 the height is 2
 output : [[4,5,3],[2],[1]]
*/
