//https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        //keep pushing open braces on to the stack until you encounter an closed bracket
        Stack<Character> C = new Stack<>();
        char prev;
        for(int i = 0 ;i < s.length() ;i++) {
            //push all the open braces
            switch(s.charAt(i)) {
                case '(' :
                case '{' :
                case '[' : { C.push(s.charAt(i));
                            break;
                }
            //as soon as you encounter close braces , pop and check
                case ')' : {
                    if(C.size() == 0) return false;
                    prev = C.pop();
                    if(prev != '(') {
                        return false;
                    }
                    break;
                }
                case '}' : {
                    if(C.size() == 0) return false;
                    prev = C.pop();
                    if(prev != '{') {
                        return false;
                    }
                    break;
                }
                case ']' : {
                    if(C.size() == 0) return false;
                    prev = C.pop();
                    if(prev != '[') {
                        return false;
                    }
                    break;
                }
                default: break;
            }
        }
        if(C.size() == 0) {
            return true;
        } else{
            return false;
        }
    }
}
