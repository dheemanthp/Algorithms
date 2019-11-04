//https://leetcode.com/problems/intersection-of-two-arrays-ii/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //since array's cannot be resized , use arraylist for now        
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer,Integer> H = new HashMap<>();
            
            //not considering the length of the array for now, if yes just duplicate the code
            //put all the integers from first array in Hashmap
            for(int i = 0 ; i < nums1.length ; i++) {
                if(H.containsKey(nums1[i])) {
                    H.put(nums1[i],H.get(nums1[i])+1);
                } else {
                    H.put(nums1[i],1);
                }
            }
            //check every element from second array is present in the HashMap
            for(int j = 0 ; j < nums2.length ; j++) {
                //if it contains then decrement the count by 1
                if(H.containsKey(nums2[j]) && H.get(nums2[j]) > 0) {
                    H.put(nums2[j],H.get(nums2[j])-1);
                    output.add(nums2[j]);
                    
                }
            }

        //store the result in int[]
        System.out.println("the size is " + output.size());
        int[] result = new int[output.size()];
        for (int k = 0 ; k < output.size(); k++){
            System.out.println("the values is " + output.get(k));
            result[k] = output.get(k);
        }
        return result;
    }
}
