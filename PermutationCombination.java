/*https://leetcode.com/problems/subsets/   -> Combination problem
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
While iterating through all numbers, for each new number, we can either pick it or not pick it
1, if pick, just add current number to every existing subset.
2, if not pick, just leave all existing subsets as they are.
We just combine both into our result.

For example, {1,2,3} intially we have an emtpy set as result [ [ ] ]
Considering 1, if not use it, still [ ], if use 1, add it to [ ], so we have [1] now
Combine them, now we have [ [ ], [1] ] as all possible subset

Next considering 2, if not use it, we still have [ [ ], [1] ], if use 2, just add 2 to each previous subset, we have [2], [1,2]
Combine them, now we have [ [ ], [1], [2], [1,2] ]

Next considering 3, if not use it, we still have [ [ ], [1], [2], [1,2] ], if use 3, just add 3 to each previous subset, we have [ [3], [1,3], [2,3], [1,2,3] ]
Combine them, now we have [ [ ], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] ]
*/


class Solution {
public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }

}





public class Solution {
    
    //Running time
    //n* n!
    //Permutation  
    static void  permutation(String output, String input) {
    //Base case
    if(input.isEmpty()){
     System.out.println(output);   
    } else {
        for(int i = 0 ; i < input.length(); i++) {
            permutation(output + input.charAt(i), input.substring(0,i) + input.substring(i+1,input.length()));
        }
      }
    }
    //Combination
    //Enumerates all subsets of n elements using recursion.
    //0 to 2^N - 1
    static void combination(String prefix, String s) {
        System.out.println(prefix);
        for (int i = 0; i < s.length(); i++) {
            combination(prefix + s.charAt(i), s.substring(i + 1));
        }
    }  
        
    public static void main(String[] args) {
        String input = "123";
        String output = "";
        permutation(output, input);
        System.out.println("=====================");   
        combination(output ,input);
    }

//=====================
//Permutation
//=====================
//123
//132
//213
//231
//312
//321
//=====================
//Combination
//=====================
//1
//12
//123
//13
//2
//23
//3    

}
