
public class Solution{
public int arrangeCoins(int n) { 
        //idea is simple , this follows the n*(n+1)/2  = sum approach
        //given the sum here , find n
        //you can find n using binary search
        //convert int to long to prevent integer overflow
        long sum = (long)n;
        
        long start = 0;
        long end = sum;
        
        long mid = 0;
        
        while (start <= end){
            mid = start + (end - start) / 2;
            
            if (mid * (mid + 1) <= 2 * sum){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return (int)end;//will contain lower value
    }
}


class SolutionAlternative {
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
        
        
        


