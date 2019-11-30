//https://leetcode.com/problems/daily-temperatures/

//using stack solution
//keep pushing the index values , until you encounter a greater temperature value
//once you encounter a greater temperatuer value , keep poping
//while you pop , ensure to update the result[top] with delta of top index and current index

//space complexity: O(n)
//time  complexity: O(n)^2
class Solution {
public int[] dailyTemperatures(int[] temperatures) {
    Stack<Integer> S = new Stack<>();
    int[] result = new int[temperatures.length];
    for(int curr = 0 ; curr < temperatures.length; curr++ ) {
        //pop the index value and calculate the delta,if the current temperature is above 
        while(!S.isEmpty() && temperatures[curr] > temperatures[S.peek()]) {
            int top = S.pop();
             result[top] = curr - top;
        }
        //keep pushing here
        S.push(curr);
    }
    return result;    
}
}

//Worst case: O(n)^2
class SolutionAlternative {
    public int[] dailyTemperatures(int[] T) {
        //by default all values in result is zero
        int[] result  = new int[T.length];
        //run through the temperature array
        int j = 0;
        for(int i = 0 ; i < T.length ; i++) {
            //always check the next index values
            j = i+1;
            //loop until you find a temperature greater than the current element
            while((j < T.length) && (T[j] <= T[i])) {
                j++;
            }
            if(j < T.length) {
                result[i] = j-i;    
            }
        }
        return result;
    }
}
