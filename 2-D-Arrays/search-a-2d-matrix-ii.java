https://leetcode.com/problems/search-a-2d-matrix-ii/
loop through every row and do a binary search
skip rows if the target , is either lesser than the start of the row value 
or ending of the row value


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        //do binary search on every row
        //also check the row start and row end to evaluate if the target could lie there
        
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        if(col == 0) return false;
        
        for(int i = 0; i < row ; i++) {
                if(target < matrix[i][0] || target > matrix[i][col-1]) {
                    //System.out.println(" skip row " + i);
                    continue;
                }
                //do a binary search
                int start = 0;
                int end = col -1;
                while(start <= end) {
                    int j = start + (end-start)/2;
                    if(matrix[i][j] == target) return true;
                    if(matrix[i][j] < target) {
                        start = j + 1; 
                    } else{
                        end = j -1;
                    }
                }
        }
        return false;        
    }
}
