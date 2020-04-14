


class Solution {
    
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

    //use the logic here
    // compare mid with end , if mid is less , then all are sorted , so go left
    // compare mid with end , if mid is greater , then all not sorted , so go right
    public int findMin(int[] num) {
        
        int low = 0, high = num.length - 1;
        // loop invariant: 1. low < high
        //                 2. mid != high and thus A[mid] != A[high] (no duplicate exists)
        //                 3. minimum is between [low, high]
        // The proof that the loop will exit: after each iteration either the 'high' decreases
        // or the 'low' increases, so the interval [low, high] will always shrink.
        while (low < high) {
            int mid = low + (high - low) / 2;
            System.out.println(" the mid index is " + mid + " low " + low + " [vals] "+ num[low] +" high " + high + " [vale] "+ num[high]);
            if (num[mid] < num[high]) //sorted go left
                // the mininum is in the left part
                high = mid;
            else if (num[mid] > num[high])
                // the mininum is in the right part
                low = mid + 1;
        }
        System.out.println(" low " + low + " [vals] "+ num[low] +" high " + high + " [vale] "+ num[high]);
        return num[low];
        
    }
    

    
    //Easy peezy my logic works but more conditions: REMEMBER ARRAY IS SORTED IN ASCENDING ORDER
    //Find the Inflection point , [4,5,6,7,8,9,10,11,12,0,1,2,3] for example it is 0 
    //i.e, the point at which it is rotoated
    // if mid is greater than the first element , then go to the right
    // if mid is lesster than the first element , then go to the left
    //// we stop when num[mid] > num[mid+1] OR num[mid-1] > num[mid]
    
    public int findMinZ(int[] nums) {
        
        if(nums == null) return 0;
        if(nums.length == 1) return nums[0];
        int begin  = 0;
        int end  = nums.length-1;
        if(nums[begin] < nums[end]) return nums[begin]; // this will hold good if array is sorted but not rotated
        
        
        while (begin < end) {
        int mid = begin + (end - begin)/2;
            System.out.println(" the mid index is " + mid + " begin " + begin + " [vals] "+ nums[begin] +" end " + end + " [vale] "+ nums[end]);

            if(mid >=0 && mid < end && nums[mid] > nums[mid+1]) return nums[mid+1];
            else if (nums[mid] > nums[begin]) begin = mid+1; // sorted so go right
            else  end = mid; // not sorted , so go left
        }
        
        System.out.println(" returning outside " + " begin " + begin + " [vals] "+ nums[begin] +" end " + end + " [vale] "+ nums[end]);
        return nums[begin];
        
    }
    
    
}
//[3,4,5,1,2]

