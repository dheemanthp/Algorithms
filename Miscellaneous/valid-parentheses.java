//https://leetcode.com/problems/valid-parentheses/
//When you encounter open braces , Push only closed Braces
class Solution {
    public boolean isValid(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;
        
        //When you encounter open braces , Push only closed Braces
        //when you encounter closed brances , peek stack to check if equal , if yes , the move forward
        // if no , then return.
        Stack<Character> C = new Stack<>();
        char prev;
        //char[] charArray = s.toCharArray();
        for(int i = 0 ;i < s.length() ;i++) {
            
            switch(s.charAt(i)) {
                //Push Only Closing Brackets
                case '(' : C.push(')');break;
                case '{' : C.push('}');break;
                case '[' : C.push(']');break;
                default:
                    //Return false if there is no match
                    if(C.isEmpty() || s.charAt(i) != C.peek()) { 
                        return false;
                    } else{
                        C.pop();
                    }
                break;
            }
        }
        if(C.size() == 0) return true;
        return false;
    }
}

//Alternative Solution
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
