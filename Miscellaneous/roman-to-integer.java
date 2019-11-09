//https://leetcode.com/problems/roman-to-integer/

/*Really easy to read and understand solution without the need for complicated checks.
100% faster, and 100% more storage efficent according to when I submitted this problem.

Simply adding up every roman numeral in one loop
and then one loop to subtract the extra in the special cases.*/

class Solution {
    public int romanToInt(String s) {
        int total = 0; //a total counter for our return
		//going through each char in the string and adding the corresponding value to total
        for(int i=0; i<s.length(); i++)
        {
            switch(s.charAt(i))
            {
                case 'I':
                    total+=1;
                    break;
                case 'V':
                    total+=5;
                    break;
                case 'X':
                    total+=10;
                    break;
                case 'L':
                    total+=50;
                    break;
                case 'C':
                    total+=100;
                    break;
                case 'D':
                    total+=500;
                    break;
                case 'M':
                    total+=1000;
                    break;
            }
        }
		//going back through the array once more and checking for special cases and subtracting that
		//ex. IV first step 1+5 = 6, second step the if statement sees an I before a V so it subtracts 2 from total
		//IV second step 6-2 = 4, and then we can return 4
        for(int j=0; j<s.length()-1; j++)
        {
                  if(s.charAt(j)==('I') && s.charAt(j+1)==('V')) total-=2;                   
             else if(s.charAt(j)==('I') && s.charAt(j+1)==('X')) total-=2;
             else if(s.charAt(j)==('X') && s.charAt(j+1)==('L')) total-=20;
             else if(s.charAt(j)==('X') && s.charAt(j+1)==('C')) total-=20;
             else if(s.charAt(j)==('C') && s.charAt(j+1)==('D')) total-=200;
             else if(s.charAt(j)==('C') && s.charAt(j+1)==('M')) total-=200;
        }
        return total;
    }
}
