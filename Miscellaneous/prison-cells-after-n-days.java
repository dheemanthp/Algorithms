https://leetcode.com/problems/prison-cells-after-n-days/

/*While the most voted solutions are smart and brilliant, I can't wrap my head around to write their solutions in an actual interview. So here goes my solution that is easy to understand:

1.Have a sub function nextDay() that finds the next day's cell states
2.Iterate and store the cell states that occurred previously
3.If there's no cycle, return. If there's a cycle, break the loop and rerun N%cycle times to find the target cell states*/

/*
example : 
[0,1,0,1,1,0,0,1]
255 days

//cycle is found after 14 days
hence new N will be 255%14 = 3
now loop only 3 times
*/

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        //base case
		if(cells==null || cells.length==0 || N<=0) return cells;
        //flag to check for cycle
        boolean hasCycle = false;
        int cycle = 0;
        //to store the prision combinations
        HashSet<String> set = new HashSet<>(); 
        //loop through N days
        for(int i=0;i<N;i++){
            //calculate next day
            int[] next = nextDay(cells);
            //store day combination as a string 
            String key = Arrays.toString(next);
            //if the set does not contain key , keep adding the key in the set
            if(!set.contains(key)){ //store cell state
                set.add(key);
                //keep incrementing the cycle
                cycle++;
            }
            else{ //otherwise you have hit a cycle
                System.out.println(" the cycle value is " + cycle);
                //set the flag and break out , also NOTE
                //NOTE: the cell value will repeat from here 
                //so the cells array will is the beginning from where cycle begins
                hasCycle = true;
                break;
            }
            //use the older array in the loop
            cells = next;
        }
        //if there is a cycle , then we have a new N , let us say 255%14 = 3
        if(hasCycle){
            N%=cycle;
            System.out.println(" New N is " + N);
            //now we only need to loop 3 times and cells contains the 14th day reference
            for(int i=0;i<N;i++){
                cells = nextDay(cells);
            }   
        }
        //return
        return cells;
    }
    
    private int[] nextDay(int[] cells){
        int[] tmp = new int[cells.length];
        for(int i=1;i<cells.length-1;i++){
            //if both cells are equal then 1 , if both are not then 0
            //always compare cells[i-1] and cells[i+1]
            tmp[i]=cells[i-1]==cells[i+1]?1:0;
        }
        return tmp;
    }
}
