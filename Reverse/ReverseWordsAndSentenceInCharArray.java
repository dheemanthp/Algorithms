//import java.util.Arrays;

class Solution {
    //https://leetcode.com/problems/reverse-words-in-a-string/
    public void swap(char[] word, int i , int j){
        while (i < j) {
            word[i] ^= word[j];
            word[j] ^= word[i];
            word[i] ^= word[j];
            i++;
            j--;
        }
    }
    
    public void reverseWords(char[] s) {
        //base case
        if(s == null) return;
        int start = 0;
        //end of for
        for(int i = 0; i < s.length-1;i++) {
            if(s[i] == ' ') {
                swap(s,start,i-1);
                start = i+1;
            }
        }
        //reverse the last word
        swap(s,start,s.length-1);
        //reverse entire sentence
        swap(s,0,s.length-1);
        
        
    }
}
