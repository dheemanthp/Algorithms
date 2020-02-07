//import java.util.Arrays;

class Solution {
    //https://leetcode.com/problems/reverse-words-in-a-string/
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
        //create a string builder
        StringBuilder SB = new StringBuilder();
        //split the words
        String[] words = s.trim().split(" ");
        //for each of the word
        for(String word : words) {
            //trim it in order to avoid any empty spaces
            if(!word.trim().isEmpty()) {
                //convert the word in chararray
                char[] ch = word.toCharArray();
                //the returned string is appended to SB
                SB.append(swap(ch,0,ch.length-1) + " ");
                System.out.println(SB.toString());
            }
        }
        //finally the whole sentence can be reversed 
        String output = SB.toString().trim();
        //swapped sentence
        String sentence = swap(output.toCharArray(),0,output.length()-1);
        return sentence;
    }
}


class Solution {
    //https://leetcode.com/problems/reverse-words-in-a-string/submissions/
    public static void swap(char[] ch,int i,int j) {
        if( i == j ) return;
        while(i <j ) {
        ch[i] ^= ch[j];
        ch[j] ^= ch[i];
        ch[i] ^= ch[j];
            i++;
            j--;
        }
    }
    
    public static String reverseWords(String input) {
        String s = input.trim();
        int len = s.length();
        if(len == 0) return s;
        int start = 0; 
        char[] ch = s.toCharArray();
        //reverse every word
        for(int i = 0 ;i < len ; i++) {
            if(ch[i] == ' ') {
                swap(ch,start,i-1);
                start = i+1;
            } 
        }
        //swap the last word 
        swap(ch,start,len-1);
        //reverse the entire sentence
        swap(ch,0,len-1);
        System.out.print(String.valueOf(ch));
        //We can ideally return here as we have done inplace XOR swap
        
        //In order to handle Extra spaces in b/w strings we can 
        //use a String Builder
        StringBuilder SB = new StringBuilder();
        for (int j = 0; j  < len ; j++) {
            
            if(j > 0 && ch[j] == ' ' && ch[j-1] == ' ') {
                //do nothing
            } else {
                //System.out.print(ch[j]);
                SB.append(ch[j]);
            }
        }
        //Return the String
        return SB.toString();
    }
}
