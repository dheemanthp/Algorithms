
/*
The count-and-say sequence is the sequence of integers beginning as follows: 1, 11, 21,
1211, 111221, ...

1   -> count * 10 + 1  , always come from left side
left 11 right  -> 2*10 + 1 = 21   
21 ---->  1*10 + 2 = 12 , 1*10 + 1 = 11
1211 ---> 1*10 + 1 = 11, 1 * 10 + 2 = 12, 2 * 10 + 1 = 21
111221
312211
*/

/* divide ->121
mod will 1

1211 % 10 = 1
1211 / 10 = 121.1

1211 / 10    10 (1211) = 121, remainder = 1 

(1211 - 1 * 1000) = 211
211 - 2 * 100 =  11
11 - 1 * 10 = 1
1 - 1 * 0 = 1 */
 

 
//ignore large number not supported by int , also you can make use of double to accomodate large numbers




//clause is the count should be for same number

class Solution {

//how many iterations
String print_sequence(int value, int num) {
//recursive or iterative function
String result = helper(0, value, num);

return result;
}

String helper (int i, int limit , int num) {
//base case
if( i == limit || limit == 0) return "";
//input number
int input = num;
//count the numbers within a give number
int count = 0;
while (num != 0) {
  num = num/10;
  count++;
}
//System.out.println(" length of the input " + count);

StringBuilder SB = new StringBuilder();
int prevlhs = 0;int lhs = 0;int rhs = 0;
int counter = 0;
while (input != 0 || count != 0){
  //System.out.println(" Beginning of the while loop " + input);
  int divisor = (int) Math.pow(10,count-1); 
  lhs = input/divisor; // 1
  //System.out.println(" LHS " + lhs);
  rhs = input - (lhs * divisor); // 111
  //System.out.println(" RHS " + rhs);
  //System.out.println(" prevlhs " + prevlhs);
  if(prevlhs != 0 && prevlhs != lhs) {
    //System.out.println("==========================================");
    //System.out.println("before reset" + Integer.toString(counter) + " " + Integer.toString(prevlhs));
    //System.out.println("==========================================");
    SB.append(Integer.toString(counter) + Integer.toString(prevlhs));
    
    counter = 1;
  } else {
    counter ++;
  }
  count--;
  prevlhs = lhs;
  input = rhs;
  //System.out.println(" Ending of the while loop " + input);
  
}
    SB.append(Integer.toString(counter) + Integer.toString(prevlhs));
    
return SB.toString();
}

public static void main(String[] args) {
Solution sol =  new Solution();
String number = "1";
for(int i=1; i<= 6; i++){
  number = sol.print_sequence(i, Integer.valueOf(number));
  System.out.println("the result is " + number); 
}
}


}


//Output:
/*
the result is 11
the result is 21
the result is 1211
the result is 111221
the result is 312211
the result is 13112221
*/

