
https://leetcode.com/problems/count-primes/

class Solution {
    public int countPrimes(int n) {
        int count  = 0;
        
        for(int j = 2; j <n ;j++) {
            if(isPrime(j)){
                //System.out.println(" J is prime " + j);
                count++;
            }
        }
        
    return count;        
        
    }
    public boolean isPrime(int n) {
        int root = (int)Math.sqrt(n);
        for(int i = 2; i <=root; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
    
    
    
}
