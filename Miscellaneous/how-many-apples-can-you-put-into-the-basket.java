https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/
//nlogn
class Solution {
    public int maxNumberOfApples(int[] arr) {
        
        Arrays.sort(arr);//sort
        int sum  = 0;
        int i;
        for(i = 0;i < arr.length && (sum + arr[i]) < 5000; i++) {
            sum = sum + arr[i];
        }
        if(sum < 5000)   return i;
        else return -1;        
    }
}
