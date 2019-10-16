class Solution {
    
    public String reverseVowels(String str) {
        int i = 0 ;
        int j = str.length() - 1;
        char[] s = str.toCharArray();
        String vowels = "aeiouAEIOU";
        boolean start = false;
        boolean end = false;
        while (i < j) {
            
         if (vowels.contains(s[i]+"")) { start = true; }
         if (vowels.contains(s[j]+"")) { end = true; }   
         if(start == true && end == true) {
              System.out.println("Reverse the value of i: " +i + " j is: "+ j);
              reversestr(s,i,j);
              start = false;end = false;
              i++;j--;
         } else {
             if(start == true){ j--; } else {i++;}
         }
       }            
       return String.valueOf(s);
    }
    //@@dheemz    
    public void reversestr(char[] s , int i , int j) {
        if(i == j) return;
        s[i] ^= s[j]; 
        s[j] ^= s[i]; 
        s[i] ^= s[j];
    }
}   

/*
public class Solution {
public String reverseVowels(String s) {
    if(s == null || s.length()==0) return s;
    String vowels = "aeiouAEIOU";
    char[] chars = s.toCharArray();
    int start = 0;
    int end = s.length()-1;
    while(start<end){
        
        while(start<end && !vowels.contains(chars[start]+"")){
            start++;
        }
        
        while(start<end && !vowels.contains(chars[end]+"")){
            end--;
        }
        
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        
        start++;
        end--;
    }
    return new String(chars);
}
*/

