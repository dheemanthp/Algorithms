
https://leetcode.com/problems/jump-game/
//running time  O(n)

class Solution {
    public boolean canJump(int[] nums) {
        //Approach 4: Greedy
        /*
        Iterating right-to-left, for each position we check if there is a potential jump that reaches a GOOD index (currPosition + nums[currPosition] >= leftmostGoodIndex). If we can reach a GOOD index, then our position is itself GOOD. Also, this new GOOD position will be the new leftmost GOOD index. Iteration continues until the beginning of the array. If first position is a GOOD index then we can reach the last index from the first position.*/
        
        if(nums == null || nums.length == 0) return false;
        if(nums.length == 1) return true;
        int len = nums.length;
        int targetGoodIndex = len-1;
        //Time complexity : O(n). We are doing a single pass through the nums array,
        //hence nn steps, where nn is the length of array nums.
        //Space complexity : O(1). We are not using any extra memory.
        for(int i = len-2; i >= 0; i--) {
        //System.out.print(" the current value " + nums[i] + " and index is " + i + " total " + (nums[i]+i));
        //System.out.println(" the targetGoodIndex(index) is " + targetGoodIndex);

            if(nums[i]+i >= targetGoodIndex) {
                targetGoodIndex = i;
                //System.out.println("goodIndex changed to " + targetGoodIndex);
            } else {
                //System.out.println("goodIndex remains same");
            }
        }
        if(targetGoodIndex == 0) {
            return true;    
        } else {
            return false;
        }
     }
}    
    
    /*
    [2,0,0]
     the current value 0 and index is 1 total 1 the targetGoodIndex(index) is 2
    goodIndex remains same
    the current value 2 and index is 0 total 2 the targetGoodIndex(index) is 2
    goodIndex changed to 0

    */
    /*
    [2,3,1,1,4]
     the current value 1 and index is 3 total 4 the targetGoodIndex(index) is 4
    goodIndex changed to 3
    the current value 1 and index is 2 total 3 the targetGoodIndex(index) is 3
    goodIndex changed to 2
     the current value 3 and index is 1 total 4 the targetGoodIndex(index) is 2
    goodIndex changed to 1
    the current value 2 and index is 0 total 2 the targetGoodIndex(index) is 1
    goodIndex changed to 0
    
    */
