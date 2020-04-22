
//https://leetcode.com/problems/happy-number/

class Solution {
    
  //Time complexity : O(logn)
  //Space complexity : O(1)  For this approach, we don't need a HashSet to detect the cycles. 
    //The pointers require constant extra space.
    
    
    //time complexity to find the next number is always O(n), check the solution to understand why it is the case
    //Finding the next value for a given number has a cost of O(logn) because we are processing each digit in the number,
    //and the number of digits in a number is given by logn.
    public int getNext(int n) {
        int nextNum = 0;
        while (n > 0) {
            int reminder = n%10;
            nextNum = nextNum + (reminder* reminder);
            n = n/10;
        }
        return nextNum;        
    }
    
    public boolean isHappy(int n) {
        
        int slow = n;
        int fast = getNext(n);
        //good case , fast becomes 1 , return true
        //bad case , fast == slow , basically loop found , return false
        while (fast != 1 && slow != fast) {
            
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return (fast == 1);
    }
}

//both solution works
class Solution1 {
    public boolean isHappy(int n) {
        //start : 10:26 PM0
        //idea is simple
        //every time we do a square of the 1^2 + 9^2 = 82 store this number in the hashset
        // if you find this number again the hashset that means you have found a duplicate?
        
        
        if(n == 0) return false;
        if(n == 1) return true;
        
        HashSet<Integer> H = new HashSet<>();
        
        while (n != 1) {
            
            Integer nextNum = 0;
            //running time to find the next number is Log(n) , check solution to understand why it is log(n)
            while (n != 0) {
                int reminder = n%10;
                nextNum = nextNum + (int) Math.pow(reminder,2);
                n = n/10;
            }
            
            n = nextNum;
            if(n == 1) {
                break;
                //it contains a cycle
            } else if (H.contains(nextNum)) {
                return false;
            } else {
                H.add(n);
            }
        }
        
        //exit criteria        
        return true;
        
    }
}


