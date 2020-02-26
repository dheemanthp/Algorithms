

https://leetcode.com/problems/valid-palindrome-ii/

class Solution {
    public boolean validPalindrome(String s) {

    //2 pointer technique 
    //compare normally until you hit a place where they dont match
    //ignore either that character at the left side , or ignore the character on the right side ,
    and do the same comparision again
        
    int start = 0;
    int end = s.length() -1;
    while (start < end && s.charAt(start) == s.charAt(end)) {
        start++;end--;
    }
    //end at this point     
    if(start >= end) return true;
    //call helper function here which does the samething of checking
        else {
            return (helper(s, start+1, end) || 
                    helper(s, start, end-1));
        }
    }
    
    boolean helper(String s, int start , int end) {
    while (start < end && s.charAt(start) == s.charAt(end)) {
        start++;end--;
    }   
        //end at this point     
    if(start >= end) return true;
    //call helper function here which does the samething of checking
    else {
            return false;
        }    
    }
}













/*
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++; j--;
        }

        if (i >= j) return true;
        //check 
        if (isPalin(s, i + 1, j) || isPalin(s, i, j - 1)) return true;
        return false;
    }

    private boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++; j--;
            }
            else return false;
        }
        return true;
    }
}
*/
