//Related post
/*
https://www.programcreek.com/2014/10/leetcode-maximum-size-subarray-sum-equals-k-java/
LeetCode – Maximum Product Subarray (Java)
LeetCode – Maximum Subarray (Java)
LeetCode – Subarray Sum Equals K (Java)
Maximum Sum of Subarray Close to K

*/
import java.util.HashMap;


https://www.programcreek.com/2014/10/leetcode-maximum-size-subarray-sum-equals-k-java/
https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
//did not understand in 1st instance , try again.
class Solution {
public int maxSubArrayLen(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);// this is the crux of the logic so understand this 
    int result = 0;
    int sum = 0;
 
    for(int i=0; i<nums.length; i++){
        sum += nums[i];
        System.out.println("sum is " + sum + " index is " + i);
        if(map.containsKey(sum - k)){
            System.out.println(" map contains (sum-k)key " + (sum-k) + " value " + map.get(sum - k));
            int intermediate = i - map.get(sum - k);
            System.out.println("intermediate is " + intermediate);
            result = Math.max(result,intermediate);
            System.out.println("result is " + result);
        }
        map.putIfAbsent(sum, i);
    }
 
    return result;
}
}




public class SubArrayWithTargetSumNegativePositiveNumbers{

https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
//the running time is O(n)
//keep adding every item as part of the sum 
//put the sum and index as part of a hash map
//exit criteria is
//1) if the cur_sum - target becomes zero
//2) if the (cur_sum - target) is found in hasmap , then next element is the start
//of the sum
//otherwise continue adding the sum into hasmap.
//3) if a prefix sum is previously found


boolean subArrayWithTargetSum(int arr[] , int size, int target) {
    HashMap<Integer,Integer> subArrayMap = new HashMap<Integer,Integer>();
    
    int cur_sum = 0;
    int start = 0;
    int end  = -1;
    
    for (int i =0 ;i < size ; i++) {
        cur_sum = cur_sum + arr[i];
        
        //check whether cur_sum - sum = 0, if 0 it means 
        //the sub array is starting from index 0- so stop 
        if(cur_sum - target == 0) {
            start = 0;
            end = i;
            System.out.println("start " + start + " end " + end);
            return true;
        }
        //if hashMap already has the value, means we already  
        // have subarray with the sum - so stop 
        //System.out.println("check" + (cur_sum - target));//for debugging
        //this means some elements have eaten up the current sum , and hence if they
        //were not present , then the sum would have been the target
        if(subArrayMap.containsKey(cur_sum - target)) {
            start = subArrayMap.get(cur_sum - target) + 1; 
            end  = i;
            System.out.println("start " + start + " end " + end);
            return true;
        }
        //if value is not present then add to hashmap 
        subArrayMap.put(cur_sum, i); 

    }
    return false;
}

    public static void main(String []args){
        
    int arr[] = {4,1,-3, -1, 1, -20, 6};
    int target = -23;
    SubArrayWithTargetSumNegativePositiveNumbers obj = new SubArrayWithTargetSumNegativePositiveNumbers();
    boolean found = obj.subArrayWithTargetSum(arr,arr.length,target);
        if(found) {
            System.out.println("the sub array with target sum is found");
        } else {
            
            System.out.println("the sub array with target sum is found");
        }
    }
}
