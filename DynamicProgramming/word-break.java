
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

/*
//just executed each step
Hope it helps
|T| | | | | | | | |
0 1 2 3 4 5 6 7 8

i = 1
j = o sub = l

i = 2
j = 0 sub = le
j = 1 sub = e

i = 3
j = 0 sub = lee
j = 1 sub = ee
j = 2 sub = e

i = 4
j = 0 sub = leet && T[0] and then break, no need to check for rest
|T | | | |T| | | | |
0 1 2 3 4 5 6 7 8

i = 5
j = 0 sub = leetc
j = 1 sub = eetc
j = 2 sub = etc
j = 3 sub = tc
j = 4 sub = c

i = 6
j = 0 sub = leetco
j = 1 sub = eetco
j = 2 sub = etco
j = 3 sub = tco
j = 4 sub = co
j = 5 sub = o

i = 7
j = 0 sub = leetcod
j = 1 sub = eetcod
j = 2 sub = etcod
j = 3 sub = tcod
j = 4 sub = cod
j = 5 sub = od
j = 6 sub = d

i = 8
j = 0 sub = leetcode
j = 1 sub = eetcode
j = 2 sub = etcode
j = 3 sub = tcode
j = 4 sub = code && T[4] and then break

|T| | | |T| | | | T|
0 1 2 3 4 5 6 7 8
*/

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
