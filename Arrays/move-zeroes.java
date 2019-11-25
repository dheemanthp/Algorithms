
//https://leetcode.com/problems/move-zeroes/

class Solution {
   
/*
Approach #2 (Space Optimal, Operation Sub-Optimal) [Accepted]
This approach works the same way as above, i.e. , first fulfills one requirement and then another. The catch? It does it in a clever way. The above problem can also be stated in alternate way, " Bring all the non 0 elements to the front of array keeping their relative order same".

This is a 2 pointer approach. The fast pointer which is denoted by variable "cur" does the job of processing new elements. If the newly found element is not a 0, we record it just after the last found non-0 element. The position of last found non-0 element is denoted by the slow pointer "lastNonZeroFoundAt" variable. As we keep finding new non-0 elements, we just overwrite them at the "lastNonZeroFoundAt + 1" 'th index. This overwrite will not result in any loss of data because we already processed what was there(if it were non-0,it already is now written at it's corresponding index,or if it were 0 it will be handled later in time).

After the "cur" index reaches the end of array, we now know that all the non-0 elements have been moved to beginning of array in their original order. Now comes the time to fulfil other requirement, "Move all 0's to the end". We now simply need to fill all the indexes after the "lastNonZeroFoundAt" index with 0.


*/
    
    //O(n)
    //" Bring all the non 0 elements to the front of array keeping their relative order same".
    //filling all positions with valid numbers
    public void moveZeroes(int[] nums) {
     int nonZeroElement = 0;
     for(int i =0; i < nums.length ;i++) {
         if(nums[i] != 0) {
             nums[nonZeroElement++] = nums[i];
         }
     }
     //filling rest of the positions with zero
     for(int j =nonZeroElement; j < nums.length ;j++) {
             nums[j] = 0;
     }
    return;        
    }
    
    

    
    //Alternative solution
    void swap(int[]nums,int i,int j) {
        System.out.println("swap (i,j) = " + "("+i+","+j+")");
        if(i == j) return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
   
//By calling swap
   public void moveZeroesMySolution(int[] nums) {
        
    int i = 0;
    int j = i+1;
    while(i <= j && j < nums.length) {
       
        if(nums[i] == 0 && nums[j] == 0) {
            j++;
        } else if(nums[i] == 0) {
            swap(nums,i,j);
            i++;j++;
        } else {
            i++;j++;
        }
    }
        return;
    }
}
