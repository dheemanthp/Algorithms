
//In order, Pre Order and Post order , BFS and DFS

// BFS : QUEUE O(V+E)
//1)LEVEL ORDER
//2) 

//DFS : STACK 
//1) PREORDER
//2) POSTORDER
//3) INORDER









//Level Order

//         4
//   5          6
// 2   1      7   8

/*
Queue : Q -> push 4
Queue : Q -> pop 4 , and push (5,6) , add to result  = [[4]]
Queue : Q -> pop 5 , and push (6,2,1) , add to result  = [[4][5]]
Queue : Q -> pop 6 , and push (2,1,7,8) , add to result  = [[4][5,6]]
Queue : Q -> pop 2 , and no push (1,7,8) , add to result  = [[4][5,6],[2]]
Queue : Q -> pop 1 , and no push (7,8) , add to result  = [[4][5,6],[2,1]]
Queue : Q -> pop 7 , and no push (8) , add to result  = [[4][5,6],[2,1,7]]
Queue : Q -> pop 8 , and np push () , add to result  = [[4][5,6],[2,1,7,8]]
*/
 import java.util.*; 
 
 //Data structure
 class TreeNode{
   int data;
   TreeNode left;
   TreeNode right;
   
  TreeNode(int val){
    data = val;
    left = null;
    right = null;
  }
}

 //Input  : 
 // Level : [[4], [5,6],[2,1,7,8]]    ---> List of Lists
 // Inorder : Left, Root, Right 
 // Inorder: 2, 5, 1, 4, 7, 6, 8
 // Stack: root=4, push to stack
 // Stack: 
// 2 
// 5 
// 4

// pop 2, it has no childrens
// output = (2)
// stack:
// 5
// 4

// pop 5, output = (2,5)
// push 1
// stack:
// 1
// 4




//time: 6:27

class Solution {
  
List<Integer> inorder(TreeNode root) {
  //output
  List<Integer> output = new ArrayList<>();
  //Stack
  Stack<TreeNode> S = new Stack<TreeNode>();
  
  TreeNode curr = root;
  //Loop through
  while(curr != null || !S.empty()){
//push all left elements  
    while(curr != null) {
      System.out.println(" pushing "+ curr.data);
      S.push(curr);
      curr = curr.left;
    } 
    //pop
    curr = S.pop();
    System.out.println(" poping "+ curr.data);
    output.add(curr.data);
    curr = curr.right;  

  }
  return output;
  }
  
  
  /*      
    //left child of the top 
    TreeNode top = S.peek();

    //push all the left children
    while(top.left != null && top.left.data != S.top().data){
       S.push(top.left);
    }

       TreeNode top = S.pop();
      //add the node value to the output
      output.add(top.data);
      if(top.right != null) {
          S.push(top.right);
      }

    System.out.println("looping"); 
  }
  //return output
  return output;
}
*/

//
List<List<Integer>> LevelOrder(TreeNode root){
  //output
  List<List<Integer>> output = new LinkedList<List<Integer>>();
  //Queue
  Queue<TreeNode> Q = new LinkedList<>();
  //add root
  Q.add(root);
  //check if Queue is Empty
  while(!Q.isEmpty()) {
  
  
  //Level LinkedLIst
  
  List<Integer> level = new LinkedList<>();
  //check the size of the Queue
  int size = Q.size();
    while(size > 0) {
      //top element  
      TreeNode top = Q.poll();
      //check for left child
      if(top.left != null) Q.add(top.left);
      //check for right child
      if(top.right != null ) Q.add(top.right);
      //decrease the size value
      size--;
      //populate the level linkedlist
      level.add(top.data);
    }
  //add the linkedlist to final List
  
  output.add(level);
  }
  return output;  
  }
  
  void displayLevelOrder(List<List<Integer>> input){
    for(List<Integer> subList : input){
      System.out.println("----------------------------");
       for(Integer val : subList){
        System.out.println(val);
      }
    }    
  }
  
  void displayInOrder(List<Integer> input){
    System.out.println("--------In Order-----------");
       for(Integer val : input){
        System.out.println(val);
      }       
  }
  
  
  //Good BST example
   //                         11
   //                7                 14
   //         5          9          13    15
   //   null    null  8     10
   //In order : left root right  : sorted
   //null null 5 7 8 9 10 11 13 14 15
   //Pre Order: root left right
   //11 7 5 null null 9 8 10 14 13 15
  //post order:left right root
  //null null 5 8 10 9 7 13 15 14 11
  
  //Bad example:
                 //3
        // 2           5
      //1     // 4
      
  //public boolean isValidBST(TreeNode root) {
     //if(root == null)
        //return true;
    // return (root.left.data < root.data && root.right.data > root.data) && 
            //isValidBST(root.left) && isValidBST(root.right); 
   //}
   
   
   boolean isValidBST(TreeNode root) {
   //tighten the grip , which means you will have min and you will have a max
   return isValidBSTHelper(root, null , null);  
   }
   
   boolean isValidBSTHelper(TreeNode root, Integer min , Integer max) {
    if(root == null) return true;
    //negitive case
    if(min != null && root.data <= min) return false;
    if(max != null && root.data >= max) return false;
    return isValidBSTHelper(root.left,min, root.data)  &&
           isValidBSTHelper(root.right, root.data, max);
   }
   
      // 3R , null null
   //Left Subtree
   //(goleftNode(2), null, 3)                                                 
   //(goleftNode(1), null, 3)                                       (gorightNode(4), 2, 3)            
  //(goleftNode(null), null, 3)(gorightNode(null), 1, 3)//(goleftNode(null), 2, 3)(gorightNode(null), 1, 3)              
   
   //Right Subtree
   //(gorightNode(5), 3,null)
   
  
  
   
   // LCS for binary tree
   
   //LCS for a BST  
     
  
  //Valid Perfect square
// 1*1 = 1
// 2*2 = 4
// 3*3 = 9
// 4*4 = 16
// 5*5 = 25
// 6*6 = 36
// 7*7 = 49   -> num
// 8*8 = 64
// 9*9 = 81

//num = 49  , 7 * 7 

// 0 to 49
// 0 to 24
//0 to 12
//0 to 6
//0 to 3

 //Good BST example
   //                         11
   //                7                 14
   //         5          9          13    15
   //   null    null  8     10
  // Find 13, true else false
  
 // Input (R11, num 8)
 // Input (R7, num 8)
 // Input (R9, num 8)
 // Input (R8, num 8) -> return true
  
  
  boolean findNumInBST(TreeNode root, int num) {
    //base case
    if(root == null) return false;
    if(num > root.data) {
      return findNumInBST (root.right, num);
    } else if(num < root.data) {
      return findNumInBST (root.left, num);
    } else {
      return true;
    }
  }
  
  //structure should be same , value may be different
  boolean IndenticalBST(TreeNode root1, TreeNode root2) {
    if(root1 == null && root2 == null) return true;
    else if((root1 == null && root2 != null)  ||
      (root1 != null && root2 == null)) {
      return false;
    } else { 
    
      return IndenticalBST(root1.left,root2.left) &&
             IndenticalBST(root1.right,root2.right);
    }
  }
  
  //Mirror a BST tree
 //         10
 //   5          15
 //3     7  
 
 //Good Mirror
//          10
//    15          5
//             7      3  
 
 
//     3
//  2     null    
  
  
  
  
  
  
  TreeNode MirrorBST(TreeNode root) {
    if(root == null) return root;

           //goodcase
    if(root != null) {
      System.out.println("ROOT START SWAPPING " + root.data);
      System.out.println("ROOT.LEFT " + ((root.left != null) ? (root.left.data) : (null)));
      System.out.println("ROOT.RIGHT " + ((root.right != null) ? (root.right.data) : (null)));
      TreeNode temp =  root.left; //2
      root.left = root.right; //null
      root.right = temp; //2
    }
    
    MirrorBST(root.left);

    
    MirrorBST(root.right);


   

    return root;
  }
 
 void inorderPrint(TreeNode root) {
   if(root.left != null) inorderPrint(root.left);
   System.out.println(" root value is " + root.data);
   if(root.right != null) inorderPrint(root.right);
   
 } 
  
  boolean areMirror(TreeNode a, TreeNode b)
    {
        /* Base case : Both empty */
        if (a == null && b == null)
            return true;
 
        // If only one is empty
        if (a == null || b == null)
            return false;
 
        /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
        System.out.println("Data: " + a.data + " " + b.data);
        return a.data == b.data
                && areMirror(a.left, b.right)
                && areMirror(a.right, b.left);
    }
 
  
 void validateMirror(TreeNode mirror,TreeNode root) {

    inorderPrint(mirror);
    System.out.println("-----------------------");
    inorderPrint(root);
    
 }   

//Good BST example
   //                         11
   //                7                 14
   //         5          9          13    15
   //   null    null  8     10
  
//                         11
   //                7                 14
   //         5          9          13    15
   //   2         6  8     10




//always go right one step , and go full left , and pick the leaf node
//OR
//always go left one step , and go full right , and pick the leaf node

//                         11
   //                8                 14
   //         5          9          13    15
   //   2         6         10

//                         11
   //                6                 14
   //         5          9          13    15
   //   2                   10

//                         11
   //               6                14
   //         2          9          13    15
   //                      10

//1) A NODE having 2 children -> 
//always go right one step , and go full left , and pick the leaf node
//OR
//always go left one step , and go full right , and pick the leaf node


//2) A NODE having only 1 left child and right child is null
//always go left one step 
//) A NODE having 1 right child and left child is null
//always go right one step s


//ALways try to replace the number with the next minimum in the right Subtree
//OR
//try to replace the number with the next maximum  in the left Subtree

 
 //Binary search 
 public boolean isPerfectSquare(int num) {
   //iterative approach
   int start = 0;
   int end = num;

   //Template   
   while(start < end) {
     long mid = start + (end - start)/2;
     long value  = mid  * mid;
     
     //align your start and end
     if(value > num) {
       end = (int) mid;
     } else if (value < num) {
       start = (int) mid+1;
     } else {
       return true;
     }
   }
   return false;
  }
  
  //Squreroot of a number
  //let us truncate decimal
  public int squreRoot(int num) {
  int start = 0;
  int end = num;
    
 //Template   
   while(start < end) {
     int mid = start + (end - start)/2; //4.5
     int value  = mid  * mid;
     //align your start and end
     if(value > num) {
       end =  mid;
     } else if (value < num) {
       start =  mid+1;
     } else {
       return mid;
     }
   }
   return (start -1);   

  }
  
// Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum. 
// array = {-2, -3, 4, -1, -2, 1, 5, -3}


//currSum = max(-3 + -2 , -2) 
//MaxSum = max( -2 , [(-2) + (-3)]) =  -2

//currSum = max(-2 + 4, 4) which is the current index value
//MaxSum = max( -2 , 4) = 4

//currSum = max(-1, (4+ -1)) = 3
//MaxSum = max(4 , 3) = 4

//currSum = max(-2, (3+ -2)) = 1
//MaxSum = max(4 , 1) = 4

//currSum = max(1, (1+ 1)) = 2
//MaxSum = max(4 , 2) = 4

//currSum = max(5, (2+ 5)) = 7
//MaxSum = max(4 , 7) = 7

//currSum = max(-3, (-3+ 7)) = 4
//MaxSum = max(4 , 7) = 7

//output : 7

 



//Continous subarray:  4 + -1 + -2 + 1  +5  = 7 answer 

int continousSubArraySum(int[] input) {
  int maxSum = input[0];
  if(input == null || input.length == 0) return maxSum;
  int startIndex = 0, endIndex = 0;
  int currSum = input[0];
  
  //loop till the end 
  for(int i = 1; i < input.length; i++) {
    //current sum will consider current index element OR 
    //current index element + previous sum
    currSum = Math.max(input[i], currSum + input[i]);

    //Maximum sum will always track the maximum sum in the given array at that index location
    int previousMaxSum = maxSum;
    maxSum = Math.max(maxSum, currSum);
    
    //endIndex will always change
    if(maxSum != previousMaxSum) {
      endIndex = i;
    }
    
    //current index will change if at all , all the 3 are equal , currentsum , maximumsum , and 
    //current element
    if(currSum == input[i] && maxSum == input[i] && input[i] != 0){
      startIndex = i;
    }
    
    
    
    
    
  }
  System.out.println(" Start Index = " + startIndex);
  System.out.println(" End Index = " + endIndex);
  
  return maxSum;
}  
  
 // how many bits are set in a given number 
//4 bits nible
//8 bits 1 byte or octet
//16 bits 2 bytes or short
//32 bits is or 4 bytes or Integer
//64 bits is 8 bytes or long 
//Memory is aligned RISC(reduced instruction set ) & CISC architecture 

//char : 0 to 255 for unsigned char , or -127 to 128 in signed char
// java by default is signed



//can you set bits 4 bits starting from 2rd position for a given number
 //Decimal :99 
 // 0 = 0000
 // 1 = 0001
 // 2 = 0010
 // 3 = 0011
 // 4 = 0100
 // 5 = 0101
 // 6 = 0110
 // 7 = 0111
 // 8 = 1000
 // 9 = 1001
 // F = 1111
 //16 0001 0000
 
 //binary : 1001 1111 : Hex 9F
 //Right shift always divide by 2
 //Left shit always means multiply by 2
 //1000 - 8
 //0100 - 4
 //0010 - 2
 //0001 - 1
 
 // 0100 1111
 
 // 0000 & 0001 = 1
 
 //how many bits are set ?
  // 6 bits are set
  //there are 2 approaches
  // check if every bit is set or not set
  // do a right shift , and check every bit , and drop the bit
  //O(total number of bits)
  /*
  count  = 0;
  while (num != 0) {
  if((num >> 1 ) & 1 ) == 1 ) {
    count++;
  }
  num = num >> 1
  }
  */
  
  // 1000 0001 Input
  // set 4 bits starting 3rd bit
  // 1011 1101 output
  
 // int num = 81 //1000 0001 // 81 
 // int numberOfBitsSet = 4;
 // int position = 3; //3rd bit
  
 // int mask  = (1 << numberOfBitsSet) -1
 //              0001 0000 // left shift by 4 positions
 //              0000 1111  // all bits before that will now become 1
               
//               0111 1000             
//                      num = num | (mask  << position ); //OR
//                      1000 0001
//                      0111 1000
//                      ----------
//                     1111 1001
//                      ----------

//Set the bits
 // num = num | (mask  << position );
 // return num;

//Clear the bits
 // num = num & ~(mask  << position ); //OR
  
//Toggle the bits  
//  num = num ^ (mask  << position ); //OR
  
  
  
  
  //O(number of bits set)
  int numberofBitsSet(int num) {
    int count  = 0;
    while(num > 0 ){
      //core logic
      num = num & (num -1);
     //(1001 1111)  &  (1001 1110) , common prefix if you exclude the first bit
     // num = 159 & 158 //num = 1001 1110 // 1st common prefix
     // num = 158 & 157 //num = 1001 1100 //2nd common prefix
     // num = 157 & 156 //num = 1001 1000 //3rd common prefix            
     // num = 156 & 155 //num = 1001 0000 //4th common prefix
     // num = 155 & 154 //num = 1000 0000 //5th common prefix            
     // num = 154 & 153 //num = 0000 0000 //6th common prefix            
      
      
      
      count ++;
      System.out.println("count " + count);
    }
    return count;
  }
  
  // pow(x,n)
  // pow(3, 2)
  
  //3 ^ 2 = 9
  //4 ^ 3 = 64
  
 /* 
int pow(int num , int x) {
 int originalnum = num;
 int output = 0;
  for(int i = 0 ; i <
   x ; i++) {
    num = num << 1;
  }
  //odd 
  if(originalnum%2 == 1) {
    output = num - originalnum;
  } else {
    output = num;
  }
  return output; 
}
/*

x 5.0 n 3 {
  
  x 5.0 n 1 {
    
    //base case
    x 5.0 n 0 {
      
     Returning v = 1 , becoz n is 0
    }
    Returning v = 1  , becoz n is 1
  }  
  
  Returning v = 125 ,  , becoz n is 3 
  
}
x 5.0 n 1
x 5.0 n 0 n is zero here
Returning v = 1
x 5.0 n 1 n is odd here
Returning v = 1.0
x 5.0 n 3 n is odd here
Returning v = 125.0
Power: 125.0
*/


double powShit(double num, int pow){
  //handle positive 
  if(pow >= 0) {
  return power(num,pow);
  } else {
    //handle negative case
    return 1/power(num, pow);
  }
}

double power(double num, int pow) {
  
  //base case
  if(pow == 0) return 1;
  
  //normal case , goes into recrusion
  double result = power(num,pow/2);
  
  //use the recursion result here
  if(pow % 2 == 0) {
   return  result * result;
  } else {
   return result * result * num; 
  }
}

//if a given number is prime or not
// example of prime 2 , 3 , 5 , 7 , 11

//num = 6, i = 2   , 6 %2 = 0 return false;
//num = 7, i = 2   , 7 %2 = 1,
//num = 7, i = 2   , 7%3 = 1

boolean isPrime(int num ) {
  int sqRoot = (int) Math.sqrt(num);
  for(int i = 2 ; i <= sqRoot; i++) {
    System.out.println(" the i value is " + i);
    if(num % i == 0) {
      return false;
    }
  }
  return true;
  
}    


// search in 2d array
// merge intervals
// merge k sorted lists
// number of trailing zeros in a factorial of a number
// Find maximum number that can be formed using digits of a given number

// valid parenthesis
// input: [({(})]

boolean isValidParenthesis(String input){
  if(input == null || input == "")
    return false;
  Stack<Character> stack = new Stack<>();
  int counter=0;
  while(counter < input.length()){
    if(input.charAt(counter) == '(' || input.charAt(counter) == '{' ||
       input.charAt(counter) == '['){
        stack.push(input.charAt(counter));  
    }
    else if((input.charAt(counter) == ')' && stack.peek() == '(' ) || 
            (input.charAt(counter) == '}' && stack.peek() == '{' ) ||
            (input.charAt(counter) == ']' && stack.peek() == '[' )){
              stack.pop();
    }
    counter++; 
  }
  if(stack.isEmpty())
    return true;
  else
    return false;
}


//Given a string s of '(' and ')' parentheses, we add the minimum number of parentheses
// ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

//Formally, a parentheses string is valid if and only if:

//It is the empty string, or
//It can be written as AB (A concatenated with B), where A and B are valid strings, or
//It can be written as (A), where A is a valid string.
//Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

//input: AB()ABCD(AB    (((()))  left 1

 int makeValidParanthesis(String input) {
   if(input == null || input.length() == 0) return 0;
   int left = 0;
   int right = 0;
   for(int i =0 ; i < input.length() ; i++) {
     if(input.charAt(i) == ')') {
        if(left == 0) {
          right++;         
        } else {
          left --;
        }
     } else {
       left ++;
     }
   }   
    return left + right;   
 }  
  

/*
Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.


Example 1:

Input: arr = [2,3,4,7,11], k = 5 , missing  -> 1,5,6,8,9,10 
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2 missing -> 5,6
[1,2,3,4]    12th missing element
4 + 12 = 16

input [1,10,11,12,13]    k = 11
int counter=0;
for(i=1; i<= 13; i++){
  if(input[i] != i) {
    counter++;  
  }
}

counter = 8;                 counter = 10;
k-counter = 11-8 = 3         k-10 = 1

max + 3 = 13 + 3 = 16



Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.

*/


//Input: arr = [2,3,4,7,11], k = 5 , missing  -> 1,5,6,8,9,10 
//input [1,10,11,12,13]    k = 11 



    public int findKthPositive(int[] arr, int k) {
      if(arr == null || arr.length == 0) return 0;
      int missingNumberCounter = 0;
      
      //1st part 
      if(arr[0] > 1) {
        missingNumberCounter += arr[0] - 1 ;

          if(missingNumberCounter >= k) {
          return (arr[0] - (missingNumberCounter - k + 1));
        } 
      }
      //2nd part
      for(int i = 0 ; i< arr.length - 1 ; i++ ) {
        missingNumberCounter += arr[i+1] - arr[i] -1;
        
        if(missingNumberCounter >= k) {
          return (arr[i+1] - (missingNumberCounter - k + 1));
        } 
      }
      //3rd part
        if(missingNumberCounter <= k) {
          return arr[arr.length-1] + k - missingNumberCounter;
        } else {
          return 0;
        }
    }

    
    //         mn=1
   // i=0, a[1] = 3, a[0] = 2, mn=1
   // i=1, a[2] = 4, a[1] = 3, mn=1
   // i=2, a[3] = 7, a[2] = 4, mn=3
   // i=3, a[4] = 11, a[3] = 7, mn=6
   // 
   
//   a[i] = 7 , a[i+1] = 11 , mn = 6 ,  k = 5
//missing number is ????



// // Input: { 1, 2, 3}
// // Output:
// // 
// // {}       
// // {1}      
// // {2}      
// // {1, 2}   
// // {3}      
// // {1, 3}   
// // {2, 3}   
// // {1, 2, 3}

//Exponential 2 ^ 3 = 3 inputs , and out is 8 outputs
// // Input: { 1, 2, 3, 4}
// // Output:

//output = {}, {1}, {2}, {3}

//output = {}, {1}, {2}, {3}, {1,2}, {2,3}

List<List<Integer>> setFormation(int[] input){ //DP problem
  //output
  List<List<Integer>> result = new ArrayList<>();
  result.add(new ArrayList<>());
  for(int i=0; i< input.length; i++){ // loop for the input array
  
    int size = result.size();//1
    System.out.println(" #############outerloop : I VALUE " + i + " result size " + result.size());
      for(int j = 0; j< size ; j++) { //loop for the result
        System.out.println(" ==========Innerloop : J VALUE " + j + " result size " + result.size());
           System.out.println(" Copy J position from Result " + j + " " + result.get(j));      
        List<Integer> set = new ArrayList<>(result.get(j));
           System.out.println(" Add input[i] to the List " + input[i]);      
        set.add(input[i]);
        result.add(set);
        
      System.out.println(" PRINT RESULT ");  
      for(List<Integer> list: result) {

       System.out.print("{");
       int sizet = list.size();
       int k = 0;
       for(int n: list) {
         
         if( k == sizet-1) {
           
          System.out.print(" " + n);
           
         } else {
          System.out.print(" " + n + ",");
         }
         k++;
       }
       System.out.println("}");
    }
        
        
        
        
        
      }
  }
   return result; 
} 

//i=0, J = 0 , size 1
//[[] [1]]
//i=1, J = 0 , size 2  , input[1] = 2
//[[] [1] [2] [1,2]]


// Input hello
//Output hheelllloo
/*
String Manipulate(String input){
  StringBuilder result = new StringBuilder();
  for(int i=0; i< input.length(); i++){
    char eachCharacter = input.charAt(i);
    String output = "" + eachCharacter;
    result.append(appendCharacter);
  }
  return result.toString();
}
*/
/*
char * duplicate (char * input, int len) {

if(input == NULL) return NULL;
char * output = malloc(sizeof(char) * (len * 2 +1));
for(int i = 0; i < len * 2 ; i = i+2 ) {
 output[i] = input[i/2];
 output[i+1] = input[i/2];
}

for(int i=0,j = 0; i< len && j < (len * 2); i++ , j = j+2){
  output[j] = input[i];
  output[j+1] = input[i];
 }

return output;
}

*/

// distance between two duplicate numbers in an array
// example: [10,3,20,40,60,3,90,4,80, 10,3]>()

HashMap<Integer,List<Integer>> distanceFunction(int[] input) {
  HashMap<Integer,List<Integer>> H = new HashMap<Integer,List<Integer>>();
  for(int i = 0 ; i< input.length; i++) {
    if(H.get(input[i]) == null) {
       List<Integer> I = new ArrayList<Integer>();
       I.add(i);
       H.put(input[i],I);
    } else {
      List<Integer> I = H.get(input[i]);
      I.add(i);
      H.put(input[i],I);
    }
  }
  return H;
}


// 3 sum
// array = {-1, 0, 1, 2, -1, -4}, sum=0

List<List<Integer>> threeSum(int nums[]){
  List<List<Integer>> output = new LinkedList<List<Integer>>();
  for(int i =0 ; i< nums.length;i++) {
  HashSet<Integer> S = new HashSet<Integer>();
   for(int j = i + 1  ;j < nums.length; j++) {
     int x = -(nums[i] + nums[j]);

     if(S.contains(x)) {
       List<Integer> result = new LinkedList<>();
       result.add(nums[i]);
       result.add(x);
       result.add(nums[j]);
       output.add(result);
     } 
     else {
       //add this to the hashset
       S.add(nums[j]);
     }
   }
   }
  return output;

}


// 0, 1, 1, 2, 3, 5, 8....
void fib(int input){
  
  int first = 0, second = 1;
  for(int i=0; i< input; i++){
    System.out.println(" " + first );
    int temp = first;
    first = second;
    second = temp + first;        
  }
}

void fibRecursion(int input){
  int first = 0,second  =1;
  
  for(int i = 0 ; i< input; i++) {
  System.out.print("  " + fibhelper(i));  
  }
}
int fibhelper(int input){ 
  if(input == 0 || input == 1) return 1;
  else {
    return fibhelper(input-1) + fibhelper(input-2);
  }
} 



  
  

public static void main(String[] args){
  
  Solution sol = new Solution();
  /*
  //Binary Tree
  TreeNode root = new TreeNode(4);
  root.left = new TreeNode(5);
  root.left.left = new TreeNode(2);
  root.left.right = new TreeNode(1);
  root.right = new TreeNode(13);
  root.right.left = new TreeNode(7);
  root.right.right = new TreeNode(8);
  
  //Test case for level order
  List<List<Integer>> outputlevelorder = sol.LevelOrder(root);
  sol.displayLevelOrder(outputlevelorder);
  
    //Test case for inorder
  List<Integer> outputinorder = sol.inorder(root);
  sol.displayInOrder(outputinorder);
  
  //Binary Search Tree
  TreeNode goodBST = new TreeNode(11);
  goodBST.left = new TreeNode(7);
  goodBST.left.left = new TreeNode(5);
  goodBST.left.right = new TreeNode(9);
  goodBST.left.right.left = new TreeNode(8);
  goodBST.left.right.right = new TreeNode(10);
  
  goodBST.right = new TreeNode(14);
  goodBST.right.left = new TreeNode(13);
  goodBST.right.right = new TreeNode(15);
  
  //Binary Search Tree
  TreeNode badBST = new TreeNode(3);
  badBST.left = new TreeNode(2);
  badBST.left.left = new TreeNode(1);
  badBST.left.right = new TreeNode(4);
  badBST.right = new TreeNode(5);
  
  TreeNode goodBSTClone = new TreeNode(11);
  goodBSTClone.left = new TreeNode(7);
  goodBSTClone.left.left = new TreeNode(5);
  goodBSTClone.left.right = new TreeNode(9);
  goodBSTClone.left.right.left = new TreeNode(8);
  goodBSTClone.left.right.right = new TreeNode(10);
  
  goodBSTClone.right = new TreeNode(14);
  goodBSTClone.right.left = new TreeNode(13);
  goodBSTClone.right.right = new TreeNode(15);
  
  TreeNode badBSTClone = new TreeNode(3);
  badBSTClone.left = new TreeNode(2);
  badBSTClone.left.left = new TreeNode(1);
  badBSTClone.left.right = new TreeNode(4);
  badBSTClone.right = new TreeNode(5);
 */
  
  /*
   System.out.println("------------------------------------------------");
   System.out.println(" IS VALID BST " +  sol.isValidBST(goodBST));
   System.out.println(" IS VALID BST " +  sol.isValidBST(badBST));
   System.out.println("------------------------------------------------"); 
   System.out.println(" Find num in BST " +  sol.findNumInBST(goodBST,8));
   System.out.println(" Find num in BST " +  sol.findNumInBST(goodBST,19));
   System.out.println("------------------------------------------------");
   System.out.println(" INDENTICAL BST " +  sol.IndenticalBST(goodBST, badBST));
   System.out.println(" INDENTICAL BST " +  sol.IndenticalBST(goodBST, goodBST));
   System.out.println("------------------------------------------------");
   */
   
   /*
   System.out.println("Inorder print goodBST");
   sol.inorderPrint(goodBST);
   TreeNode Mirror1 = sol.MirrorBST(goodBST);
   System.out.println("Inorder print Mirror1");
   sol.inorderPrint(Mirror1);
   System.out.println("Good BST and Mirror1: " + sol.areMirror(goodBSTClone, Mirror1));
   System.out.println("------------------------------------------------");
   System.out.println("Inorder print badBST");
   sol.inorderPrint(badBST);
   TreeNode Mirror2 = sol.MirrorBST(badBST);
   System.out.println("Inorder print Mirror2");
   sol.inorderPrint(Mirror2);
   System.out.println("Bad BST and Mirror2: " + sol.areMirror(badBSTClone, Mirror2));
   */
   

   /*
   System.out.println("------------------------------------------------"); 
   System.out.println(" IS PERFECT SQ " +  sol.isPerfectSquare(49));
   System.out.println(" IS PERFECT SQ " +  sol.isPerfectSquare(90));
   System.out.println(" IS PERFECT SQ " +  sol.isPerfectSquare(729));
   System.out.println("------------------------------------------------");
   System.out.println("square root of num " +  sol.squreRoot(8));
   System.out.println("square root of num " +  sol.squreRoot(9));
   System.out.println("square root of num " +  sol.squreRoot(10));
   System.out.println("------------------------------------------------");
   */
   
   /*
   int[] input1 = {-2,-3,4,-1,-2,1,5,-3};
   int[] input2 = {-20, 4, -2, 10, 6, 0, -30};
   int[] input3 = {-20, -4, 0, -1, -5, 0, 3};
   int[] input4 = {0, 0, 0, 0, 0, 0, 0};
   */
   
   //System.out.println(" The continous Max Sub array is: " + sol.continousSubArraySum(input1));
   //System.out.println(" The continous Max Sub array is: " + sol.continousSubArraySum(input2));
   //System.out.println(" The continous Max Sub array is: " + sol.continousSubArraySum(input3));
   //System.out.println(" The continous Max Sub array is: " + sol.continousSubArraySum(input4));
   
   //System.out.println("Number of bits set: " + sol.numberofBitsSet(159));
   //System.out.println("Power: " + sol.powShit(5, 4));
   
   //System.out.println("Prime: " + sol.isPrime(101));
   /*
   System.out.println("Is Valid Parenthsis: " + sol.isValidParenthesis("[({(})]"));
   System.out.println("Is Valid Parenthsis: " + sol.isValidParenthesis("[({()})]([])"));
   System.out.println("Make Valid Parenthsis: " + sol.makeValidParanthesis("(((())))(()"));
   int[] arr = {1,10,13};
   int[] arr1 = {12,20,40,45};
   int[] arr2 = {1,2,3,4};
   int[] arr3 = {2,3,4,7,11};//1,5,6,8,9,10
   int[] arr4 = {10};//1,5,6,8,9,10
   //11 + 7 + 19 + 4 -> 40
   //34, 35
   System.out.println("findKth Positive number " + sol.findKthPositive(arr2,2));
   System.out.println("findKth Positive number " + sol.findKthPositive(arr1,31));
   System.out.println("findKth Positive number " + sol.findKthPositive(arr3,5));
   System.out.println("findKth Positive number " + sol.findKthPositive(arr4,20));
   */
    
    /*
    //test combination function
    int[] test = {1,2,3};
    List<List<Integer>> result = sol.setFormation(test);
    
    
    for(List<Integer> list: result) {

       System.out.print("{");
       int size = list.size();
       int i = 0;
       for(int n: list) {
         
         if( i == size-1) {
           
          System.out.print(" " + n);
           
         } else {
          System.out.print(" " + n + ",");
         }
         i++;
       }
       System.out.println("}");
    }
   */

//System.out.println("Output: " + sol.Manipulate("naveen"));
System.out.println("===================================================");

int[] numbers = {10,3,20,4,10,6,30,10,1,3,4,20};

HashMap<Integer,List<Integer>> H = sol.distanceFunction(numbers);

  for (Map.Entry<Integer, List<Integer>> entry : H.entrySet()) {
     if(entry.getValue().size() > 1) {
       System.out.println(entry.getKey()+" : "+entry.getValue()); 
     }
      
  }
  
  System.out.println("===================================================");
  int[] array = {-1, 0, 1, 2, -1, -4};
  int[] array1 = {-1, 0, 1, 2, -1, -4, -1, 0, 1, -1, 0 , 1};
  int[] array2 = {0, 0};
 List<List<Integer>> result = sol.threeSum(array);

   for(List<Integer> list: result) {

       System.out.print("{");
       int size = list.size();
       int i = 0;
       for(int n: list) {
         
         if( i == size-1) {
           
          System.out.print(" " + n);
           
         } else {
          System.out.print(" " + n + ",");
         }
         i++;
       }
       System.out.println("}");
    }
    
   sol.fibRecursion(10);
    
}
}






