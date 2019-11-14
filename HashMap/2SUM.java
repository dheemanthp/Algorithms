class Solution {
    public int[] twoSum(int[] nums, int target) {
    
        //output
        int[] output = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int i =0; i < nums.length ; i++) {
            

             if(map.containsKey(target-nums[i])) {
                 output[0] = map.get(target-nums[i]);
                 output[1] = i;
                 return output;
             } else {
                map.put(nums[i],i);
             }

        //throw new IllegalArgumentException("No two sum solution");
    }
        return output;
 }
}


https://leetcode.com/problems/two-sum-less-than-k/
class Solution {
    
        public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A); // Time cost O(nlogn).
        int max = -1, i = 0, j = A.length - 1; 
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < K) { // find one candidate.
                max = Math.max(max, sum);
                ++i; // increase the smaller element.
            }else { // >= sum.
                --j; // decrease the bigger element.
            }
        }
        return max;
    }
}
