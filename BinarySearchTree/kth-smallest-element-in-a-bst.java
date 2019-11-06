//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Idea is in order traversal , and keep decrementing the count 
//once the count reaches zero return the node value.
class Solution {
    public static  int inorderTraversal(TreeNode root, int k) {
        
        Stack<TreeNode> S = new Stack<>();
        if(root == null) return 0;
        TreeNode curr = root;
        //ensure current is point to root
        while(!S.isEmpty() || curr!= null){
            //push all the left node elements to the stack 
            while(curr!= null){
                S.push(curr);//push always the current, this is pillar
                curr = curr.left;
            }
            
            //now pop the first element
            k--;
            curr = S.pop();
            if(k == 0) return curr.val;
            
            curr = curr.right;
        }
        return 0;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        return inorderTraversal(root,k);
    }
}
/*


What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?

Insert and delete in a BST were discussed last week, the time complexity of these operations is O(H)\mathcal{O}(H)O(H), 
where HHH is a height of binary tree, and H=log⁡NH = \log NH=logN for the balanced tree.

Hence without any optimisation insert/delete + search of kth element has O(2H+k)\mathcal{O}(2H + k)O(2H+k) complexity. 
How to optimise that?

That's a design question, basically we're asked to implement a structure which contains a BST inside and optimises the 
following operations :

    Insert

    Delete

    Find kth smallest

Seems like a database description, isn't it? Let's use here the same logic as for LRU cache design, and combine an
indexing structure (we could keep BST here) with a double linked list.

Such a structure would provide:

    O(H)\mathcal{O}(H)O(H) time for the insert and delete.

    O(k)\mathcal{O}(k)O(k) for the search of kth smallest.

*/


