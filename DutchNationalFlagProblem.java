import java.util.*;


  public class Solution {
//simple solution is to count the number of 0,1,2
//but this will require 2 traversals
//first traversal to count the 0's , 1's and 2's
// second traversal to modify the array
//O(n)

//Better solution is below
//use pivot as middle value
//anything greater than pivot put it to the end
//anything less than pivot put it at the beginning
//O(n)

  static void swap(int[] input, int i, int j) {
      if(input == null) return;
      input[i] ^= input[j];
      input[j] ^= input[i];
      input[i] ^= input[j];

  }
    
   static void threewaysort(int[] input) {
   int low = 0; int mid = 0;//mid also starts from beginning index
   int pivot = 1; // this is the middle value among 0 , 1 , 2
   int high = input.length-1;
   while (mid <= high) {
       //keep swapping 
       if(input[mid] < pivot) { //for 0
           swap(input,low,mid);
           low++;mid++;
       } else if(input[mid] > pivot) { //for 2
           swap(input,mid,high);
           mid++; high --;
       } else { // for 1
           mid++;
       }
   }
   return;
  }   
    
    public static void main(String[] args) {

        int[] input = {0,1,1,0,1,0,1,2,1,1,2,1,1,1,1};
        threewaysort(input);
        for(int i : input) {
            System.out.print(i + " ");
        }
    }
}



