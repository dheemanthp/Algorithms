

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//log(n) run time.

public class Solution {
public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    int leftIndex = 1;
    int rightIndex = 2;
    //find the left most index
    result[0] = findFirstLast(nums, target,leftIndex);
    //find the right most index
    result[1] = findFirstLast(nums, target,rightIndex);
    return result;
}

//call this function twice
private int findFirstLast(int[] nums, int target,int whichIndex){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        //find the left most index
        if(whichIndex == 1) {
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        //find the right most index
        } else {
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        //store the idx
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}
}

//Concise Solution of the above solution 
//Above solution is intutive , this solution may be intutitve with little rememberance
class SolutionAlternative {
public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    boolean leftIndex = true;
    boolean rightIndex = false;
    result[0] = findFirstLast(nums, target,leftIndex);
    result[1] = findFirstLast(nums, target,rightIndex);
    return result;
}

private int findFirstLast(int[] nums, int target,boolean whichIndex){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        //example 1 2 3 4 5 5 5 6 7 7
        //go to left , and also go to the left if we need to find leftmost index
        if(nums[mid] > target || (whichIndex && nums[mid] == target)){
                end = mid - 1;
        //go to right , and also go to the right if we need to find rightmost index
        }else{
                start = mid + 1;
        }
        //always store the mid
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}
}
