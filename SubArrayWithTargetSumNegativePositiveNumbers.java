import java.util.HashMap;

public class SubArrayWithTargetSumNegativePositiveNumbers{


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
