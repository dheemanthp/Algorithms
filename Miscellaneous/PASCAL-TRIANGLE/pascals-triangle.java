
//https://leetcode.com/problems/pascals-triangle/


class Solution {
    public List<List<Integer>> generate(int numRows) {
        //output
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        //Loop for every row
        for (int i = 0; i < numRows; i++) {
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
        return output;
    }
}


class SolutionNotRevised {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(numRows == 0) return output;
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            if(i == 0) row.add (1);
            else {
                for(int j = 0; j <= i; j++) {
                    if(j == 0) row.add(1);
                    else if(j ==i) row.add(1);
                    else {
                        int prevSum = output.get(i-1).get(j-1) + output.get(i-1).get(j);
                        row.add(prevSum);
                    }
                }
            }
                output.add(row);
        }
        return output;
    }
}


class SolutionEarlierOld {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new LinkedList<List<Integer>>();
        for(int i = 0 ;i < numRows ; i++) {
            List<Integer> row = new  LinkedList<Integer>();
            row.add(1);
            for(int j = 1 ;j < i; j++) {
                List<Integer> previoustRow = output.get(i-1);
                    row.add(previoustRow.get(j-1) +previoustRow.get(j));
            }
            if(i > 0)
                row.add(1);
         output.add(row);   
        }
        return output;
    }
}
