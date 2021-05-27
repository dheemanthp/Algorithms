https://leetcode.com/problems/best-time-to-buy-and-sell-stock/


//Best Time to Buy and Sell Stock

//You are given an array prices where prices[i] is the price of a given stock on the ith day.

//You want to maximize your profit by choosing a single day to buy 
//one stock and choosing a different day in the future to sell that stock.

//Return the maximum profit you can achieve from this transaction. 
//If you cannot achieve any profit, return 0.
             // 1    2   3   4    5
//input 1
//prices[5] = {100, 50, 70, 100, 101} basePrice = prices[0]
//one day to buy  
//one day to sell
// cannot buy and sell on the same day


//buy day 1 , sell 5 , profit is 1
//buy day 2 , sell 5 , profit is 51
//buy day 3 , sell 5 , profit is 31
//buy day 4 , sell 5 , profit is 1

//buy minimum value 
//sell maximum value
//profit = sell - buy

//Input 2 : prices[5] = {101, 100, 70, 100, 150, 50}

//buy day 1 , sell 2,4 , profit is -1
//buy day 2 , sell 4 , profit is 0
//buy day 3 , sell 4 , profit is 30
//buy day 4 , sell 5 , profit is 1


 import java.lang.*;
class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 0 || prices.length == 1) {
         return -1;
        }
         int min = prices[0];//latch or catch the first value
         int maxProfit = Integer.MIN_VALUE;
          for(int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - min;
            maxProfit = Math.max(maxProfit,currProfit); /// calculating profit 
            min = Math.min(min, prices[i]); //calculating minumum at the same time
          }
    return maxProfit;
    }
    
    
    
    
    // min = 101
    // maxProfit = -1000
    // currProfit = 100 - 101 = -1
    // maxProfit = max(-1000, -1) = -1
    // min = min(101, 100) = 100
    
    // min = 100
    // currProfit = 70 - 100 = -30
    // maxProfit = max(-1, -30) = -1
    // min = min(100, 70) = 70
    
    // min = 70
    // currProfit = 100 - 70  = 30
    // maxProfit = max(-1, 30) = 30
    // min = min(70, 100) = 70
    
    // min = 70
    // currProfit = 150 - 70 = 80
    // maxProfit = max(30, 80) = 80
    // min = min(70, 150) = 70
    
    // min = 70
    // currProfit = 50 - 70 = -20
    // maxProfit = max(80, -20) = 80
    // min = min(70, 50) = 50


// GOal is to ensure we find the maximum profit , by checking everyday prices
//and also ensure we compare maximum profit with the current profit



    public static void main(String[] args) {
      Solution sol = new Solution();
      int[] input1 = {100, 50, 70, 100, 101}; //output is 51
      int[] input2 = {101, 100, 70, 100, 150, 50}; //output is 80
      System.out.println(" the output is " + sol.maxProfit(input2));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

