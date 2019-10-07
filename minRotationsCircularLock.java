

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

  




public class Solution {
  
  
//Minimum rotations to unlock a circular lock
//https://www.geeksforgeeks.org/minimum-rotations-unlock-circular-lock/
//You are given a lock which is made up of n-different circular rings and each ring has 0-9 digit printed serially on //it. Initially all n-rings together show a n-digit integer but there is particular code only which can open the lock. //You can rotate each ring any number of time in either direction. You have to find the minimum number of rotation //done on rings of lock to open the lock.
  
      int minRotation(Integer input,Integer code) {
     
       if(Integer.toString(input).length() != Integer.toString(code).length() ||
          Integer.toString(input).length() == 0 || Integer.toString(code).length() == 0) {
         return 0;
       }
      
       int length = Integer.toString(input).length();
       int result = 0;
       
       while(length != 0 ) {
        
         int digit = Math.min(Math.abs((code % 10 ) - (input % 10 )),
                  (10 -Math.abs((code % 10 ) - (input % 10 )))); 
         //System.out.println("the digit is " + digit);
         result = result + digit;
         input = input/10;
         code = code/10;
         length--;
       }
       return result;
     }
    
    public static void main(String[] args) {
      Solution Sol =  new Solution();
      
      int input1 = 28756;
      int code1 =  98234;
      System.out.println("the minimum rotation is is " + Sol.minRotation(input1,code1));
      int input2 = 123;
      int code2 =  1;
      System.out.println("the minimum rotation is " + Sol.minRotation(input2,code2));
      int input3 = 101010;
      int code3 =  919191;
      System.out.println("the minimum rotation is " + Sol.minRotation(input3,code3));


      
      
      
    }   
}
