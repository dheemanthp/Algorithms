import java.io.*; 
import java.util.*; 

class compareVersion {

//https://leetcode.com/problems/compare-version-numbers/

    static public int compareVersion(String v1, String v2) {
    
      //first compare if 2 strings are equal
      if(v1.equals(v2)) {
        return 0;
      }
      // check the length of the 2 strings
      int lengthV1 = v1.length();
      int lengthV2 = v2.length();

      //make the length equal
      int delta = Math.abs(lengthV1 - lengthV2);
      //System.out.println("the delta is " + delta);   
      int count  = 0;
      if(lengthV1 < lengthV2) {
        while(count < delta) {
           v1+= ".0";
          count = count + 2;
         }
      } else {
         while(count < delta) {
           v2+= ".0";
          count = count + 2;
         }
      }
    //Now split the string based on "."
    //System.out.println("the first string is " + v1);   
    //System.out.println("the second string is " + v2);   
    String[] v1Str= v1.split("\\.");
    /*  
    for (String a : v1Str) {
            System.out.println("the split is " + a); 
    } 
    */
    String[] v2Str= v2.split("\\.");
    /*  
    for (String a : v2Str) {
            System.out.println("the split is " + a); 
    } 
    */
    //Now compare the values in the array
    int length = Math.min(v1Str.length ,v2Str.length);
    for (int i = 0 ; i< length ; i++ ) {
      
      int num1=Integer.parseInt(v1Str[i]);
      int num2=Integer.parseInt(v2Str[i]);
      int output = num1 - num2 ;
      if(output != 0) {
        
       return Integer.compare(num1, num2);
      }
    }
    
     return 0; 
    }
  
  static void result (int output) {
  
    switch (output) {
        case 1: System.out.println("1");
                break;

        case -1:System.out.println("-1");
                break;
        case 0:System.out.println("0");
                break;
        default:break;
      }
    
  }
  
    public static void main(String[] args) {
    int output;
    //System.out.println("==================output======================="); 
    //Example 1:

    //Input: version1 = "0.1", version2 = "1.1"
    //Output: -1
      String v1 = "0.1";
      String v2 = "1.1";
      
      output = compareVersion(v1,v2);
      result(output);

    //Example 2:

    //Input: version1 = "1.0.1", version2 = "1"
    //Output: 1
       v1 = "1.0.1";
       v2 = "1";
      
      output = compareVersion(v1,v2);
      result(output);
      
      
    //Example 3:

    //Input: version1 = "7.5.2.4", version2 = "7.5.3"
    //Output: -1
       v1 = "7.5.2.4";
       v2 = "7.5.3";
      
      output = compareVersion(v1,v2);
      result(output);
      
    //Example 4:
    //Input: version1 = "1.01", version2 = "1.001"
    //Output: 0
    //Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
       v1 = "1.01";
       v2 = "1.001";
      
      output = compareVersion(v1,v2);
      result(output);      
  

    //Example 5:

    //Input: version1 = "1.0", version2 = "1.0.0"
    //Output: 0
    //Explanation: The first version number does not have a third level 
    //revision number, which means its third level //revision number is default to "0"      
       v1 = "1.0";
       v2 = "1.0.0";
      
      output = compareVersion(v1,v2);
      result(output);      
      
      
      
    }
      
  
}
