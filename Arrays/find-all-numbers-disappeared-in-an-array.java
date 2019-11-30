//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    /*
    The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1]. In this way all the numbers that we have seen will be marked as negative. In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, so just add it to the return list.
    */

    List<Integer> result = new ArrayList<>();    
    //idea is simple  , mark the index of the number seen
    for(int i = 0; i< nums.length ; i++) {
           
            //in order to ensure we handle duplicates , and not access the 
            //negative elements
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

    
    for(int j = 0; j< nums.length ; j++) {
        if(nums[j] > 0) {
            result.add(j+1);
        }
    }
    return result;
    }
}
