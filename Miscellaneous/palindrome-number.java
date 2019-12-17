https://leetcode.com/problems/palindrome-number/

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = x;
        int output = 0;
        while(num != 0) {
            output = output * 10 + (num %10);
            num = num/10;
        }
        System.out.println(" the output is " + output);
        if(output == x) return true;
        else return false;
    }
}
