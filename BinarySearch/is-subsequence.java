
//https://leetcode.com/problems/is-subsequence/
has a Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by 
one to see if T has its subsequence. In this scenario, how would you change your code?


/**
 * Follow-up
 * If we check each sk in this way, then it would be O(kn) time where k is the number of s and t is the length of t. 
 * This is inefficient. 
 * Since there is a lot of s, it would be reasonable to preprocess t to generate something that is easy to search for if a character of s is in t. 
 * Sounds like a HashMap, which is super suitable for search for existing stuff. 
 * and hashmap contains character and list of indexes 
 * HashMap < Character,List<Integer>> H = new HashMap<>();
 */

public class Solution {

    //Follow up: Binary search for multiple coming string
    public boolean isSubsequence(String s, String t) {
        //O(t.length())
        //preprocess using a hashmap of all the characters contained in string t
        //and all the indexes contained in a list , specific to every character
        //now we can do a binary search depending 
        Map<Character, List<Integer>> myMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!myMap.containsKey(t.charAt(i))) {
                myMap.put(t.charAt(i), new ArrayList<Integer>());
            }
            myMap.get(t.charAt(i)).add(i);
        }
        
        //search: O(s.length() * log(t.length()))
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch= s.charAt(i);

            int nextIndex = getNextIndex(myMap.get(ch), index);
            if (nextIndex < 0) return false;
            index = nextIndex;
        }
        
        return true;
    }
    //doing a binary search on the list contained in the Hashmap
    public int getNextIndex(List<Integer> list, int index) {
        if (list == null) return -1;
        int left = 0, right = list.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= index) left = mid + 1;
            else right = mid;
        }
        //beyond the index return value at index position "left" otherwise return -1
        return list.get(left) > index ? list.get(left) : -1;
        
    }

}


class SolutionAlternative1 {
    //two pointer: only one input string
    public boolean isSubsequence(String s, String t) {
        int i = 0 ,j = 0;
        while(i< s.length() && j <t.length()) {
             if(s.charAt(i) == t.charAt(j)) {
                 i++;j++;
             } else {
                 j++;
             }
        }
        if(i >= s.length()) return true;
        else return false;
    }
}
    
 class SolutionAlternative2 {   
    //two pointer: only one input string
    public boolean isSubsequence(String s, String t) {
        if(s == null) return true;
        if(t == null) return false;
        
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            j = t.indexOf(s.charAt(i), j);
            if (j < 0) return false;
            j++;
        }
        
        return true;
    }
}
