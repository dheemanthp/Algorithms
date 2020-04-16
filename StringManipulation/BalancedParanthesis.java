//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
//Idea is very simple , perform 2 sweeps
//LEFT TO RIGHT
//Mark all the unwanted closed braces from Left to right
//RIGHT TO LEFT
//Mark all the unwanted open braces from right to left
//Finally based on the marker , Build the string


class Solution {
     public String minRemoveToMakeValid(String s) {
       if(s == null) return null;
    StringBuilder output = new StringBuilder();
    //Remove array used as Marker to note unwanted Open and Unwanted close brances
    boolean[] remove = new boolean[s.length()];

    int open = 0;
    //first parse
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') open++;
            else if(s.charAt(i) == ')'){
                if(open > 0) open--;
                //mark the bracket that needs to be removed
                else remove[i] = true;
            } else{
                //valid character
            } 
        }       
    int close = 0;
    //second parse
    for(int i=s.length() -1; i >=  0; i--) {
            if (s.charAt(i) == ')') close++;
            else if(s.charAt(i) == '('){
                if(close > 0) close--;
                //mark the bracket that needs to be removed
                else remove[i] = true;
            } else{
                //valid character
            } 
        }       

    //Build String builder, remove all the brackets from remove array
    for(int i=0; i <= s.length() -1 ; i++) {
        if(!remove[i]) {
            output.append(s.charAt(i));
        }
    }
    return output.toString();
   }
}

//ALTERNATIVE APPROACH BELOW, but just follow the above approach.

import java.util.*;

/*
       //assert obj.removeInvalidParentheses("ab)a(c)fg)a") == "aba(c)fga"
       //assert obj.removeInvalidParentheses("ab(a(c)fg)9)))") == "ab(a(c)fg)9"
        //assert obj.removeInvalidParentheses(")a(b)c()(5") == "a(b)c()5"
        //assert obj.removeInvalidParentheses(")(") == ""
        //assert obj.removeInvalidParentheses("a(b))") == "a(b)"
        
       String input1 =  "ab)a(c)fg)a";
        System.out.println(removeBracket(input1));
        String input2 =  "ab(a(c)fg)9)))";
        //System.out.println(removeBracket(input2));
        String input3 =  ")a(b)c()(5";
        //System.out.println(removeBracket(input3));
        String input4 =  ")(";
        System.out.println(removeBracket(input4));
        String input5 =  "a(b))";
        //System.out.println(removeBracket(input5));
*/


public class Solution {
//Facebook | Balance Parentheses

//O(n)
//start from beginning 
//track the open brackets , and if they have enough close , if there are more close brackets than open brackets , then mark it for removal
//start from end
//track the close brackets , and if they have enough open , if there are more open brackets than close brackets , then mark it for removal

   static String removeBracket(String input) {
       if(input == null) return null;
    int length = input.length();
    StringBuilder output = new StringBuilder();
    boolean[] remove = new boolean[length];

    int open = 0;
    //first parse
    for(int i=0; i <= length -1 ; i++) {
        switch(input.charAt(i)) {
        case ')': {
            if(open > 0 ) {
                open--;
            } else {
                remove[i] = true; //mark and remove non matching brackets
                //System.out.println("open---->remove " + i);
            }
            break;
        }
        case '(': {
            open++;
            break;
        }
        default: {
        //do nothing
        break;
        } 
        } 
    }
   //System.out.println("open:" +open);
   
    int close = 0;
    //second parse
    for(int i=length -1; i >=  0; i--) {
        switch(input.charAt(i)) {
        case '(': {
            if(close > 0 ) {
                close--;
            } else {
                remove[i] = true; //mark and remove non matching brackets
                //System.out.println("close---->remove " + i);
            }
            break;
        }
        case ')': {
            close++;
            break;
        }
        default: {
        //do nothing
        break;
        } 
        } 
    }    
   //System.out.println("close:" + close);
    
    
    //Build String builder
    for(int i=0; i <= length -1 ; i++) {
        if(!remove[i]) {
            output.append(input.charAt(i));
        }
    }

    return output.toString();
   }
   
   
    public static void main(String[] args) {
        String input1 =  "ab)a(c)fg)a";
        System.out.println(removeBracket(input1));
        String input2 =  "ab(a(c)fg)9)))";
        //System.out.println(removeBracket(input2));
        String input3 =  ")a(b)c()(5";
        //System.out.println(removeBracket(input3));
        String input4 =  ")(";
        System.out.println(removeBracket(input4));
        String input5 =  "a(b))";
        //System.out.println(removeBracket(input5));
       
        
    }
}
