//https://leetcode.com/problems/subarray-sum-equals-k/
**Complexity Analysis**
Time complexity : O(n)O(n). The entire numsnums array is traversed only once.

Space complexity : O(n)O(n). Hashmap mapmap can contain upto nn distinct entries in the worst case.

//I know it well
//let us say input is [6,4,6] and k is 10 , so there are 2 subarrays
//sum = 0
//by default push the key,value (0,1) , this will be used to increment result
// sum  = 0+6 => 6 , check delta(10-6) in map which is 4, it is not present
//sum = 6 + 4 => 10 , check delta(10-10) in map which is 0 , so result = 1
//sum = 10 + 6 => 16 , check delta (16-10) in map , which is 6, so result = 2

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Edge cases
        if(nums.length == 0)    return 0;
        
        // Sliding window -- No, contains negative number
        // hashmap + preSum
        /*
            1. Hashmap<sum[0,i - 1], frequency>
            2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
                   k           sum      hashmap-key     -->  hashmap-key  =  sum - k
            3. now, we have k and sum.  
                  As long as we can find a sum[0, i - 1], we then get a valid subarray
                 which is as long as we have the hashmap-key,  we then get a valid subarray
            4. Why don't map.put(sum[0, i - 1], 1) every time ?
                  if all numbers are positive, this is fine
                  if there exists negative number, there could be preSum frequency > 1
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0; int result = 0;
        map.put(0, 1);
        for(int cur : nums) {
            sum += cur;
            if(map.containsKey(sum - k))  // there exist a key, that [hashmap-key  =  sum - k]
                result += map.get(sum - k); //increments result by 1 always , if there exists a delta
            //Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("the map is " + map);
        return result; 
    }
}
