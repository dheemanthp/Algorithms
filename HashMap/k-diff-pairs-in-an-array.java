https://leetcode.com/problems/k-diff-pairs-in-an-array/

class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums.length == 0) return 0;
        HashMap<Integer,Integer> H = new HashMap<>();
        for(int i : nums) {
            H.put(i,H.getOrDefault(i,0)+1);
        }
        int count  = 0;
        for(int key : H.keySet()) {
            if(
                //check if there is (key+k) which is a key
                (k > 0 && H.containsKey(key+k)) ||
                //if the k value is zero, then check if the count is greater than 1
                (k==0 && H.get(key)>1)) {
                    count++;
                } 
        }
        return count;
    }
}
