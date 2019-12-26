https://leetcode.com/problems/valid-anagram/

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for(int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for( int i : alphabet) if(i != 0) return false;
        return true;
    }
}

// valid anagram
//Here i tried XOR operation . but it failed for input
//aa , bb , here it said it is anagram but infact it is not

class SolutionXOR {
    public boolean isAnagram(String s, String t) {
        //string is null
        if(s== null || t== null) {
            return false;
        }
        
        //check the length
        if(s.length() != t.length()) {
            return false;
        }
        
        int value = 0;//this step is important , here we start at zero, and end with zero
        for(int i = 0; i < s.length() ; i++) {
            value ^= (int)s.charAt(i);
            value ^= (int)t.charAt(i);
            
        }
        System.out.println("the output is " + value);
        return (value == 0);        
    }
}
