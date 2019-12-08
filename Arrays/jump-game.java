
https://leetcode.com/problems/jump-game/

class Solution {
    public boolean canJump(int[] nums) {
        return canJump(nums,nums.length);
    }
    boolean canJump(int A[], int n) {
    
    int last=n-1; // this is tracking the index value 
    int i,j;
    //start from last but one element
    
    for(i=n-2;i>=0;i--){
        System.out.print(" the current value " + A[i] + " and index value is " + i + " total " + (A[i]+i));
        System.out.println(" the last(index) is " + last);
        //idea is simple 
        //the last but one element and it's index value should be greater than or equal to the next element's index
        //in the failure case ,
        // the last but one element is 0 , and it's index is 3 , hence (3+0) is not greater than next element's index 4
        // whose value is 4
        
        //consider current value + current index , check if it is greater than the next index
        // if yes, then it is reachable  , then go back one index , and again compare with next index 
        // otherwise then it is not reachable
        // 
        
        if(i+A[i]>=last) {
            last=i;// keep storing the current index , for next comparision
            System.out.println(" the last(index) changed " + last);
        }
    }
        // expectation is last(index) will be equal to zero
        
        if(last == 0) {
            return true;
        } else{
            return false;
        }
    }
}

/*

[2,3,1,1,4]
 the current value 1 and index value is 3 total 4 the last(index) is 4
 the last(index) changed 3
 the current value 1 and index value is 2 total 3 the last(index) is 3
 the last(index) changed 2
 the current value 3 and index value is 1 total 4 the last(index) is 2
 the last(index) changed 1
 the current value 2 and index value is 0 total 2 the last(index) is 1
 the last(index) changed 0
*/


/*
[3,2,1,0,5]
 the current value 0 and index value is 3 total 3 the last(index) is 4
 the current value 1 and index value is 2 total 3 the last(index) is 4
 the current value 2 and index value is 1 total 3 the last(index) is 4
 the current value 3 and index value is 0 total 3 the last(index) is 4
*/
