//https://leetcode.com/problems/merge-sorted-array/
//O(n)


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length == 0 || nums2.length == 0) return;
        int nums1L = nums1.length-1;
        int nums2L = n-1;
        //m actually gives the end of first array which contains valid numbers, rest are zero //[1,2,3,0,0,0], m = 3
        int nums1_end = m-1;
        while (nums1_end >= 0 && nums2L >= 0) {
            //check the last item in the first array and last item in second array
            if(nums1[nums1_end] <= nums2[nums2L]) {
                nums1[nums1L--] = nums2[nums2L--];
            } else{
                nums1[nums1L--] = nums1[nums1_end--];
            }
        }
        //update first array with left over elements first array
        while(nums1_end >= 0){
            nums1[nums1L--] = nums1[nums1_end--];
        }
        //update first array with left over elements from second array
        while(nums2L >= 0){
            nums1[nums1L--] = nums2[nums2L--];
        }
        return;
    }
}
