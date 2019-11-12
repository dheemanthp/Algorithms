//https://leetcode.com/problems/valid-perfect-square/
class Solution {
    public boolean isPerfectSquare(int num) {
    if(num == 1) return true;    
    int start = 1;
    int end = num;
    
    while(start<=end) {
        long mid = start + (end-start)/2;
        // because we are doing multiplication of huge numbers here make it long 
        //otherwise in java integer is signed hence it will become negative values
        long val = mid * mid; 
        
        System.out.println("the value is " +val);
        if(val == num) return true;
        else if(val > num) end = (int)mid-1;
        else start  = (int)mid+1;      
    }
    return false;        
    }
}
