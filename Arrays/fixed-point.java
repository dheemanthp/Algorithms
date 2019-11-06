//https://leetcode.com/problems/fixed-point/

class Solution {
//Binary search solution  
//A[i] < i , go to the right
//A[i] > i , go to the left    
    public int fixedPoint(int[] A) {
        if(A == null) return -1;
        int len = A.length;
        if(len == 0) return -1;
        int mid = 0;int start = 0;int end = len -1;
        //flooring problem
        while(start <= end) {
            mid = (start+end)/2;
            System.out.println("the start "+ start + " mid " + mid + " end " + end);
            if(A[mid] == mid) break;
            if(A[mid] < mid) {
                start = mid;
                 start++;
            } else{
                end = mid;
                end--;
            }
        }
        if(A[mid] != mid) return -1;
        //find the smallest mid value
        while(mid >= 0 && A[mid] == mid) {
            mid--;
        }
        return mid+1;
    }
}

/*
//Iterative solution
class Solution {
    public int fixedPoint(int[] A) {
        
        if(A == null) return -1;
        if(A.length == 0) return -1;
        
        for(int i = 0; i< A.length; i++) {
            if(A[i] == i) {
                return i;                
            }
        }
        return -1;
    }
}
*/
