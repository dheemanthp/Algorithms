
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Approach 1
//Do a DFS , keep adding the values in the Hashset until you find K-root.val in the Hashset
//Running O(n)
//space complexity O(n)
class Solution1 {
    
    HashSet<Integer> S = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        
        if(root == null) return false;
        //System.out.println(" Set contains " + S);
        if(S.contains(k- root.val)) {
            //System.out.println("The pair is [" + root.val + "," + (k-root.val) + "]");
            return true;
        } else {
            S.add(root.val);
            return (findTarget(root.left,k) || findTarget(root.right,k));
        }
            
    }
}

//Approach 2
//Do an inorder traversal , and populate the List
//run through the list , using 2 pointers
//Running O(n)
//space complexity O(n)

//7:13PM
class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
    
        List<Integer> LL = new ArrayList<>();
        inorder(LL,root);
        int left = 0;
        int right = LL.size() -1;
        while (left < right) {
            if(LL.get(left) + LL.get(right) == k) {
                return true;
            } else if (LL.get(left) + LL.get(right) > k) {
                right--;
            } else  {
                left ++;
            }
        
        }
        return false;
    }
    
    
    public void inorder(List<Integer> List, TreeNode root) {
        
        if(root == null) return;
        inorder(List,root.left);
        List.add(root.val);
        inorder(List,root.right);
    }
    

    
}

