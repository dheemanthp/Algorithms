// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {
// Time Complexity: O(n), where n is the length of the string
// Space Complexity: O(n), string builder variable 
//also NOTE special case - all the alphabets could be in ascii ascending order
// Logic: 1. We first need to compare each of the characters in the given string starting from
// first to its next characters, when we find the one character greater then other, we remove that
// character and return the result

    public String solution(String s) {
        //base case
        if( s == null || s.length() == 0) {
            return s;
        }
        else if(hasUpperCase(s)) {
            return s;
        }
        else if(hasNumbers(s)) {
            return s;
        }
        else if(s.length() < 2 || s.length() > 100000) {
            return s;
        } else {
            StringBuilder str = new StringBuilder(s);
            int counter=0;
            for(counter=0; counter<str.length()-1; counter++){
                if(str.charAt(counter)>str.charAt(counter+1)){
                break;
                }
            }
        return str.deleteCharAt(counter).toString();
        }
    }
    // Helper method for detecting upper case characters
    public boolean hasUpperCase(String s) {
        boolean hasUpperCaseCharacters = !s.equals(s.toLowerCase());
        return hasUpperCaseCharacters;
    }
    // Helper method for detecting numbers
    public boolean hasNumbers(String s) {
        boolean hasNumbersInIt=false;
        for(char ch : s.toCharArray()) {
            if(Character.isDigit(ch)) {
                hasNumbersInIt=true;
                break;
            }
        }
        return hasNumbersInIt;
    }
}





//test case:
" "
"acb"
"codility"
"ab"
"aAcb"
"a123bc"
"1234"
"abc def"
"abcdef"
"fedcba"



