

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    public int evalRPN(String[] tokens) {
      
    if(tokens == null) return 0;  
    if(tokens.length == 1) {
      return Integer.parseInt(tokens[0]);
    }

    if(tokens.length == 2 || tokens.length == 0) {
      System.out.println("Return as the length is less than two");
      return 0;
    }
    Stack<Integer> S = new Stack<>();
    int  num1 , num2;
    int result = 0;
    for (int i = 0 ;i< tokens.length; i++) {  
    String input = tokens[i];
    System.out.println("the input token string is  " + input);
    //StringTokenizer st = new StringTokenizer(input);
    char C = input.charAt(0);
      switch(C) {
          
        case '+' : { num1 = S.pop();
                     num2 = S.pop();
                    System.out.println("Addition " + num1 + " " + num2);
                    result = num1 + num2;
                    S.push(result);
                    break;
        }  
          
        case '-' : {
                    //special case , where the input string can contain negative value
                    if(input.length() > 1) {
                      S.push(Integer.parseInt(input));
                      System.out.println("the negative  " + input) ;
                      break;
                    } 
          
                    num1 = S.pop();
                    num2 = S.pop();
                    System.out.println("Subtraction " + num1 + " " + num2);
                     result = num2 - num1;  
                    S.push(result);
                    break;
        }  
        case '/' : { num1 = S.pop();
                     num2 = S.pop();
                    System.out.println("Division " + num1 + " " + num2);
                     result = num2 / num1;      
                    S.push(result);
                    break;
        }  
        case '*' : { num1 = S.pop();
                     num2 = S.pop();
                    System.out.println("Multiplication " + num1 + " " + num2);
                     result = num1 * num2;      
                    S.push(result);
                    break;
        }  
        default : {
          S.push(Integer.parseInt(input));
          System.out.println("Default case push " + input);
          break;
          
        }
      }//end of switch
    }//end of for loop   
        return result;
    }
    
    public static void main(String[] args) {
      Solution Sol =  new Solution();
      String[] tokens1 = {"2", "1", "+", "3", "*" };
      System.out.println("the output is : " + Sol.evalRPN(tokens1));
      String[] tokens2 = {"4", "13", "5", "/", "+" };
      System.out.println("the output is : " + Sol.evalRPN(tokens2));
      String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
      System.out.println("the output is : " + Sol.evalRPN(tokens3));
      String[] tokens4 = {"2"};
      System.out.println("the output is : " + Sol.evalRPN(tokens4));
      String[] tokens5 = {"2" , "3"};
      System.out.println("the output is : " + Sol.evalRPN(tokens5));
      String[] tokens6 = {};
      System.out.println("the output is : " + Sol.evalRPN(tokens6));


      
      
    }   
}
