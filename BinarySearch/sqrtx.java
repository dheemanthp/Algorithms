
//https://leetcode.com/problems/sqrtx/

//Square root of a number is always less than X/2.

class Solution {
    public int mySqrt(int x) {
        if(x < 2 ) return x;
        long num;
        int mid , start = 2 ,end = x/2;
        while(start <= end) {
            mid = start + (end-start)/2;
            //System.out.println(" begin mid value is " + mid + ", start " + start + " end " + end);
            num = (long)mid * mid ;
            if(num > x) end = mid-1;
            else if(num < x) start = mid+1;
            else return mid;
            //System.out.println(" close mid value is " + mid + ", start " + start + " end " + end);
        }
        //System.out.println("final, start " + start + " end " + end);
        return end;
    }
}
