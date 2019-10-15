import java.io.*;
import java.util.*;
//======================================================================================================
//https://leetcode.com/problems/rotate-array/submissions/
//Note the case where you have to rotate more than the length the array

class Solution {
    
    void reverse(int[] nums, int i ,int j) {
        if(nums.length == 0) return;
        while(i < j ) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
            i++;j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if(nums.length == 0) return;
        if(k > length) {
          //for instance 5%3 is 2 , so rotate only 2 times
           k %= nums.length;
        }
        reverse(nums,length-k,length-1);//last 3 numbers
        reverse(nums,0,length-k-1);//first N-3 numbers
        reverse(nums,0,length-1);//all numbers
    }
}
//======================================================================================================






public class RotateArraySegment {
//Input : {1,2,3,4,5,6,7}
//Left Rotate by 2 Output : {3,4,5,6,7,1,2}
//Right Rotate by 2 output : {6,7,1,2,3,4,5}
//Running time : O(n) 
//Space : O(1)

  
  //can handle both right rotate and left rotate
  void rotateArray(int[] arr, int left , int right ) {
    if (arr == null || arr.length == 1) {
      return;
    }
    
    while (left < right) {
      //swap
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  } 
 
 void printArray (int arr[] , int length) {
  for (int i = 0; i< length; i++ ) {
    System.out.println(arr[i]);
  }
 }
  
  //Driver program
  public static void main(String[] args) {
  
    int arr[] = {1,2,3,4,5,6,7};
    int order = 2;
    if(arr ==  null || order == 0) {
        throw new IllegalArgumentException ("Ilegal Argument");
        
    }
    int segment = arr.length - order;//Right rotate
    //int segment = order; //left rotate
    
    RotateArraySegment obj = new RotateArraySegment();
    obj.rotateArray(arr,0,segment-1); //rotate first part
    obj.rotateArray(arr,segment,arr.length-1); //rotate second part
    obj.rotateArray(arr,0,arr.length-1);//rotate the whole array
    obj.printArray(arr,arr.length);//print
  }
}
