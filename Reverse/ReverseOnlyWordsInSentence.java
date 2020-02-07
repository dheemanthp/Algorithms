
class Solution {
    https://leetcode.com/problems/reverse-words-in-a-string-iii/
    public String swap(char[] word, int i , int j){
        while (i < j) {
            word[i] ^= word[j];
            word[j] ^= word[i];
            word[i] ^= word[j];
            i++;
            j--;
        }
        return new String(word);
    }
    
    public String reverseWords(String s) {
        //base case
        if(s == null || s.length() == 0) return s;
        //create a string builder
        StringBuilder SB = new StringBuilder();
        //split the words
        String[] words = s.trim().split(" ");
        //for each of the word
        for(String word : words) {
                //convert the word in chararray
                char[] ch = word.toCharArray();
                //the returned string is appended to SB
                SB.append(swap(ch,0,ch.length-1) + " ");
                System.out.println(SB.toString());
        }
        //trim the SB
        String output = SB.toString().trim();
        return output;
    }
}
