
//https://leetcode.com/problems/exclusive-time-of-functions/
//when ever you encounter Start , push the ID value to the stack.
//Now time calculations will be done in a seperate array
//Important pointer is to track previous time
//Important pointer is to keep checking if Stack is not empty,
//then good to update the corresponding ID index in the array with the correct time calculation.
//When you encounter end , ensure to pop of the ID , and also increment the time by doing ++

/*
Input:
n = 2
logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3, 4]
Explanation:
Function 0 starts at the beginning of time 0, then it executes 2 units of time and reaches the end of time 1.
Now function 1 starts at the beginning of time 2, executes 4 units of time and ends at time 5.
Function 0 is running again at the beginning of time 6, and also ends at the end of time 6, thus executing for 1 unit of time. 
So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.

*/
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
