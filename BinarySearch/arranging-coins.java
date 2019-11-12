//https://leetcode.com/problems/arranging-coins/

public class Solution {
    public int arrangeCoins(int n) {
        
        //remember to typecase it to return integer
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}


/*
input is 5
stair case 1 is full -         1
stair case 2 is full -         2
stair case 3 is not full -     2 - incomplete , hence return Staircase as 2
        
input is 8
stair case 1 is full -         1
stair case 2 is full -         2
stair case 3 is full -         3
stair case 4 is not full -     2 - incomplete , hence return Staircase as 3


n * (n+1)/2 = sum

n = (x + 1) * x / 2
x² + x = 2n
x² + x + 1/4 - 1/4 = 2n
(x + 1/2)² = 2n + 1 / 4
(x + 1/2)² = (8n + 1) / 4
x + 1/2 = sqrt(8n + 1) / 2
x = (sqrt(8n + 1) / 2) - (1 / 2)
x = (sqrt(8n + 1) - 1) / 2
 */      
        
        
        


