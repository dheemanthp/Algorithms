class Solution {
//https://leetcode.com/problems/add-strings/
    public String addStrings(String num1, String num2) {
        int carry = 0;
        //mutable
        StringBuilder SB = new StringBuilder();
        for(int i = num1.length()-1, j = num2.length()-1 ; i >= 0 || j >=0 || (carry ==1 ); i--,j--) {
            
            int x = (i >= 0) ?(num1.charAt(i) - '0') : 0;
            int y = (j >= 0) ?(num2.charAt(j) - '0') : 0;
            System.out.println(" the value of x " +x + " and the value of y " +y + " and carry is " + carry);
            SB.append((x+y+carry) % 10);
            carry = (x+y+carry)/10;
        }
        return SB.reverse().toString();        
    }
}
