https://leetcode.com/problems/valid-parenthesis-string/submissions/
/*
Think this might be logically easiest solution for this problem.
Check from left to right and then check from right to left.
When check from left to right, take all '*'s as '(', to see whether can match all ')'s.
And, When check from right to left, take all '*'s as ')', to see whether can match all '('s.
If at any time the balance goes to negative , it is invalid.
If the balance is positive then the string is valid.
p.s. Thanks to @vagnihotri1117, we can return true if the first check returns bal=0.
*/

class Solution {
    public boolean checkValidString(String s) {
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            //System.out.println(" the first loop i value is " + i);
            if (s.charAt(i) == '(' || s.charAt(i) == '*') bal++;
            else {
                if(bal > 0) bal--;                
                else return false;
            } 
        }
        //System.out.println(" after first loop the balance is " + bal);
        if (bal == 0) return true;
        bal = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            //System.out.println(" the second loop i value is " + i);
            if (s.charAt(i) == ')' || s.charAt(i) == '*') bal++;
            else {
                if(bal > 0) bal--;                
                else return false;
            } 
        }
        //System.out.println(" after second loop the balance is " + bal);
        return true;
    }
}

/*
//This below solution does not work , use only the above approach
//"((*)(*))((*" --> fails
class Solution {
    public boolean checkValidString(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        
        Stack<Character> S = new Stack<>();
        int countAsterisk = 0;
        int open = 0;
        for(int i=0 ; i< s.length() ;i++) {
            switch(s.charAt(i)) {
                case '(':S.push(')');open++;break;
                case '*': countAsterisk++;break;
                default: {
                    //case Input: "()"
                    if(!S.isEmpty() && S.peek() == s.charAt(i)) {
                        open--;
                        S.pop();
                        break;
                    }
                    //case Input: "*)"
                    //(if(!S.isEmpty() && countAsterisk != 0) {
                    //    S.pop();countAsterisk--;
                    //    break;
                    //}

                    //case Input: "(*))"
                    if(S.isEmpty() && countAsterisk != 0) {
                        countAsterisk--;
                        break;
                    }
                        return false;
                }
            }            
        }
        System.out.println(" Stack size " + S.size() + "& asterisk count" + countAsterisk);
        if(S.isEmpty() || S.size() <= countAsterisk) {
            return true;
        } else {
        return false;
        }
    }
}*/
