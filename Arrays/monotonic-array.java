//https://leetcode.com/problems/monotonic-array/
//Running time : O(n)
class Solution {
    public boolean isMonotonic(int[] A) {
        
        int monotone_increasing = 0;
        int monotone_decreasing = 0;    
        for(int i = 0 ; i <= A.length-2; i++) {
            //System.out.println("the loop is " + i);
            if(A[i] < A[i+1]) {
                monotone_increasing++;
            } else if(A[i] > A[i+1]) {
                monotone_decreasing++;
            } else {
                monotone_increasing++;
                monotone_decreasing++;
            }
        }
        /*System.out.println("the array length is " + (A.length-1));
        System.out.println("monotone_increasing count is " + monotone_increasing);
        System.out.println("monotone_decreasing count is " + monotone_decreasing);*/
        
        if(A.length-1 == monotone_increasing || A.length-1 == monotone_decreasing) {
            return true;
        } else {
            return false;
        }
    }
}
