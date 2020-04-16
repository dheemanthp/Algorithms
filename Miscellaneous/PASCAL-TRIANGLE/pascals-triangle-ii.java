
//https://leetcode.com/problems/pascals-triangle-ii/
/*
input : 3
output below:
[1, 0, 0, 0]
[1, 1, 0, 0]
[1, 2, 1, 0]
[1, 3, 3, 1]


*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        //Timecomplexity = k^2 elements for the k^{th} row
        //Spacecomplexity  = k (space)               
        //given the rowIndex , we clearly know how many elements would be there
        //so for example rowIndex is 3 , then we know there would 4 elements
        //we will use a Backfill algorithm
        Integer[] row = new Integer[rowIndex+1];
            //fill the array with zero
            Arrays.fill(row,0);
            //fill the first item
            row[0] = 1;
        //start operating with respect to pascal's triangle's 2nd row
        System.out.println(Arrays.toString(row));
        for(int i = 1 ; i <= rowIndex ;i++){
            //start from row 1 onwards , and do not touch when j = 0
            for(int j = i ; j > 0;j--) {
                row[j] = row[j] + row[j-1];
            }
        System.out.println(Arrays.toString(row));
        }    
        return Arrays.asList(row);
    }
}



class SolutionNotOptimized {
    public List<Integer> getRow(int rowIndex) {
        
        //output
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        //Loop for every row
        for (int i = 0; i <= rowIndex; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            //add 1 to every row
            row.add (1);
                //from 3rd row onwards this condition gets satisifed
                for(int j = 1; j < i; j++) {
                        int prevSum = output.get(i-1).get(j-1) + output.get(i-1).get(j);
                        row.add(prevSum);
                }
            //from second row onwards this condition gets satisfied
            if(i > 0) row.add(1);
            //add each row to the final result
            output.add(row);
        }
        return output.get(rowIndex);
    }
}
