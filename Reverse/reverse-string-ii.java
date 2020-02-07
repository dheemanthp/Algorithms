

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
