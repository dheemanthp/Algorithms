
https://leetcode.com/problems/reorder-data-in-log-files/

//we will be using a custom sort
class Solution {
    public String[] reorderLogFiles(String[] logs) {
      //we use a comparator here
       Comparator<String> myComp = new Comparator<String>() {
         
         //compare 2 strings s1 and s2
         public int compare(String s1, String s2) {
           //split the first and second part of the string
           //this is enough to understand if the second word is a letter or a digit
           String[] split1 = s1.split(" ", 2);
           String[] split2 = s2.split(" ", 2);
           //2nd part  , first character
           boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
           boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
           //if both are not digits compare the character  
           if(!isDigit1 && !isDigit2) {             
             //compare the second part's  
             int comp = split1[1].compareTo(split2[1]);
             //if it is not zero 
             if(comp != 0)
              return comp; //return 1 or -1
              return split1[0].compareTo(split2[0]);//if zero , then compare the first part , and return  
           }
             return isDigit1 ? (isDigit2 ? 0 : 1) : -1; //compare the digits in the second part and return
         }
       };
       //Sort by passing the custom comparator
       Arrays.sort(logs, myComp);
       //Arrays.sort(logs); if we dont pass custom comparator then it will do normal sort
       return logs;
    }
}

/* BAD SOLUTION as it is not lexicographically sorted

    class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        int[] marker = new int[logs.length];
        //for every string , check if one of the two cases
        //if digit , mark it as -1
        //if lowercase letters , mark it as -2
        int i = 0;
        for(String str : logs) {
            
            System.out.println("the str is " + str);
            String[] splitter = str.split(" ");
            if(Character.isDigit(splitter[1].charAt(0))){
                System.out.println("the i value is " + (i) + " isDigit()");
                marker[i] = -1;
            } else {
                marker[i] = -2;
                System.out.println("the i value is " + (i) + " isLetter()");
            }
            System.out.println("the i value is " + i);
            i++;
        }
        String[] output = new String[logs.length];
        int k = 0;
        for(int j =0; j< logs.length;j++){
            
            if(marker[j] == -2) {
             output[k++] = logs[j];
                System.out.println(logs[j]);
            }
        }
        for(int m =0; m< logs.length;m++){
            if(marker[m] == -1) {
             output[k++] = logs[m];
                System.out.println(logs[m]);
            }
        }
        return output;
    }
}*/


