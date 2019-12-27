

https://leetcode.com/problems/coin-change/

/*#Iterative Method:#
For the iterative solution, we think in bottom-up manner. Suppose we have already computed all the minimum counts up to sum, what would be the minimum count for sum+1?
Check thushar's video
//https://youtu.be/NJuKJ8sasGk
//DP
//T[i] = Math.min(T[i],T[i-coins[j]] + 1)

Code in Java:
*/
//Running time is pesudo polynomial
//space is O(amount)

//[7,2,3,6] coin amount
//13 //total value
//output is 7+6 = 13 , hence 2 coins
public class Solution {
public static int coinChange(int[] coins, int amount) {
	if (coins == null || coins.length == 0 || amount <= 0)
		return 0;
	int[] minNumber = new int[amount + 1];
	for (int i = 1; i <= amount; i++) {
        //System.out.println(" the value of sum is " + i);
		minNumber[i] = Integer.MAX_VALUE;
		for (int j = 0; j < coins.length; j++) {
            //System.out.println(" the coin value is " + j);
			if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE) {
                //DP
                //T[i] = Math.min(T[i],T[i-coins[j]] + 1)
                //System.out.println(" the coin value is " + j + " and sum is " + i);
 				minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
		}
	}
	if (minNumber[amount] == Integer.MAX_VALUE)
		return -1;
	else
		return minNumber[amount];
}
}
