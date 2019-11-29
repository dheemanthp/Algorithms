
//https://leetcode.com/problems/word-break/


//Time complexity : O(n^2). Two loops are their to fill \text{dp}dp array.
//Space complexity : O(n). Length of dp marker array is n+1n+1.

public class Solution {
    
public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.isEmpty()) {
			return false;
		}
        //add all the dictionary words into a Set
        Set<String> H = new HashSet(wordDict);
		int len = s.length();
        //marker
		boolean[] dp = new boolean[len];
        //go the full length of string
		for (int i = 0; i < len; i++) {
            //for every segment starting from 0 to i , check if the word is present in the dictionary
			for (int j = 0; j <= i; j++) {
				// NOTE: we are going to update dp only for below two scenarios, so avoided
				// making unecessary computation until this condition is met
                //when j i is 0 , or 
				if (j == 0 || dp[j - 1]) {
					String sub = s.substring(j, i + 1);
					if (H.contains(sub)) {
						dp[i] = true;
					}
				}
			}
		}
		return dp[len - 1];
	}
}

class SolutionMyInitialapproach {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s == null || s.length() == 0) return false;
        
        //add all the dictionary words into a Set
        Set<String> H = new HashSet(wordDict);
        /*for(String str : wordDict) {
            H.add(str);
        }*/
        //we can use a two pointer stratergy
        int j = 0;//latch j , while we move i
        int i;
        for(i = 0 ;i <= s.length(); i++) {
            //if the substring is contained in the word dictionary the reset j
            //go over every wordDict
            if(H.contains(s.substring(j,i))){
                j = i;
            }
        }
        System.out.println("the value of j is " + j);
        System.out.println("the value of i is " + i);
        return ( j == (i-1)) ? true: false;
    }
}
