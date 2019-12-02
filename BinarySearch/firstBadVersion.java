//https://leetcode.com/problems/first-bad-version/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

//I got it in FB mock test --- this passed
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end- start)/2;
            //System.out.println(" the value of start " + start + " end " + end);
            //System.out.println(" the value of mid is " + mid);
            // go to the left
            if(isBadVersion(mid) == true) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}



public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //approach is using Binary search, either go to the left or right
        //left , if we hit a bad one
        //right , if we hit a good one
        
        int mid = 0 ;
        int left  = 0;
        int right  = n;
        //eventually left == right , this is the exit criteria
        while(left < right) {
            mid = left + (right-left)/2;
            System.out.println("start the mid value is " + mid + " left "+ left + " right " + right);
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
            System.out.println("end the mid value is " + mid + " left "+ left + " right " + right);
        }
        
        return right;
    }
}
