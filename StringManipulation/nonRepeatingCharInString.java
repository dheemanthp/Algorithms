Using HashMap
import java.util.*;

public class MyClass {
    
    public static char nonRepeatingCharsInString(String str) {
        //will store Characters, index
        //if repeat just make the index value as negative
        HashMap<Character,Integer> H = new HashMap<>();
        for (int i = 0 ; i < str.length() ;i ++) 
        {
            if(H.containsKey(str.charAt(i))) {
                H.put(str.charAt(i),-1);
            } else{
                H.put(str.charAt(i),i);
            }
        }
        Integer min = Integer.MAX_VALUE;        
        for(Character key : H.keySet()) {

            if(H.get(key) != -1) {
                min = Math.min(H.get(key),min);
            }
        }
        return str.charAt(min);
    }
    
    public static void main(String args[]) {

        System.out.println(nonRepeatingCharsInString("geeksforgeeks"));
    }
}


//====================================================================================================
import java.util.*;

public class Main {
    
  
  //Below is using linked list
    static char  func1 (String str) {
        
    if(str == null) return 0;
    
    LinkedList<Integer> LL = new LinkedList<>();
    for(int j = 0; j< 256 ; j++ ) {
       LL.add(-1) ;
    }
    
    for(int i = 0; i< str.length() -1 ; i++ ) {
        if(LL.get(str.charAt(i)) == -1 ) {
            LL.set(str.charAt(i),i);
        } else {
            LL.set(str.charAt(i),-2);
        }
    }
    int result = Integer.MAX_VALUE;
    
    for(int j = 0; j< 256 ; j++ ) {
        if(LL.get(j) != -1 && LL.get(j) != -2) {
            result = Math.min(result,LL.get(j)) ;
        }
    }
    return str.charAt(result);    
}
    
    
    
   //below is using integer array
   static char  nonRepeatingCharInString (String str) {

    if(str == null ) return 0;
    int length = str.length();
    if(length == 0 ) return 0;
    
    int[] output = new int[256];
    //fill all the numbers with -1
    for (int i = 0 ; i < 256 ; i++) {
        output[i] = -1;
    }
    //now if the number repeats add -2 , else add the index
    for (int j = 0 ; j < length -1 ; j++) {
        if(output[str.charAt(j)] == -1) {
            output[str.charAt(j)] = j; 
        } else {
            output[str.charAt(j)] = -2; 
        }
    }
    
    int result = Integer.MAX_VALUE;
    for (int k = 0 ; k < 256 ; k++) {
       if(output[k] != (-2) && output[k] != (-1) ) {
         System.out.println(" the output is " + output[k]); 
         result = Math.min(result,output[k]);
       }
    }
    return str.charAt(result);    
}

public static void main(String[] args) {
    
    String test1 = "apple";
    char c = nonRepeatingCharInString(test1);
    String test2 = "racecars";
    char d = nonRepeatingCharInString(test2);
    String test3 = "ababdc";
    char e = nonRepeatingCharInString(test3);
    System.out.println("the output is :" + c);
    System.out.println("the output is :" + d);
    System.out.println("the output is :" + e);
    System.out.println(nonRepeatingCharInString("GeeksForGeeks"));
    System.out.println(nonRepeatingCharInString("GeeksFor"));
}
}
