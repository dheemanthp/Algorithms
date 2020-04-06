class Solution {
//Binary search solution which is amazing
//https://leetcode.com/problems/missing-element-in-sorted-array/
public int missingElement(int[] nums, int k) {
		int len = nums.length;
		int lo = 0, hi = len - 1;
        //count missing  = total numbers of elements - total number of elements present
		int countMissing = (nums[len - 1] - nums[0] + 1) - (len);

        
        //falls outside the boundry
		if (k > countMissing) {
			return nums[len - 1] + k - countMissing;
		}
        
        //falls inside the boundry
        //System.out.println(" low " + lo + " high " + hi);
        //the reason why low < (high -1) condition is used because you want to get to a condition where
        //both lowindex and highindex are next to each other. this will then become an exit criteria and help to get out of the loop
        //
        //example : Input: A = [4,7,9,10], K = 3
        //here value 7 is at index 1
        //here value 9 is at index 2
        //index 1 is next to index 2 in the array , hence this become an exit condition
		while (lo < hi-1) {
			int mid = lo + (hi - lo) / 2;

            //newCountMissing = mid element - low element - (mid index - low index)
			int newCountMissing = nums[mid] - nums[lo] - (mid - lo);
            //tighten from right if k falls within the missing count
            if(k <= newCountMissing) {
                //System.out.println(" moving hi towards mid");
                hi = mid;
            //tighten from left if k goes beyond the missing count
            } else {
                k = k - newCountMissing;
                //System.out.println(" moving lo towards mid and k = " + k);
                lo = mid;
            }
            //System.out.println(" low " + lo + " high " + hi);
		}

		return nums[lo] + k;
	}
}


/*
//Linear Solution which i did

class Solution {
    public int missingElement(int[] nums, int k) {
        //edge cases
        if(nums == null || nums.length == 0) return -1;
        if(k == 0) return -1;
        //output
        int outputMissingValue = -1, missingCount = 0;
        
        for(int i = 0; i< nums.length-1;i++) {
            missingCount = nums[i+1] - nums[i]-1;
            if(k <= missingCount) {
                outputMissingValue = nums[i] + k;
                k = 0;//because we have found the value
                break;
            } 
              k = k - missingCount;  

        }
        if(k != 0) {
            outputMissingValue = nums[nums.length-1] + k;
        }
        
        
        return outputMissingValue;
    }
}


*/


