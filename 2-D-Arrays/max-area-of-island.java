//https://leetcode.com/problems/max-area-of-island/
class Solution {
    
    public int ROW = 0;
    public int COLUMN = 0;
   
    //Safety Check
    boolean isSafe(int[][] grid,boolean[][] visited,int row,int column) {
        if(row < 0 || column < 0 || row >= grid.length || column >= grid[0].length ||
           visited[row][column] == true || grid[row][column] == 0) return false;
        else return true;
    }
    
    
    //ensure to store result and finally return the result
    int dfsHelper(int[][] grid,boolean[][] visited,int row , int column) {
        //System.out.println("helper called");
        visited[row][column] = true;
        
        int[] rowCheck = {0,0,-1,1};
        int[] colCheck = {-1,1,0,0};
        int result = 0;
        for(int i =0 ; i <4; i++) {
            if(isSafe(grid,visited,row+rowCheck[i],column+colCheck[i])) {
                result = result + (1+ dfsHelper(grid,visited,row+rowCheck[i],column+colCheck[i]));
            }
        }
        return  result;
    }
    public int maxAreaOfIsland(int[][] grid) {
        
        ROW =  grid.length;
        if(ROW == 0) return 0;
        COLUMN = grid[0].length;
        if(COLUMN == 0) return 0;
        int area = 0;
        boolean[][] visited = new boolean[ROW][COLUMN];
        for(int i = 0; i< ROW ; i++) {
            for(int j = 0; j< COLUMN ; j++) {
                if(grid[i][j] == 1 && visited[i][j]== false) {
                    //calcuate the max area , and every time add 1
                    area = Math.max(area,(1+dfsHelper(grid,visited, i,j)));
                }
            }
        }
        return area;
    }
}
