

import java.util.*;

public class Leet442 {
  
    public static void main(String args[]) { 
        
        int val = 7;
        int i = 2;
        boolean isNotPrime = false;
        while(i <= val/2) {
            if(val%i == 0) {
                isNotPrime = true;
                break;
            }
            i++;
        }
        
        if(isNotPrime == true) {
            System.out.println(" is not a prime number");
        } else{
            System.out.println(" !!!!!!!!!!prime number!!!!!!!!!!!!!!");
        }
    } 
} 
