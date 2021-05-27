

//rotate the array
//Rotate an array of n elements to the right by k steps. For example, with n
//= 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

//cannot use extra memory
//

 //[1,2,3,4,5,6,7] //input 
 //[4,3,2,1,7,6,5] //Reverse first 4 elements , reverse last 3 elements
 //[5,6,7,1,2,3,4] //reverse the whole array
 
 import java.util.Arrays;
 class Solution {
   
   int[] rotate(int[] input, int n, int k) {
     //base case
     if(input == null || n == 0 || input.length == 0|| k == 0) return input;
     //rotation
     rotatehelper(input,0,n-k-1); //0 to 3
     rotatehelper(input,k+1,n-1);// 4 to 6 
     rotatehelper(input,0,n-1); // 0 to 6
     return input;
   }
   //XOR swap 
   int[] swap(int[] input ,int start ,int end) {
     if(start  == end) return input;
     //XOR swap
     else {
       input[start] ^= input[end];
       input[end] ^= input[start];
       input[start] ^= input[end];
     }
     return input;
   }
   //rotate helper
   int[] rotatehelper(int[] input, int start, int end) {
     while(start <= end) {
       swap(input ,start, end);
       start++;
       end--;
     }
      return input; 
   }
   
   public static void main(String[] args) {
     Solution sol = new Solution();
     int[] input = {1,2,3,4,5,6,7};
     System.out.println("the output array is " + Arrays.toString(sol.rotate(input, input.length, 3)));
     
     
   }
   
 }
 
 
 
 




















