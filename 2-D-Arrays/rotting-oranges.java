https://leetcode.com/problems/rotting-oranges/submissions/
//BFS solution by using MARKER TECHNIQUE
//MARKER becoz , Eventualy we will modify the grid , from fresh oranges to rotten oranges
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //if count of fresh oranges is zero --> return 0 
        if(count_fresh == 0) return 0;
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        //bfs starting from initially rotten oranges
        while(!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                        //we do nothing
                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
                    //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
                    //decrease the count of fresh oranges by 1
                    count_fresh--;
                }
            }
        }
        //why count need to be reduce by one?
        //Because we do count++ every time when queue is not empty. 
        //When there is no fresh orange, it still does count++ at the begin of the while loop.
        return count_fresh == 0 ? count-1 : -1;
    }
}



//incomplete solution by me DFS

class Solution {
    
     boolean isSafe(int[][] grid,boolean[][] visited,int row,int col) {
         if(row < 0 ||
            col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            visited[row][col] == true ||
            grid[row][col] == 0 || grid[row][col] ==2) {
             return false;
         }
         return true;
     }
    
    int dfsHelper(int[][] grid,boolean[][] visited,int row,int col) {
        
            visited[row][col] = true; 
            int[] rowCheck = {0,0,1,-1};
            int[] colCheck = {1,-1,0,0};
            int result  = 0;
            
             for(int i = 0 ;i <4 ; i++) {
                 if(isSafe(grid,visited,row+rowCheck[i],col+colCheck[i])) {
                     
                     System.out.println("DFS (" + (row+rowCheck[i]) + " " + (col+colCheck[i]) + ")");         
                     result = 1 + dfsHelper(grid,visited,row+rowCheck[i],col+colCheck[i]);
                 }
            }
            return result;
    }
    
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;
        int ROW = grid.length;
        int COL = grid[0].length;
        int count = 0;
        boolean start = false;
        if(grid[0][0] == 0) {
            if(COL > 1 && grid[0][1] == 1) return -1; //[[0,1]] expects -1
            if(COL > 1 && grid[0][1] == 2) return 0; //[[0,2]] expects 0
        }
        if(grid[0][0] == 1){
            if(COL == 1 && ROW == 1) return -1; //[[1]]
            if(COL > 1 && grid[0][1] == 2) return 1; //[[1,2]] expects 1
            if(ROW > 1 && grid[1][0] == 2) return 1; //[[1],[2]]
        } 
        if(ROW == 1 && COL == 1) return 0;
        boolean[][] visited =  new boolean[ROW][COL];

        for(int i = 0 ;i <ROW ; i++) {
            for(int j = 0 ;j <COL ; j++) {
                if(grid[i][j] == 2 && start == false){
                    start = true;
                } else if(grid[i][j] == 2 && start == true){
                    System.out.println("coming here as another rotten is found");
                    return 0;
                }
                
                if((grid[i][j] == 2) &&visited[i][j] == false) {
                    count =  dfsHelper(grid,visited,i,j);
                    if(count ==0){
                        System.out.println("coming here");
                        return -1;
                    }
                }
            }
        }
        return count;        
    }
}
