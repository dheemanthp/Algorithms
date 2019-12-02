
//https://leetcode.com/problems/random-pick-index/

////loop through the entire set of numbers as the array is not sorted, hence it is O(n)
//most important aspect is creating randomness
// every time target is found , generate a random number and check if it equals zero
//if(rnd.nextInt(++count) == 0) then store the index , and first time this method call will always zero
// hence first time the target is found we will store its index for sure
public class Solution {

    int[] nums;
    Random rnd;
    //the array is not sorted
    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        int i = 0;
        
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                System.out.println("target miss " + nums[i]);
                continue;
            } 
            //count increases every time a target is found
            // now we use a random function and the incremental count value
            // if there is 1 target only , then the probability of return the (result  = i) is 1
            // if there is 2 same repeated targets , then the probability of return the (result  = i) is 1/2
            // if there is 3 same repeated targets , then the probability of return the (result  = i) is 1/3
            //{1,2,3,3,3}; hence 3 is repeated thrice here
            // so that probability of return their index values 2,3,4 has 1/3rd probability
            
            //basically here you are calling the random function 3 times.
            // geneate random number b/w (0 to 1) , first time it will always be 0 , then set the result to i
            // from here onwards randomness comes into picture
            // geneate random number b/w (0 to 2) , if it equals 0 , then set the result to i , if not move on 
            // geneate random number b/w (0 to 3) , if it equals 0 , then set the result to i , if not move on 
            
            int randomValue = rnd.nextInt(++count);
            System.out.println("randomValue is " + randomValue + " count " + count);
            if (randomValue == 0){
                System.out.println("result index " + i + " hit number is " + nums[i]);
                result = i;
            }
                
        }
        System.out.println("value of i " + i);
        System.out.println("returning result " + result);
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
