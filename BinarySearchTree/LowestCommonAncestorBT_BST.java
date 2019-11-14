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
//LCA in O(n) time
//The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node
// in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/submissions/

    public static TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        
        //base case
        if(root == null) return null;
        //if the root value matches either p or q , return root
        // If either n1 or n2 matches with root's key, report 
        // the presence by returning root (Note that if a key is 
        // ancestor of other, then the ancestor key becomes LCA 
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
       // If both of the above calls return Non-NULL, then one key 
       // is present in once subtree and other is present in other, 
       // So this node is the LCA 
        if(left != null && right != null) return root;
        if(left == null && right == null) return null;
        return ((left != null) ? left : right);
    }

BINARY SEARCH TREE:
====================
//Time complexity of this solution is O(h) where h is height of tree.
//Iterative
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return  null;
        
        while(root != null) {
            System.out.println(" the value is" + root.val);
            if(root.val > p.val && root.val > q.val) root = root.left;
            else if(root.val < p.val && root.val < q.val) root = root.right;
            else break;
        }
        return root;
    }
}    
BINARY SEARCH TREE:
====================
    
//Time complexity of this solution is O(h) where h is height of tree.
//Also, the above solution requires O(h) extra space in function call stack for recursive function calls.      
    public static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return  null;
        else if(root.val > p.val && root.val > q.val ) return(lowestCommonAncestor(root.left,p,q));
        else if(root.val < p.val && root.val < q.val ) return(lowestCommonAncestor(root.right,p,q));
        else return root;
    }
    
}
