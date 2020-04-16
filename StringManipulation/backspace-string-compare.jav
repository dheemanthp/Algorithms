

class Solution {
    //https://leetcode.com/problems/backspace-string-compare/
    public boolean backspaceCompare(String S, String T) {
        
        if(S == null || T == null) return false;
        
        String first = resolve(S);
        String second = resolve(T);
        return first.equals(second);
    }
    
    //logic
    //push every character into stack , as soon you see a "# pop out from the stack
    //finally build from the stack
    String resolve(String str) {
        int len = str.length();
        Stack<Character> S = new Stack<>();
        StringBuilder SB = new StringBuilder();
        for (int i = 0;i < len ; i++) {
            
            if(str.charAt(i) == '#') {
                if(!S.isEmpty()) S.pop();
            } else {
                S.push(str.charAt(i));
            }
        }
        //go over the stack , and ensure to use the String Builder to Build the string
        while(!S.isEmpty()) {
            SB.append(S.pop());
        }
        
        return SB.toString();
    }
}
