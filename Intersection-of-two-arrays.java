public class Solution {
  //https://leetcode.com/problems/intersection-of-two-arrays/  
 public int[] intersection(int[] nums1, int[] nums2) {
     //Put all elements into Hashset
     HashSet<Integer> H = new HashSet<>();
     //contains all intersections
     HashSet<Integer> intersect = new HashSet<>();
     //add all elements to hashset
     for(int a : nums1) {
         H.add(a);
     }
     //if elements in second integer array is contained in hashset
     //if yes then add it to intersection
     for(int b : nums2) {
         if(H.contains(b)){
             intersect.add(b);
         }
     }
     //finally store all the elements from intersection hashset into integer array
     //and return this integer array
     int[] result = new int[intersect.size()];
     int i =0;
    for (Integer num : intersect) {
            result[i++] = num;
     }

     /*
     //we can also use iterator for Hashset
     Iterator<Integer> it = intersect.iterator(); 
    while (it.hasNext()) {
            result[i++] = it.next();
    } */
    return result;
    }   
 }
