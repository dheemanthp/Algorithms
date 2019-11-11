class Solution {
//Best Time to Buy and Sell Stock: DP problem
//permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
//design an algorithm to find the maximum profit.
//Input: [7,1,5,3,6,4]
//Check for the minimum value : min
// store (current- min) in every step
//finally return the Max of the (current-min)
    
    
    
    public int maxProfit(int[] prices) {
    
        //max profit needs atleast 2 enties in the array
        //length is one or zero , just return zero
        if(prices.length == 0 || prices.length == 1) return 0;
        
        //init return value
        int ret = 0;
        //assume the minimum value is first memeber of the array
        int minPrice = prices[0];
        //run loop until end
        for(int i=1; i<prices.length; i++) {
            //lock in the minimum value
            if(prices[i]<minPrice)
                minPrice = prices[i];
            else 
                //max of [ (current price - minimum value) , ret]
                ret = Math.max(prices[i]-minPrice,ret);
        }
        return ret;
    }
}
