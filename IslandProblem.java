public class IslandProblem {

//Concept is simple
//1) Visit every cell
//2) If the cell contains 1 , then visit all it's neighbours(each cell can have 8 neighbours) using DFS
//3) Once you return from DFS, then increment count because you have found the island
//Running time O(ROW * COLUMN)


  
  int ROW = 5;
  int COLUMN = 5;
  
//this check makes sure we dont go out of bounds , and also ensure to check if we have visited   
  boolean isSafe(int row , int column ,boolean[][] visited) {
    
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
    
    for (int k = 0 ; k < 8 ;k ++ ) {
     if((M[row][column] == 1) && (isSafe(row+rowCheck[k],column+columCheck[k],visited))) {
      //Recursively perform DFS on the unvisited neighbours
      DFS(row+rowCheck[k],column+columCheck[k], M, visited); 
    }
  }
}  

  int countIsland(int[][] M) {
    
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
   
  int[][] M = new int[][] {
    {1,1,0,0,0},
    {0,1,0,0,1},
    {1,0,0,1,1},
    {0,0,0,0,0},
    {1,0,1,0,1}
  };
   
   IslandProblem island = new IslandProblem();
   System.out.println("the number of islands are " + island.countIsland(M));
  }
}
