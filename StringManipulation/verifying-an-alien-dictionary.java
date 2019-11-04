
//https://leetcode.com/problems/verifying-an-alien-dictionary/
class Solution {
    
    static int[] mapper = new int[26];
    //given the words and order
    public boolean isAlienSorted(String[] words, String order) {
        //store all the indexes of the order in the mapper table
        for(int i = 0 ; i < order.length() ; i++) {
            mapper[order.charAt(i) - 'a'] = i;
        }
        //now compare the words in the array
        for (int j = 1; j < words.length; j++) {
            if(bigger(words[j-1],words[j])) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean bigger(String str1, String str2) {
        int L1 = str1.length();
        int L2 = str2.length();
        //run the loop for both the words
        System.out.println(" String1 " + L1 + " String2 " + L2);
        for(int i = 0; (i < L1) && (i < L2) ; i++) {
            //compare the characters, and where they are present in the mapper table
            //basically comparing indexes stored in mapper table
            //if it does not satsify the lexicographical order , and if STR1 > STR2 , then immediately
            //return false
            //Example 1 and 2 case will come here
            //System.out.println("i value is " + i);
            //System.out.println(" comparing " + str1.charAt(i) + " "  + str2.charAt(i));
            //System.out.println(" Index     " + mapper[str1.charAt(i) - 'a']  + " "  + mapper[str2.charAt(i) - 'a']);
            //compare the first unequal character and check which one is greater
            if(str1.charAt(i) != str2.charAt(i)) {
                return (mapper[str1.charAt(i) - 'a'] > mapper[str2.charAt(i) - 'a']);
            }
        }
        //Example 3 case will come here
        // if we are returning here that means the order is maintained so far for both strings
        //but if the length are unequal , then the one longer is lexicographically larger 
        System.out.println("return 2 ");
        return (L1 > L2);
    }
}
