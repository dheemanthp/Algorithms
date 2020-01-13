// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");



//space complexity:O(n) as we are using an array which is size N
//time complexity: loop N/2 , but index increments by N, which is also O(n) worst case
//logic:
//use nums = N/2 as a reference value
//insert the positive and negative of num
//keep decrementing num until num is greater than zero

class Solution {
    public int[] solution(int N) {
        //base case
        if((N< 0)||(N>100)) return new int[0];
        
        //initalize array
        int[] arr = new int[N];
        //divide by 2
        int num = N/2;
        //initalize index
        int index = 0;
        //start from the middle
        while(num>0){
            //populate the positive and negative value of num
            arr[index++] = num;//positive num
            arr[index++] = num*-1;//negative num
            num--;//decrement num
            
        }
        //for an odd N , ensure to fill the last position with zero
        if(N%2 ==1) {
            arr[index++] = 0;
        }
        //return the array
        return arr;
    }
}


test case:
-1 
0
1
2
101
102
