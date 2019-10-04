import java.io.*;
import java.util.*;



import java.lang.Math;

public class Solution {
//There are two sorted arrays A and B of size m and n respectively.
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).  

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int total = nums1.length+nums2.length;
    if(total%2==0){
        System.out.println("total is even " + total + " the kth elements are " + total/2 + " " + ((total/2)-1));
        return (getKth(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, total/2) 
              + getKth(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, (total/2)-1))/2.0;
    }else{
        System.out.println("total is odd " + total + " the kth elements are " + total/2);
        return getKth(nums1,0, nums1.length-1, nums2, 0, nums2.length-1, total/2);
    }
}
 
//k is the index starting from 0
private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
    System.out.println("k value is : " + k);
    //array 1 is empty
    if(end1<start1){
        return nums2[start2+k];
    }
    //array 2 is empty
    if(end2<start2){
        return nums1[start1+k];
    }
    //if k is zero , kth element is the first element of 1st array or 2nd array
    if(k==0){
        System.out.println("Zero k value is : " + k);
        return Math.min(nums1[start1], nums2[start2]);
    }
    //length
    int len1 = end1 - start1 + 1;
    System.out.println("len1 is : " + len1);
    int len2 = end2 - start2 + 1;
    System.out.println("len2 is : " + len2);
    
    //
    int middle1 = k*len1/(len1+len2);
    System.out.println("middle1 is : " + middle1);
    int middle2 = k - middle1 - 1;
    System.out.println("middle2 is : " + middle2);
 
    middle1 += start1;
    System.out.println("middle1 is : " + middle1);
    middle2 += start2;
    System.out.println("middle2 is : " + middle2);
 
    if(nums1[middle1]<nums2[middle2]){
            k = k-(middle1-start1+1);
            end2 = middle2;
            start1 = middle1+1;            
    }else{
            k = k-(middle2-start2+1);
            end1 = middle1;
            start2 = middle2+1;
    }
    System.out.println("==========Recursion===============");
    return getKth(nums1, start1, end1, nums2, start2, end2, k);
}
  
  
  public static void main(String[] args) {
  
    int a[] = {200,300,400,500,600,700}; 
    int b[] = { 10,12,14}; 
    Solution S = new Solution();
    double median = S.findMedianSortedArrays(a,b);
    System.out.println("the median is " + median);
  
  }
  
}  
