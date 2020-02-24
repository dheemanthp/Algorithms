


class Solution {
    public int majorityElement(int[] nums) {
    
    //https://leetcode.com/problems/majority-element/
        
        //edge case
        if(nums == null || nums.length == 0) return 0;
        //edge case
        if(nums.length == 1) return nums[0];
        
        
        //Use HashMap
        HashMap<Integer,Integer> H = new HashMap<>();
        //iterate over , and either add it to map or return if it is more than n/2
        for(int num : nums) {
            //return here based N/2 condition
            if((H.get(num) != null) && (H.get(num) + 1 > (nums.length/2))) {
                return num;
            }
            //Add it to the HashMap
            H.put(num,H.getOrDefault(num,0) + 1);
        }
      return -1;  
    }        
}
