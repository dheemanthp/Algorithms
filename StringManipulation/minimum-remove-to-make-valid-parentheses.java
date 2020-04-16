//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/


/*Intuition
To make the string valid with minimum removals, we need to get rid of all parentheses that do not have a matching pair.

Push char index into the stack when we see '('.

Pop from the stack when we see ')'.

If the stack is empty, then we have ')' without the pair, and it needs to be removed.
In the end, the stack will contain indexes of '(' without the pair, if any. We need to remove all of them too.

Update: check out the new approach 2 that collects indexes of all mismatched parentheses, and removes them right-to-left.

Approach 1: Stack and Placeholder
We mark removed parentheses with '*', and erase all of them in the end.

Java*/

class Solution {
public String minRemoveToMakeValid(String s) {
    
    // if you find open bracket the push the index to stack
    // if you find close bracket pop it out
    // if you find additional close bracket , then mark it by adding a "*" in stringBuilder
    // if you find additional open bracket in stack then mark it by adding a "*" in stringBuilder
    // finall replace all * by empty
    // and return the String.
    //12:35 am
    if(s == null || s.length() == 0) return s;
    Stack<Integer> St = new Stack<>();
    
    StringBuilder SB = new StringBuilder(s);
    for(int i =0 ;i < s.length() ; i++) {
        
        if(s.charAt(i) == '(') St.push(i);
        if(s.charAt(i) == ')') {
            if(!St.empty()) {
                St.pop();                
            } else{
               SB.setCharAt(i,'*'); // mark additional closed bracket
            }
        }
    }
    //let us say stack is not empty
    while(!St.empty()) {
        SB.setCharAt(St.pop(),'*'); // mark additional open bracket
    }
    
    return SB.toString().replaceAll("\\*","");
    
    //System.out.println(SB.toString());
    //return SB.toString();
 }
}
  //12:46pm complete coding , and also perfect output and submitted  










class Solutionitried {
    //12:10 am
    //logic is simple:
    //1) in order to find out invalid closed bracket, come from left to right
    //2) in roder to find out invalid open bracket , come from right to left
    
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0) return s;
        boolean[] marker = new boolean[s.length()];
        int open = 0;
        //in order to find invalid closed brackets
        for(int i=0;i < s.length();i++) {
            char c = s.charAt(i);
            switch(c) {
            case '(' : {open++; }
                    break;
            case ')' : {
                if(open > 0) {
                    open--;
                } else{
                    marker[i] = true;
                }
                
            }
                    break;
                default: System.out.println(" passthrough for checking invalid closing brackets");
                         break;
            }//end of switch
        }//end of forloop
        int close = 0;
                //in order to find invalid open brackets
        for(int j=s.length()-1; j>= 0;j--) {
            char c = s.charAt(j);
            switch(c) {
              case ')' : { close++; }
                    break;
              case '(' : {
                  
                  if(close >0) {
                      close--;
                  } else{
                      marker[j] = true;
                  }
              }
                break;
                default: System.out.println(" passthrough for checking invalid open brackets");
                         break;

            }//end of switch
        }//end of for loop
        
        StringBuilder SB = new StringBuilder();
        for(int k = 0; k < s.length(); k++) {
            if(marker[k] == false) {
                SB.append(s.charAt(k));
            }
        }
        
        return SB.toString();
    }
}
//12:22 coding complete
//12:25 code compiled at 12:25 , output error
//12:26 perfect output and code submitted



//Idea is very simple , check for balance by performing 2 sweeps
//when you go from left to right , if you find extra close braces mark it
//when you go from right to left , if you find extra open braces mark it
//finally ensure to build the string , by checking the marker

//LEFT TO RIGHT
//Mark all the unwanted closed braces from Left to right
//RIGHT TO LEFT
//Mark all the unwanted open braces from right to left
//Finally based on the marker , Build the string


class Solutionperfect {
     public String minRemoveToMakeValid(String s) {
       if(s == null) return null;
    StringBuilder output = new StringBuilder();
    //Remove array used as Marker to note unwanted Open and Unwanted close brances
    boolean[] remove = new boolean[s.length()];

    int open = 0;
    //check for all open braces , and decrement if you see a close
    //if you find extra close brace then mark it
    //first parse to find extra close braces , 
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') open++;
            else if(s.charAt(i) == ')'){
                if(open > 0) open--;
                
                //mark the bracket that needs to be removed , as open value is 0
                else {
                    System.out.println("remove here , and the open value is " + open);
                    System.out.println(" the index is " + i);
                    remove[i] = true;
                }
            } else{
                //valid character
            } 
        }       
    int close = 0;
    //check for all close braces , and decrement if you see a open brace
    //if you find extra open brace then mark it
    //second parse to find extra open braces
    for(int i=s.length() -1; i >=  0; i--) {
            if (s.charAt(i) == ')') close++;
            else if(s.charAt(i) == '('){
                if(close > 0) close--;
                //mark the bracket that needs to be removed , as close value is zero
                else {
                    System.out.println("remove here , and the close value is " + close);
                    remove[i] = true;
                }
            } else{
                //valid character
            } 
        }       

    //Build String builder, remove all the brackets from remove array
    for(int i=0; i <= s.length() -1 ; i++) {
        if(!remove[i]) {
            output.append(s.charAt(i));
        }
    }
    return output.toString();
   }
}


