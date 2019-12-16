https://leetcode.com/problems/squares-of-a-sorted-array/


class Solution {
    public int[] sortedSquares(int[] A) {
        
        //use two pointers and have pointers pointing to start and end
        //compare the ABS of both the start and the end , and check which one is larger
        int i = 0;
        int j = A.length-1;
        int[] result = new int[A.length];
        
        for (int k = A.length-1; k >=0 ; k--) {
            
            if(Math.abs(A[i]) > Math.abs(A[j])) {
                     result[k] = A[i] * A[i];       
                    i++;
            } else{
                     result[k] = A[j] * A[j];       
                     j--;
            }
        }
        return result;
    }
}
