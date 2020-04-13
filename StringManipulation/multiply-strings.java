
class Solution {
    
    //https://leetcode.com/problems/multiply-strings/
    //i initially solved this by adding everything to stringbuilder and when i convert to a number it gave lot of problems in converting
    
    ***BackFill in an array***
    //have an array with size m + size n
    // start filling from the end
    // the carry goes to one slot before the end 
    //repeat this in loop
    //finally copy this to a stringbuilder by making sure you elimiate the first few zero's in front of the array
    //return the SB.toString()
    
     //Time complexity : m *n
    //Space complexity : m +n


/*
num1 = "123"
num2 = "456
====================================
first loop starts from end 
the sum is 18(6*3 + (earlier value which zero))
 the array contains [0, 0, 0, 0, 1, 8] 
 the sum is 16(5*3 + 1(earlier value))
 the array contains [0, 0, 0, 1, 6, 8] 
 the sum is 13(4*3 + 1(earlier value))
 the array contains [0, 0, 1, 3, 6, 8] 
 ====================================
 second loop , starts from end-1
 the sum is 18(6* 2 + 6(earlier value))
 the array contains [0, 0, 1, 4, 8, 8]
 the sum is 14(5* 2 + 4(earlier value))
 the array contains [0, 0, 2, 4, 8, 8]
 the sum is 10(4*2 + 2(earlier value))
  the array contains [0, 1, 0, 4, 8, 8]
 ====================================
 third loop , starts from end-2
 the sum is 10(6* 1 + 4(earlier value))
 the array contains [0, 1, 1, 0, 8, 8]
 the sum is 6(5* 1 + 1(earlier value))
 the array contains [0, 1, 6, 0, 8, 8]
 the sum is 5(4* 1 + 1(earlier value))
 the array contains [0, 5, 6, 0, 8, 8]


*/
    
    public String multiply(String num1, String num2) {
        String output = null;
        if(num1 == null || num2 == null) return output;
        int[] backfillArray = new int[num1.length()+num2.length()]; //contains all zeros[0,0,0,0,0,0]
        
        for(int i = num1.length()-1; i >= 0; i--) {
            for(int j = num2.length()-1; j >= 0; j--) {
                int end = i+j+1;//end of the array // for SUM 
                int priorToEnd = i+j;//one slot before the end of the array for CARRY
                int sum = ((num1.charAt(i)-'0') * (num2.charAt(j)-'0')) + backfillArray[end];
                //System.out.println(" the sum is " +  sum);
                backfillArray[end] = sum %10; //end will always contains SUM%10
                backfillArray[priorToEnd] = backfillArray[priorToEnd] + (sum /10);// PRIOR TO END contains earlier + (sum/10)
                //System.out.println(" the array contains " +  Arrays.toString(backfillArray));
            }        
        }
        StringBuilder SB = new StringBuilder();
        for(int p : backfillArray) {
            if(!(SB.length() == 0 && p == 0)) {
                SB.append(p);
            }
        }
        output = (SB.length() == 0? "0":SB.toString());
        return output;
        
    }
}

