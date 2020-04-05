//There are 2 solutions that are possible 
//1) Recursive approach but using an extra 2D array for storing visited
//2) Recursive approach without using an  extra visited 2D array by marking the existing array

//Approach 1
class Solution {
    //time complexity DFS --> O(mxn)
    void dfs (char[][] grid,boolean[][] visited, int i , int j) {
        //validity check
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0') return;
            //mark it
            //System.out.println("Mark (" + i + "," + j + ")");
            visited[i][j] = true;
            //go all 4 directions
            dfs (grid, visited, i-1, j);
            dfs (grid, visited, i+1, j);
            dfs (grid, visited, i, j-1);
            dfs (grid, visited, i, j+1);
        
            //8 directions
            /*
            dfs (grid, visited, i-1, j-1);
            dfs (grid, visited, i-1, j+1);
            dfs (grid, visited, i+1, j-1);
            dfs (grid, visited, i+1, j+1);
            dfs (grid, visited, i, j+1);
            dfs (grid, visited, i, j-1);
            dfs (grid, visited, i+1, j);
            dfs (grid, visited, i-1, j);
            */
    }
    
    
    
    public int numIslands(char[][] grid) {
    //check for null case and 0 rows
    if(grid == null || grid.length == 0) return 0;
    int row = grid.length;
    int col = grid[0].length;
    
    //visited
    boolean[][] visited = new boolean[row][col];
    //output
    int island = 0;
    //go over the 2D array
    for( int i = 0; i < row; i++) {
        for( int j = 0; j < col; j++) {
            //only if you find "1" check for an island
            if(visited[i][j] == false && grid[i][j] == '1') {
                dfs(grid, visited, i, j);
                island++;
            }
        }
    }
      return island;  
    }
}

//Approach 2
class Solution2 {
    //time complexity DFS --> O(mxn)
    void dfs (char[][] grid, int i , int j) {
        //validity check
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
            //mark it
            //System.out.println("Mark (" + i + "," + j + ")");            
            grid[i][j] = '0';
            //go all 4 directions
            dfs (grid, i-1, j);
            dfs (grid, i+1, j);
            dfs (grid, i, j-1);
            dfs (grid, i, j+1);
    }
    
    
    
    public int numIslands(char[][] grid) {
    //check for null case and 0 rows
    if(grid == null || grid.length == 0) return 0;
    int row = grid.length;
    int col = grid[0].length;
    
    //output
    int island = 0;
    //go over the 2D array
    for( int i = 0; i < row; i++) {
        for( int j = 0; j < col; j++) {
            //only if you find "1" check for an island
            if(grid[i][j] == '1') {
                dfs(grid,i,j);
                island++;
            }
        }
    }
      return island;  
    }
}


public class Solution {

//Concept is simple
//1) Visit every cell
//2) If the cell contains 1 , then visit all it's neighbours(each cell can have 8 neighbours) using DFS
//3) Once you return from DFS, then increment count because you have found the island
//Running time O(ROW * COLUMN)
//https://www.geeksforgeeks.org/find-number-of-islands/
//https://leetcode.com/problems/number-of-islands/

  
  //i got this for FB mock test
  class Solution {
    
    
    public boolean isSafe(boolean[][] visited,char[][] grid , int i ,int j) {
        if((i >= 0) &&
           (i < grid.length) &&
           (j >= 0) &&
           (j < grid[0].length) &&
           (visited[i][j] == false) &&
           (grid[i][j] == '1')) {
            return true;
        } else return false;

    }
    
    public void helperDfs(boolean[][] visited,char[][] grid , int i ,int j) {
        visited[i][j] = true;
        System.out.println("the index (i,j) " + "(" + i + " " + j + ")");
        int[] rowcheck = new int[] {0,0,-1,+1};
        int[] colcheck = new int[] {1,-1,0,0};
        //check in all 4 directions
        for ( int k = 0 ; k < 4; k++) {
            if(isSafe(visited,grid ,i+rowcheck[k],j+colcheck[k]) == true) {
                
                helperDfs(visited , grid,i+rowcheck[k],j+colcheck[k]);
            }
        }
                
    }
    public int numIslands(char[][] grid) {
        
        int row = grid.length;
        if(row == 0) return 0;
        int col = grid[0].length;
        
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0 ; j < col ; j++) {
                if(grid[i][j] == '1' && visited[i][j] == false) {
                   helperDfs(visited , grid,i,j); 
                    count++;
                    System.out.println("the count value is " + count);
                    
                }
            }
        }
        return count;
    }
}
  
  
  

  =====================================================================================
  static int ROW;
  static int COLUMN;
  
//this check makes sure we dont go out of bounds , and also ensure to check if we have visited   
  boolean isSafe(int row , int column ,boolean[][] visited) {
    //System.out.println("Debug here");
    return( (row >= 0 && row < ROW) &&
            (column >= 0 && column < COLUMN) &&
            (!visited[row][column]));
  }
  
  //apply DFS recursively 
  void DFS (int row , int column , int[][] M, boolean[][] visited) {
    
   //Apply DFS to all adjacent cells (8)
    
    visited[row][column] = true;
    int[] rowCheck = {-1,-1,-1,0,0,1,1,1};
    int[] columCheck = {-1,0,1,-1,1,-1,0,1};
    
    //some would want to check in 8 directions , and some may want to check in 4 directions
    //so accordingly set the row check and column check
    // In Leet code it is only 4 directions :https://leetcode.com/problems/number-of-islands/
    for (int k = 0 ; k < 8 ;k ++ ) {
      //System.out.println("k = " + k + "row = " + row + "column = " + column);
     if((M[row][column] == 1) && (isSafe(row+rowCheck[k],column+columCheck[k],visited))) {
      //Recursively perform DFS on the unvisited neighbours
      DFS(row+rowCheck[k],column+columCheck[k], M, visited); 
    }
  }
}  

  int countIsland(int[][] M) {
    
    ROW  = M.length;
    if(ROW == 0) {
      return 0;
    }
      
    COLUMN = M[0].length;
    
    //track all the visited 
    boolean[][] visited =  new boolean[ROW][COLUMN];
    int count = 0;
    //count the number of islands
    //Once the DFS returns then increment the count
    //call DFS recursively for each of the member
    for (int i = 0 ; i< ROW ;i++) {
      for (int j = 0 ; j< COLUMN ;j++) {
        if((M[i][j] == 1) && (!visited[i][j])) {
          DFS (i ,j,M ,visited);
          ++count; // here DFS would have returned
        }
       
      }
    }
    return count;
  } 
  
  
 public static void main(String[] args) {
  
  //Variety of Input Arrays
  int[][] M = new int[][] {
    {1,1,0,0,0},
    {0,1,0,0,1},
    {1,0,0,1,1},
    {0,0,0,0,0},
    {1,0,1,0,1}
  };
   
   int[][] N = new int[][] {
    {1,1,1,1,0},
    {1,1,0,1,0},
    {1,1,0,0,0},
    {0,0,0,0,0},
  };
   
   int[][] O = new int[][] {
    {1,1,0,0,0},
    {1,1,0,0,0},
    {0,0,1,0,0},
    {0,0,0,1,1},
  };

   //column is 1 and row is 2
   int[][] P = new int[][] {
    {1},
    {1},
  };
   
   //Empty Array
   int[][] Q = new int[][] {
  };

   
   Solution island = new Solution();
   System.out.println("the number of islands are " + island.countIsland(Q));
  }
}
