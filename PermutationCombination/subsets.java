
https://leetcode.com/problems/subsets/
//[1,2,3]
//[[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>>  output = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        subsetHelper(output, temp, nums,0);
        return output;
    }
    
    public void  subsetHelper(List<List<Integer>> output, List<Integer> temp, int[] nums , int index){
            output.add(new ArrayList<>(temp));
            if( index == nums.length) {
                return;
            }
            for(int i = index; i < nums.length; i++) {
                temp.add(nums[i]);
                subsetHelper(output,temp,nums,i+1);
                temp.remove(temp.size() - 1);
            }
    }
}

/*
//Debugged the above code
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>>  output = new ArrayList<List<Integer>>();
        //List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        subsetHelper(output, temp, nums,0);
        return output;
    }
    
    public void  subsetHelper(List<List<Integer>> output, List<Integer> temp, int[] nums , int index){
            output.add(new ArrayList<>(temp));
            if( index == nums.length) {
                 System.out.println(" we have reached limit " + index);
                return;
            }
            for(int i = index; i < nums.length; i++) {
                System.out.println(" coming here i " + i + " adding nums[i] " + nums[i]);
                temp.add(nums[i]);
                System.out.println("calling recursive function with index " + (i+1));
                subsetHelper(output,temp,nums,i+1);
                System.out.println("coming out of  recursive function");
                System.out.println(" now removing " + temp.get(temp.size() - 1) + " and i value is " + i);
                temp.remove(temp.size() - 1);
            }

    }
}*/

