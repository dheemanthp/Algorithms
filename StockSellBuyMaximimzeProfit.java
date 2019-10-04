import java.io.*;
import java.util.*;

class Profit {
  int buy;
  int sell;
}



public class Solution {
//Stock Buy Sell to Maximize Profit
//Idea is simple find local minima and local maxima at every step
//1)Find local Minima
//try to compare evey index member with the neighbour until you find current value is less than neightbour
//2)Find local Maximma
//try to compare evey index member with the neighbour until you find current value is greater than neighbour
//store the minima and maximma in the Profit Class
//Input int[] price = { 100,180,260,310,40,535,695};
//output
//Buy@ 100Sell@ 310
//Buy@ 40Sell@ 695
//Running time O(n)
//check below link very useful
//http://bangbingsyb.blogspot.com/2014/11/leetcode-best-time-to-buy-and-sell.html

  List<Profit> maxProfit(int[] price , int size) {
    
    if(size == 1) return null;
    List<Profit> output = new LinkedList<Profit>();
    int i = 0;
    //outer loop to run through the entire List
    while(i < size) {
      
      //System.out.println( "test1:" + i );
      //find local minima, go until the last but one element
      while (i <(size-1) && (price[i] >= price[i+1])) {
        i++;
      }
      //for minima if you reach last element break out
      if ( i == size -1) {break; }
      Profit obj = new Profit();  
      obj.buy = price[i];
      //System.out.println( "output buy" + obj.buy + "::::" + price[i]);
      
      //find local maxima,, go until the last but one element
    while (i < (size-1) && (price[i] <= price[i+1])) {
        i++;
      }
      obj.sell = price[i];
      output.add(obj);
      //System.out.println( "output sell" + obj.sell + "::::" + price[i]);
    }
    //System.out.println( "test4:" + i );
    return output;
  }
  
  
  public static void main(String[] args) {
    
    int[] price = { 100,180,260,310,40,535,695};
    Solution S = new Solution();
    List<Profit> output = S.maxProfit(price , price.length);
    Iterator<Profit> it  =  output.listIterator();
    
    
    while(it.hasNext()) {
      Profit p = it.next();
      System.out.println( "Buy@ " + p.buy + "Sell@ " + p.sell );

    }

  }
}
