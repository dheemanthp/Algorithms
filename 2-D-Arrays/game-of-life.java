https://leetcode.com/problems/game-of-life/


// State transitions
//  0 : dead to dead//board will contain this
//  1 : live to live//board will contain this
//  2 : live to dead//now these are new modified states
//  3 : dead to live//now these are new modified states

//idea is simple
//modify the board to contain 2 and 3 values , based on the conditions
//finally use MOD by 2 operator to convert it back to 0 and 1 configuration.

public class Solution {
int[][] dir ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
public void gameOfLife(int[][] board) {
    //row
    for(int i=0;i<board.length;i++){
        //column
        for(int j=0;j<board[0].length;j++){
            int live=0;
            //go 8 directions
            for(int[] d:dir){
                //border check fails then continue 
                if(d[0]+i<0 || d[0]+i>=board.length || d[1]+j<0 || d[1]+j>=board[0].length) continue;
                //live check , then increment live++
                if(board[d[0]+i][d[1]+j]==1 || board[d[0]+i][d[1]+j]==2) live++;
            }
            //if there are 3 neighbours , the make it alive
            if(board[i][j]==0 && live==3) board[i][j]=3;
            //if there are less than 2 live neighbours or greater than 3 live neighbours , then make it dead
            if(board[i][j]==1 && (live<2 || live>3)) board[i][j]=2;
        }
    }
    //now finally convert it back by doing a mod of 2
    // hence if it is 2, then 2%2 becomes 0
    // hence if it is 3 , then 3%2 becomes 1
    //convert the board back
    for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            board[i][j] %=2;
        }
    }
}
}
