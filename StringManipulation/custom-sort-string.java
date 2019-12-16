
https://leetcode.com/problems/custom-sort-string/
//basically find the intersection of two strings, and add it to string builder
//and finally append what ever is not intersecting in second string T to string builder



class Solution {
public String customSortString(String S, String T) {
        //use a set here
        Set<Character> set = new HashSet<>();
        //use a string builder here
        StringBuilder sb = new StringBuilder();
        //for every character in the first string
        for (char c : S.toCharArray()){
            // check if it is present in the second string
            for (int i = 0; i < T.length(); i++){
                if (T.charAt(i) == c){
                    //if present the append it to String builder
                    sb.append(c);
                }
            }
            //add the character to the set
            set.add(c);
        }
        // now for every character in the second String
        for (char c : T.toCharArray()){
            //if set does not contain the character, then add it to String builder
            if (!set.contains(c)){
                sb.append(c);
            }
        }
        //return the string
        return sb.toString();
    }
}
