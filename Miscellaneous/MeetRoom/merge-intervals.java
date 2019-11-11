
//https://leetcode.com/problems/merge-intervals/

//Compares current tuple with next tuple
class Solution {
public int[][] merge(int[][] intervals) {
    //Idea is to sort based on Start time
    // compare every tuple start time with next tuple end time
    // if there is overlap then mark the end time
    // if no overlap , add the tuple

    List<int[]> list=new ArrayList<>();

   if(intervals.length == 0 || intervals == null) return list.toArray(new int[0][]);
    //Lambda
   Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
   
   int begin=intervals[0][0];
   int end=intervals[0][1];
    
   for(int i=0; i<intervals.length -1; i++){
     int nextStart=intervals[i+1][0];
     int nextEnd=intervals[i+1][1];  
     //overlap  
     if(end>= nextStart){
         //end will always have maximum value
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

//Compares current tuple with Previous tuple
class SolutionAlternative {
public int[][] merge(int[][] intervals) {

    List<int[]> list=new ArrayList<>();

   if(intervals.length == 0 || intervals == null) return list.toArray(new int[0][]);
   Arrays.sort(intervals, new CompareIntervals()); 

   int begin=intervals[0][0];
   int end=intervals[0][1];
    
   for(int i=1; i<intervals.length; i++){
     int[] arr=intervals[i];
     if(arr[0]<=end){
         end=Math.max(end,arr[1]);
         //list.add(new int[]{begin, end});
     }
     else{
         list.add(new int[]{begin, end});
         begin=arr[0];
         end=arr[1];
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
