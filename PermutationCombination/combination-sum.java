/*Input
Array [2,3,6,7]
target 7
*/
/*Output
A solution set is:
[
  [7],
  [2,2,3]
]
*/



/*
remainingtarget 7 startIndex 0
remainingtarget 5 startIndex 0
remainingtarget 3 startIndex 0
remainingtarget 1 startIndex 0
remainingtarget 0 startIndex 1
 the list is [2, 2, 3]
remainingtarget 2 startIndex 1
remainingtarget 4 startIndex 1
remainingtarget 1 startIndex 1
remainingtarget 1 startIndex 2
remainingtarget 0 startIndex 3
 the list is [7]
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //https://leetcode.com/problems/combination-sum/
        //Use Depth First Search
        //https://www.youtube.com/watch?v=irFtGMLbf-s
        //List of Lists which is the result
        List<List<Integer>> list = new ArrayList<>();

        if(nums == null || nums.length == 0) {
            return list;
        }
        
        
        
        //sort the numbers
        Arrays.sort(nums);
        //System.out.println("after sort " + Arrays.toString(nums));
        //pass the final output list , nums array , target , temp array, 0
        //1]output list
        //2]input nums
        //3]temporary list
        //4]target
        //5]startIndex
        //Use Depth First Search
        backtrack(list, nums, new ArrayList<>(), target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int [] nums, List<Integer> tempList, int remainingtarget, int startIndex){
        System.out.println("remainingtarget " + remainingtarget + " startIndex " + startIndex);
        
        //base case : when target is equal to zero , add the templist to output list
        //DEEP COPY of the templist
        if(remainingtarget == 0) {
            System.out.println(" the list is " + tempList);
            list.add(new ArrayList<>(tempList));
        }
        //Normal case
        else{ 
            //for int i = 0 to 3
            for(int i = startIndex; i < nums.length; i++){
                //given that nums is sorted , if you find an element which is greater than "remainingtarget", then "remainingtarget" will become negative
                //hence breakout
                if(nums[i] > remainingtarget) {
                    break;
                }
                
                //System.out.println("the remainingtarget is " + remainingtarget + " element is " + nums[i]);
                //add one element at a time to templist
                tempList.add(nums[i]);
                //recursively call delta of target and current element , and the index
                backtrack(list, nums, tempList, remainingtarget - nums[i],i); // not i + 1 because we can reuse same elements
                //from the temporary list remove the last item from the current combination
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}


