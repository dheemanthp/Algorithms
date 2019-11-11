//https://leetcode.com/problems/meeting-rooms-ii/submissions/

class Solution {
    //Using Priority QUEUE
    //used lambda comparator to sort tupples by start time.
    //methods used are peek(), poll() , add()
    
public int minMeetingRooms(int[][] intervals) {
    if(intervals.length == 0) return 0;
    //int[][] intervals = {{15, 20},{5, 10},{0, 30}};
    //int[][] intervals = {{7, 10},{2, 4}};    
        //sort based on start time , lambda comprator
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        /*for(int i = 0 ; i < intervals.length; i++) {
            System.out.println("intervals " + intervals[i][0] + " " + intervals[i][1]);    
        }*/
        //practice sort using lambda for a 1D array
        //Integer[] temp = new Integer[]{7,5,4,3,2}; works
        //Arrays.sort(temp,(a, b) -> Integer.compare(a, b));
    
        //Init a priority queue[MIN HEAP] in order to add end times 
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        //Add the end time of first meeting 
        PQ.add(intervals[0][1]);
        for(int j = 1 ; j < intervals.length ; j++) {
            //if the start time is greater than the end time , then remove it
            if(intervals[j][0] >= PQ.peek()) {
                 //remove and add the end time
                 PQ.poll();
            }
                //add the end time always
                PQ.add(intervals[j][1]);
        }
        // The size of the heap tells us the minimum rooms required for all the meetings.
        //System.out.println("the rooms needed are " + PQ.size());
        return PQ.size();
    }
}











//Reference

// Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) return 0;
    // Min heap
    PriorityQueue<Integer> allocator = new PriorityQueue<>((a,b)->a-b);
    // Sort the intervals by start time
    Arrays.sort(intervals, (a, b)->a[0]-b[0]);
    // Add the first meeting
    allocator.add(intervals[0][1]);
    // Iterate over remaining intervals
    for (int i = 1; i < intervals.length; i++) {
      // If the room due to free up the earliest is free, assign that room to this meeting.
      if (intervals[i][0] >= allocator.peek()) {
        allocator.poll();
      }
      // If a new room is to be assigned, then also we add to the heap,
      // If an old room is allocated, then also we have to add to the heap with updated end time.
      allocator.add(intervals[i][1]);
    }
    // The size of the heap tells us the minimum rooms required for all the meetings.
    return allocator.size();

*/
