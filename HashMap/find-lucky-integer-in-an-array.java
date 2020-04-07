https://leetcode.com/problems/find-lucky-integer-in-an-array/

class Solution {
    public int findLucky(int[] arr) {
        //use a HashMap
        HashMap<Integer,Integer> H = new HashMap<>();
        //put all values in the HashMap and its count as a value
        for(int n : arr) {
            H.put(n,H.getOrDefault(n,0)+1);
        }
        
        //Iterate over the HashMap, and ensure that key and value are equal , and it is the max value
        int max_value = -1;
        for( int n : H.keySet()) {
            //System.out.println(" the key is " + n + " the value is " + H.get(n));
            if( n == H.get(n)) {
                max_value = Math.max(max_value,n);
            }
        }
        return max_value;
    }
}
