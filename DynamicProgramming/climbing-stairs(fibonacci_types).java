https://leetcode.com/problems/climbing-stairs/

class Solution {
public int climbStairs(int n) {
    // base cases
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    //use memoization
    int[] result = new int[n];
    result[0] = 1;//one step
    result[1] = 2;//two step
    
    for(int i=2; i<n; i++){
        //one can reach ith step in one of the two ways
        //1) take a single step from (i-1)th step
        //2) take two steps from (i-2)th step
        //So, the total number of ways to reach ith step
        //is equal to sum of ways of reaching (i-1)th step
        //and ways of reaching (i-2)th step 
        //Let result[i] denotes the number of ways to reach on ith step
        //result[i] = result[i-1] + result[i-2];
    	result[i] = result[i-1] + result[i-2];
    }
    return result[n-1];
}}

class SolutionAlternative {
public int climbStairs(int n) {
    // base cases
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    
    int one_step_before = 2;
    int two_steps_before = 1;
    int all_ways = 0;
    
    for(int i=2; i<n; i++){
    	all_ways = one_step_before + two_steps_before;
    	two_steps_before = one_step_before;
        one_step_before = all_ways;
    }
    return all_ways;
}}
