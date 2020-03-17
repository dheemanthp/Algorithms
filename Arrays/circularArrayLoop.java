
//https://leetcode.com/problems/circular-array-loop/

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        
        //run through all index
        for(int i = 0 ;i < nums.length; i++) {
            int cycleLength  = 0;
            int startIndex = i;
            int movingIndex  =  Integer.MIN_VALUE;
            boolean forwardMovement = false , backwardMovement = false;
            
            //for each of the index , check for cycle
            while(startIndex != movingIndex && cycleLength <= nums.length){
                //set the movingIndex equal to startIndex for the first time only
                if(movingIndex == Integer.MIN_VALUE) {
                    movingIndex = startIndex;
                }
                //the values in the index decide if you need to move forward or backward
                if(nums[movingIndex] > 0) forwardMovement = true;    
                    else backwardMovement = true;
                //start moving
                movingIndex = movingIndex + (nums[movingIndex]%nums.length); 
                //Now we have new Moving Index
                //given that it is circular , use MOD operator
                if(movingIndex >= nums.length) movingIndex = movingIndex% nums.length;    
                //given that it is circular , ensure negative index value is converted to appropriate positive index
                if(movingIndex < 0) movingIndex = nums.length + movingIndex% nums.length; 
                //keep track of the cycle length
                cycleLength++;
                //going in two directions hence break out , as per question you should move only in one direction
                if(forwardMovement == true && backwardMovement == true) {
                    break;
                }
                //loop found
                if(startIndex == movingIndex && cycleLength > 1 && cycleLength <= nums.length) {
                    return true;
                }
            }
            
        }
        return false;
    }
}
