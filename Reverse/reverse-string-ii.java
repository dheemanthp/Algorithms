/*
Given a string and an integer k, you need to reverse the first k characters for every 2k 
characters counting from the start of the string. If there are less than k characters left, 
reverse all of them. If there are less than 2k but greater than or equal to k characters, 
then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

*/

class Solution {
    //https://leetcode.com/problems/reverse-string-ii/
    public void swap (char[] word, int i , int j) {
        
        while(i < j ) {
            word[i] ^= word[j];
            word[j] ^= word[i];
            word[i] ^= word[j];
            i++;
            j--;
        }
    }
    public String reverseStr(String s, int k) {
        //base case
        if(s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray();
        for(int i = 0; i < s.length() -1 ; i = i+(2*k)) {
            
            //swap i to i + k -1
            //System.out.println("the output is " + (i+k-1));
            if(i+k-1 < s.length()) {
                //System.out.println("swap");
                swap(ch,i,i+k-1);       
            
            } else {
                swap(ch,i,s.length()-1);
            }
        }
        return new String(ch);
    }
}
