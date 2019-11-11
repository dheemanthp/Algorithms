
//https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    //From the examples 
    // 0<1>0 , return the index value as A[1] =1
    //0<2>1>0 , return the index value as A[2] =1
    public int peakIndexInMountainArray(int[] A) {
        //use binary search
        int start = 0;
        int end  = A.length-1;
        while (start< end) {
            //if start and end values are really high it may cause overflow by addition
            int mid = start + ((end - start)/2);
            System.out.println(" the value of mid is " + mid);
            if(A[mid] < A[mid+1]) start  = mid + 1;
            else end = mid;//it could be this item too
        }
        return start;
    }
}

//My version complicated
class SolutionAlternative {
    //From the examples 
    // 0<1>0 , return the index value as A[1] =1
    //0<2>1>0 , return the index value as A[2] =1
    public int peakIndexInMountainArray(int[] A) {
        //if(A.length < 3) return -1;
        
        //use binary search
        int start = 0;
        int end  = A.length-1;
        int mid = 0;
        while (start< end) {
            //if start and end values are really high it may cause overflow by addition
            mid = start + ((end-start)/2);
            System.out.println(" the value of mid is " + mid);
            //if(mid == 0 || mid == A.length-1) return -1;
            if(A[mid] > A[mid-1] && A[mid] > A[mid+1]) return mid;
            else if(A[mid] > A[mid-1] && A[mid] < A[mid+1]) start  = mid;
            else end = mid;
        }
        
        return mid;
    }
}
