
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
    
    //https://leetcode.com/problems/employee-free-time/
    
        //result will be a list
        List<Interval> result = new LinkedList<>();
        //PQ based on start time
        //lambda expression , sort objects based start time
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
    
        //add all the intervals to PQ , example [1,2] 
        //add all the intervals to PQ , example [5,6]
        //add all the intervals to PQ , example [1,3]
        //add all the intervals to PQ , example [4,10]
        for (List<Interval> list : avails) {
            for (Interval b : list) {
                //System.out.println(b.start + " " + b.end);
                pq.add(b);//queue will sort it based on he start time
            }
        }

        //we will always compare the "first" with the "top" of the PQ
        //remove the first Interval in the PQ
        Interval first = pq.poll();//[1,2]
        while(!pq.isEmpty()) {
            
            //check for intersection b/w "first" and "top" of the queue // //example:[1,2] & top of queue [1,3]
            //--------------------------------
            // if there is no intersection
            //--------------------------------
            if(first.end < pq.peek().start) { 
                result.add(new Interval(first.end, pq.peek().start));//save it to result 
                first = pq.poll();//now move to the next top element
            
            //--------------------------------
            // else there is intersection , we should either consider "first" or "top"
            //--------------------------------
            } else{
                //there is intersection b/w end and start
                if(first.end < pq.peek().end){
                 first = pq.poll();//now consider [1,3]
                } else {
                    first = first;//now consider [1,2]
                    pq.poll();//remove the top of the queue
                }
            }
        }
        return result;
    }
}
