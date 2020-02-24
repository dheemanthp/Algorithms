
Running time is 


class Solution {
    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    //Running it  3 * 3 for 2 digits 
    //Running it  3 * 3 * 3 for 3 digits 
    // Hence it is 3 ^ N for N digits

    
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        String[] mapping = {
         "0",
         "1",
         "abc",
         "def",
         "ghi",
         "jkl",
         "mno",
         "pqrs",
         "tuv",
         "wxyz" };
         
        // "" is the combination
        // 0 is the current index
        letterCombinationsRecursive(result,digits,"",0,mapping);
        return result;
    }
    
    
    public void letterCombinationsRecursive(List<String>result,String digits,String combination,int index,String[] mapping) {
     //base case where you need to return
        //if(combination.length() == digits.length()) {
        if(index == digits.length()) {
            result.add(combination);
            return;
        }
        //fetch the String from the mapping table
        //this basically considers a specific digit value , for example 2 , and gets initializes letters = "abc";
        String letters = mapping[digits.charAt(index) - '0'];

        for (int i = 0 ;i < letters.length() ; i++) {
            letterCombinationsRecursive(result,digits,combination + letters.charAt(i),index + 1 ,mapping);
        }
    }
    
}
