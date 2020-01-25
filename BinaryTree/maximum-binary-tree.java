https://leetcode.com/problems/maximum-binary-tree/


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
    //Logic is simple
    //pass start and end index to the function, go over start to end , and finally check for Max value and its CurrMaxindex
    //now with that create a root 
    //now pass the start till currMaxIndex
    //now pass the currMaxIndex+1 till end
    //Running time is O(N)^2
    //Reason being we need to find the max value in every subgroup
    //worst case will be O(N)^2
    
    
        public static TreeNode constructMaximumBinaryTree(int[] nums) {
        //Base case //return null if the length is less than or equal to 0
		if (nums.length <= 0) {
			return null;
		}
        //pass the array , start  then length
		return construct(nums, 0, nums.length);
	}

	private static TreeNode construct(int[] nums, int start, int end) {
        
        System.out.print(" the start " + start);
        System.out.print(" the end " + end);
        
        //if start is greater than or equal to end , return null
		if (start >= end) {
            System.out.println(" return back as start is equal to end");
			return null;
		}

        
        //FIND max in the given subgroup
        int currMaxIndex = start;
        int NextMaxIndex = start + 1;
        //loop through the sub-array until you find the max
		while (NextMaxIndex < end) {
            //compare as you go forward
			if (nums[currMaxIndex] < nums[NextMaxIndex]) {
				currMaxIndex = NextMaxIndex;
			}
			NextMaxIndex++;
		}
        System.out.println(" the currMaxIndex " + currMaxIndex);
        
        
        
        //finally create a root out of the nums[currMaxIndex]
		TreeNode root = new TreeNode(nums[currMaxIndex]);
        //go to the left , and go to the right
        //start to currMaxIndex
		root.left = construct(nums, start, currMaxIndex);
        //currMaxIndex +1 till the end
		root.right = construct(nums, currMaxIndex + 1, end);
		return root;
	}
}
