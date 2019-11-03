//https://leetcode.com/problems/add-binary/submissions/


import java.util.*;
class Solution {
    public String addBinary(String a, String b) {
        
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
        int lengthA = a.length() -1;
        int lengthB = b.length() -1;
        //String Builder
        StringBuilder SB = new StringBuilder();
        int carry = 0;
        //loop until one or all the conditions satisfy
        while (lengthA >= 0 || lengthB >= 0 || carry == 1) {
            int X = lengthA >=0 ? Character.getNumericValue(a.charAt(lengthA)): 0;
            int Y = lengthB >=0 ? Character.getNumericValue(b.charAt(lengthB)): 0;
            int val = (X+ Y + carry)%2;
            System.out.println(" the val value is " + val + " " + X + " " +Y + " " + carry);
            carry =  (X+ Y + carry)/2;
            System.out.println(" the carry value is " + carry);
            lengthA--;
            lengthB--;
            SB.append(val);
        }
        return SB.reverse().toString();
    }
}
