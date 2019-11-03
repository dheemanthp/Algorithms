public class Solution {

//Concept is simple
//1) Visit every cell
//2) If the cell contains 1 , then visit all it's neighbours(each cell can have 8 neighbours) using DFS
//3) Once you return from DFS, then increment count because you have found the island
//Running time O(ROW * COLUMN)
//https://www.geeksforgeeks.org/find-number-of-islands/
//https://leetcode.com/problems/number-of-islands/


  
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
