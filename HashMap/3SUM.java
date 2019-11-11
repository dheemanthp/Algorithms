



class Solution {
    // function to print triplets with 0 sum 
//https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
//Input//[-1,0,1,2,-1,-4]
//Output//[[-1,0,1],[-1,-1,2],[-1,0,1]]
//output has a duplicate because you are running two for loops
//Running time O(n^2) because of two for loops


List<List<Integer>> threeSum(int nums[]) { 
    Arrays.sort(nums);
    int found = 0; 
    List<List<Integer>> output = new LinkedList<List<Integer>>();
    int n = nums.length;
    for (int i=0; i<n-1; i++) 
    { 
        // Find all pairs with sum equals to 
        // "-nums[i]" 

           // Find all pairs with sum equals to 
           // "-arr[i]" 
            HashSet<Integer> s = new HashSet<Integer>(); 
            for (int j = i + 1; j < n; j++)  
            { 
                int x =- (nums[i] + nums[j]); 
                if (s.contains(x))  
                { 
                List<Integer> result = new LinkedList<Integer>();
                result.add(nums[i]);
                result.add(x);    
                result.add(nums[j]);
                output.add(result);
                found++; 
                }  
                else 
                { 
                    s.add(nums[j]); 
                } 
            } 
        } 
        return output;
            
     }
  } 

