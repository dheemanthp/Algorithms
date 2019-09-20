import java.lang.Math;

public class MaxSubArray {

//Can also handle negative values
//Running time : O(n)
    
    int maxSubArray(int[] arr,int size) {
    
        int curr_max = arr[0]; //store the first element 
        int max_so_far = arr[0]; //store the first element
            
        for(int i = 1; i < size -1 ; i++) {
            curr_max = Math.max (arr[i],curr_max + arr[i]);
            max_so_far = Math.max (max_so_far,curr_max);
        }
    return max_so_far;   
    }

    //Driver Code
    public static void main(String[] args) {
        int arr[] = {-2,-3,4,-1,-2,1,5,3,-3};    
        MaxSubArray obj = new MaxSubArray();
        int value  = obj.maxSubArray(arr,arr.length);
        System.out.println("the max value is " + value);
    }
}
