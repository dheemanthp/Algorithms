
//https://www.geeksforgeeks.org/reverse-digits-integer-overflow-handled/
//https://leetcode.com/problems/reverse-integer/

//Ensure to handle overflow and negative values.

class Solution {
    public int reverse(int x) {
        int result = 0,prevResult = 0;
        boolean sign = false;

        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
        
        if(x < 0 ) {
            sign = true;
            x = Math.abs(x);
        }
        
        while(x!=0) {
            
            result  = result*10 + x%10;
        // checking if the reverse overflowed or not. 
        // The values of (rev_num - curr_digit)/10 and 
        // prev_rev_num must be same if there was no 
        // problem. 
            if(prevResult != (result- (x%10))/10) {
              System.out.println("overflow happened");
              return 0;
            }
            prevResult = result;
            x = x/10;
        }
        return (sign?-result:result);        
    }
}
