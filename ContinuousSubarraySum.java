//For every element you encounter do a modulous of K and add it to the running sum , it is exactly like doing modulous on the total
//now put all the running sum and their corresponding indexes , in a map
//but do also check if the current running sum was encountered earlier 
//if it was encountered ealier , then check if the index stored earlier , and the current index is greater than 1, which means atleast 2 elements
//O(n) solution

//We iterate through the input array exactly once, keeping track of the running sum mod k of the elements in the process. If we find that a running sum value at index j has //been previously seen before in some earlier index i in the array, then we know that the sub-array (i,j] contains a desired sum.


class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //create a map , and put (0,-1)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
        int runningSum = 0;
        //go over every element
        for (int i=0;i<nums.length;i++) {
            //running sum is running sum + nums[i];
            runningSum += nums[i];
            System.out.println("the running sum is " + runningSum);
            //modulous of 0 , is undefinted
            if (k != 0) {
                runningSum %= k; 
                System.out.println("the running sum % k " + runningSum);
            }
            Integer prev = map.get(runningSum);
            System.out.println("prev is  " + prev);
            if (prev != null) {
                System.out.println("the value of i is  " + i);
                if (i - prev > 1) return true;
            }
            else {
                System.out.println("map put " + runningSum + " " + i);
                map.put(runningSum, i);
            }
        }
        return false;
    }
}

//Maximum sub array
class Solution1 {
    public boolean maxSubarraySum(int[] nums) {
        
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        for(int i =1 ; i< nums.length ; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println("the max Subarray Sum is " + maxSum);
        return true;
    }
}
