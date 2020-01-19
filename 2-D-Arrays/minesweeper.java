https://leetcode.com/problems/minesweeper/
//play game here : http://minesweeperonline.com/

//DFS solution
class Solution {
    //given the board and the click point
    public char[][] updateBoard(char[][] board, int[] click) {
        //we can go in 8 directions
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        //call dfs function , board , directions , click X and Y cords
        System.out.println("START [" + click[0] + " " + click[1] + " ]");
        dfs(board, dirs, click[0], click[1]);
        
        return board;
    }
    
    private void dfs(char[][] board, int[][] dirs, int x, int y){
        //check for bounds with respect to click and the board
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return;
        }
        //if the place where you click is an Unrevealed Mine , the game ends
        if (board[x][y] == 'M'){
            board[x][y] = 'X';//make it X and return
            return;//return here
        }
        //if the place where you click is an Unrevelaed Empty Square, then check all 8 directions
        //if there are no adjacent mines to E , then make it into a B cell
        // then do DFS around the B cell
        if (board[x][y] == 'E'){
            int count = 0;
            //check in all 8 directions
            for (int[] dir : dirs){
                //new X
                int nx = x + dir[0];
                //new Y
                int ny = y + dir[1];
                //check if within board limit
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length){
                    //if the neighbour is containing a Mine , then count 
                    if (board[nx][ny] == 'M'){
                        count++;
                    }
                }
            }
            System.out.println("=================All 8 directions complete===============");
            //if count is grater than zero, set the count
            if (count > 0){
                System.out.println("Marking the count[" + x + " " + y + "]" + "=" + count);
                board[x][y] = (char) (count + '0');
                return;
            }
            //otherwise make it as a B cell
            board[x][y] = 'B';
            //now for rest of the directions do a DFS
            for (int[] dir : dirs){
                System.out.println("do DFS here for "+ (x + dir[0]) + " " + (y + dir[1]));
                dfs(board, dirs, x + dir[0], y + dir[1]);
            }
        }
    }
}
