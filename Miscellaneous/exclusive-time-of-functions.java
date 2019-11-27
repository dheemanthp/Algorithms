
//https://leetcode.com/problems/exclusive-time-of-functions/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
    //Array to store the values
    int[] res = new int[n];
    //stack to store ID's
    Stack<Integer> stack = new Stack<>();
    //previous time
    int prevTime = 0;
    //parse the input 
    for (String log : logs) {
        //split the id:time
        String[] parts = log.split(":");
        //if stack is not empty
        if (!stack.isEmpty())  {
            //get the ID from the top of the stack , and update the corresponding index
            //part2 is the time , and detect from previous time
            res[stack.peek()] +=  Integer.parseInt(parts[2]) - prevTime; 
        }
        //new previous time
        prevTime = Integer.parseInt(parts[2]);
        //for every start encounter , push the ID to the stack
        if (parts[1].equals("start")) stack.push(Integer.parseInt(parts[0]));
        else {
            //for end encounter , increment result
            res[stack.pop()]++;
            //increment previous time
            prevTime++;
        }
    }
    return res;
}
}
