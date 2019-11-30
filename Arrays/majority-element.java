https://leetcode.com/problems/majority-element/

//Boyer-Moore Voting Algorithm
/*
If we had some way of counting instances of the majority element as +1 and 
instances of any other element as −1, summing them would make it obvious that 
the majority element is indeed the majority element.

Complexity Analysis

Time complexity : O(n)

Boyer-Moore performs constant work exactly nn times, so the algorithm runs in linear time.

Space complexity : O(1)

Boyer-Moore allocates only constant additional memory.

*/
class SolutionAmazing {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if(num == candidate) {
                count  = count + 1;
            } else {
                count  = count - 1;
            }
            System.out.println("the count value is " + count);
        }

        return candidate;
    }
}

//hashmap solution
//use Map.Entry<Integer,Integer> majorityEntry =  null;
//majorityEntry.getValue();
//majorityEntry.getKey();

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> H = new HashMap<>();
        for(int num : nums) {
            if(H.containsKey(num)) {
                H.put(num,H.get(num)+1);
            } else{
                H.put(num,1);
            }
        }
        Map.Entry<Integer,Integer> majorityEntry = null;
        for(Map.Entry<Integer, Integer> entry : H.entrySet()) {
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
}


