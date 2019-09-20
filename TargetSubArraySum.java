public class TargetSubArraySum {

//Running time is O(n)    
    
    boolean subArraySum(int arr[], int target, int size) {
        
        int sum = arr[0];
        int start = 0;//used to store start position
        int i = 0;
        
        for (i = 1; i<size-1;i++) {

           //remove the first element if the sum is greater than the target
           //reset the start position by moving it one step
           while(sum > target) {
               sum = sum - arr[start];
               start++;
           }
           //if the sum equals the target , then just return true, and print the
           //positions
           if(sum == target) {
               System.out.println("the start index is " +  start);
               System.out.println("the end index is " +  (i-1));
               return true;
           }
           sum = sum + arr[i];
        }
        return false;
        
    }

    public static void main(String[] args) {
        int arr[] = { 15,2,4,8,9,5,10,23 };
        int target = 23;
        TargetSubArraySum obj = new TargetSubArraySum();
        boolean isSubArraySum = obj.subArraySum(arr,target,arr.length);
        if (isSubArraySum) {
            System.out.println("found");
        } else {
            System.out.println("the target is not found");
        }
    }
}
