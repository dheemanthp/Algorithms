
//https://leetcode.com/problems/merge-intervals/

class Solution {
public int[][] merge(int[][] intervals) {
    //Idea is to sort based on Start time
    // compare every tuple start time with previous tuple end time
    // if there is overlap then mark the end time
    // if no overlap , then add the previous marked tuple and proceed with current tuple
    //

    List<int[]> list=new ArrayList<>();

   if(intervals.length == 0 || intervals == null) return list.toArray(new int[0][]);
   Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
   
   int begin=intervals[0][0];
   int end=intervals[0][1];
    
   for(int i=0; i<intervals.length -1; i++){
     int nextStart=intervals[i+1][0];
     int nextEnd=intervals[i+1][1];  
     //overlap  
     if(end>= nextStart){
         end=Math.max(end,nextEnd);
     }
     else{
         list.add(new int[]{begin, end});
         begin=nextStart;
         end=nextEnd;
        }
   }
   list.add(new int[]{begin, end});
   int[][] res=new int[list.size()][2]; 
   for(int i=0; i<res.length; i++){
       res[i]=list.get(i);
   }
   return res;
    }
}

/*Comparator can be used this way as well
Arrays.sort(intervals, new CompareIntervals()); 
class CompareIntervals implements Comparator<int[]>{
public int compare(int[] a, int[]b){
if(a[0]<b[0])
return -1;
else if(a[0]>b[0])
return 1;
else
return 0;
}
}
*/
