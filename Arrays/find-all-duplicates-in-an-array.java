
https://leetcode.com/problems/find-all-duplicates-in-an-array/
//idea is very simple
flip all the index corresponding to the value to negative .
Now while traversing you already find the value is negative , it shows it is a duplicate

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> result = new LinkedList<>();
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[Math.abs(nums[i])-1] < 0) {
                //if already negative that means it is a duplicate
                result.add(Math.abs(nums[i]));
            } else{
                //if not negative , then make it negative
               nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }   
        }
        return result;
    }
}
