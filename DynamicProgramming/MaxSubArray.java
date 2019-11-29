class Solution {
 //https://leetcode.com/problems/maximum-subarray/
 //DP problem
//Idea is very simple. Basically, keep adding each integer to the sequence until the sum drops below 0.
//If sum is negative, then we should reset the sequence.

    public int maxSubArray(int[] nums) {
        
        //we can track the current sum and max sum
        int csum = 0;
        int msum = nums[0];
        
        for(int i = 0; i < nums.length; i++) {
            csum = csum + nums[i];
            msum = Math.max(csum,msum);
            System.out.println("csum " +csum + " msum " + msum);
            if(csum < 0) {
                csum = 0;
            }
        }
        return msum;
    }
}

//example
//[-2,1,-3,4,-1,2,1,-5,4]
/*
csum = -2 , msum  = -2, reset csum to 0
csum =  1 , msum  = 1,
csum = -2 , msum  = 1, reset csum to 0
csum =  4 , msum  = 4,
csum =  3 , msum  = 4,
csum =  5 , msum  = 5,
csum =  6 , msum  = 6,
csum =  1 , msum  = 6,
csum =  5 , msum  = 6,
*/    
/*
csum -2 msum -2
csum 1 msum 1
csum -2 msum 1
csum 4 msum 4
csum 3 msum 4
csum 5 msum 5
csum 6 msum 6
csum 1 msum 6
csum 5 msum 6
*/




/*
Idea is very simple. Basically, keep adding each integer to the sequence until the sum drops below 0.
If sum is negative, then should reset the sequence.

class Solution {
public:
    int maxSubArray(int A[], int n) {
        int ans=A[0],i,j,sum=0;
        for(i=0;i<n;i++){
            sum+=A[i];
            ans=max(sum,ans);
            sum=max(sum,0);
        }
        return ans;
    }
};*/


import java.lang.Math;

public class MaxSubArray {

//Can also handle negative values
//Running time : O(n)
//input is {-2,-3,4,-1,-2,1,5,3,-3};    
//output is 10 and the max subarray [4,-1,-2,1,5,3]
    
    int maxSubArray(int[] arr,int size) {
    
        int curr_max = arr[0]; //store the first element 
        int max_so_far = arr[0]; //store the first element
            
        for(int i = 1; i < size -1 ; i++) {
            curr_max = Math.max (arr[i],curr_max + arr[i]);
            max_so_far = Math.max (max_so_far,curr_max);
        }
    return max_so_far;   
    }

    //Driver Code
    public static void main(String[] args) {
        int arr[] = {-2,-3,4,-1,-2,1,5,3,-3};    
        MaxSubArray obj = new MaxSubArray();
        int value  = obj.maxSubArray(arr,arr.length);
        System.out.println("the max value is " + value);
    }
}
