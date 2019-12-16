
https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        //use two pointer technique
        int i = 0;
        int j = s.length()-1;
        //char[] charArray = s.toCharArray();
        
        while(i<= j) {
            
                if(!Character.isLetterOrDigit(s.charAt(i))) {
                    i++;
                } else if(!Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                } else {
                    if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                        i++; j--;
                    } else {
                       return false;
                    }
                }
            }
        return true;
    }
}https://leetcode.com/problems/valid-palindrome/
