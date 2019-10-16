/*
https://webcache.googleusercontent.com/search?q=cache:iTgLVqb7nXsJ:https://leetcode.com/discuss/interview-question/398043/microsoft-oa-2019-word-wrap+&cd=1&hl=en&ct=clnk&gl=us
Given a string s and an integer k. Break the string in such a way that:

    The resulting string should not contain parts of a word.
    The resulting string should not contain spaces.
    If the size of k is greater than length of given string then return the given string as it is.

Example 1:

Input: s = "Codility We test coders", k = 14
Output: "Codility We"
Explaination: If we split until 14 characters then output will be "Codility We te", but since "te" is part of a word so ignore that.
Also notice we ignore the space after "We" and "test" in our output.

Example 2:

Input: s = "The quick brown fox jumps over the lazy dog", k = 39
Output: "The quick brown fox jumps over the lazy"

Example 3:

Input: s = "Why not", k = 39
Output: "Why not"
Explaination: Since the size of 'k' is greater than the length of given string so we return the string as it is.



/*/


public class Solution {

//O(n) with extra space of a string builder
    private static String getWordWrap(String s, int k) {
       //split all words
    	String[] sArr = s.split(" ");
        //string builder
    	StringBuilder sb = new StringBuilder();
    	int cnt = 0;
        //check every every word 
    	for(int i=0;i<sArr.length;i++) {
                //count the length of the string + 1 space
    		cnt += sArr[i].length() + 1;
    		System.out.println("count: " + cnt);
                //if count is greater than k+1
    		if(cnt > k+1) {
    			if(sb.length() > 0) {
    			        // Adding a new word will exceed the required length , hence do not add any new words,
    			        //just trim the space at the end of the already built word, and return
    			    	System.out.println("Delete: " + sb.toString() + ":at location" + (sb.length() - 1));
    				    sb.deleteCharAt(sb.length() - 1);
    			}
    			System.out.println("output: " + sb.toString());
    			return sb.toString();
    		}
                //otherwise append the new string to the string builder
    		sb.append(sArr[i] + " ");
    		System.out.println(sb.toString());
    	}
        //just return sb in this case
    	return sb.toString();
    }

    public static void main(String[] args) {
    	String s1 = "Codility We test coders"; int k1 = 14;
    	String s2 = "The quick brown fox jumps over the lazy dog"; int k2 = 39;
    	String s3 = "Why not"; int k3 = 39;
    	String s4 = "Codility We test coders"; int k4 = 2;
    	System.out.println(getWordWrap(s1, k1));
    	System.out.println(getWordWrap(s2, k2));
    	System.out.println(getWordWrap(s3, k3));
    	System.out.println(getWordWrap(s4, k4));
    }
}
