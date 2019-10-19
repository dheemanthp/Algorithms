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
