https://leetcode.com/problems/meeting-rooms/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        //Idea:
        //sort based on start time
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        
        for(int i = 0; i < intervals.length -1 ;i++) {
            //compare end time of current meeting , and start time of next meeting
            //if there is any overlap return false
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        //all are in ascending order , hence no overlap
        return true;
    }
}
