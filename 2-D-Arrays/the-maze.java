public class Solution {
    //https://leetcode.com/problems/the-maze/
    //Basic idea is to keep rolling until we hit the WALL
    // once we hit the wall , try to backtrack one step , and store that Cell.
 /*
 
 In order to implement this, we make use of a queue. 
 We start with the ball at the startstartstart position. 
 For every current position, we add all the new positions possible by traversing 
 in all the four directions(till reaching the wall or boundary) into the queue
 to act as the new start positions and mark these positions as True in the visited
 array. When all the directions have been covered up, we remove a position value, 
 sss, from the front of the queue and again continue the same process with sss 
 acting as the new start position.

Further, in order to choose the direction of travel, we make use of a dir array, 
which contains 4 entries. Each entry represents a one-dimensional direction of travel.
To travel in a particular direction, we keep on adding the particular entry of the 
dirs array till we hit a wall or a boundary. For a particular start position,
we do this process of dir addition for all all the four directions possible.

If we hit the destination position at any moment, we return a True directly indicating 
that the destination position can be reached starting from the start position.
 
 Complexity Analysis

    Time complexity : O(mn). Complete traversal of maze will be done in the worst case. 
    Here, m and n refers to the number of rows and coloumns of the maze.

    Space complexity : Space complexity : O(mn). visited array of size m∗n is used 
    and queue size can grow upto m∗n in worst case.
 */
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] curPos = queue.remove();
            System.out.println("CHECK CURRENT CELL " + curPos[0]+ " " + curPos[1]);
            if (curPos[0] == destination[0] && curPos[1] == destination[1]) {
                return true;
            }
            // from current cell , try four directions until it hits the wall
            for (int direction = 0; direction < 4; direction++) {
                int travelX = curPos[0], travelY = curPos[1];
                //keep going in one direction only, until you hit the wall
                while (travelX >= 0 && travelX < m && travelY >= 0 && travelY < n && maze[travelX][travelY] == 0) {
                    travelX += dx[direction];
                    travelY += dy[direction];
                    System.out.println("KEEP GOING " + travelX+ " " + travelY);
                    
                }
                System.out.println("WALL HIT " + travelX+ " " + travelY);
                //back one step
                //since we hit the wall , go back one step , and add this cell to the Queue, so that we can visit this later
                travelX -= dx[direction];
                travelY -= dy[direction];
                System.out.println("BACKTRACK, LOCK IN AS IT IS NEAR THE WALL" + travelX+ " " + travelY);
                if (!visited[travelX][travelY]) {
                    //mark this cell as visited
                    System.out.println("VISITED" + travelX+ " " + travelY);
                    visited[travelX][travelY] = true;
                    queue.add(new int[]{travelX, travelY});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
        int[][] maze = new int[][]{  {0,0,1,0,0},
                                     {0,0,0,0,0},
                                     {0,0,0,1,0},
                                     {1,1,0,1,1},
                                     {0,0,0,0,0}
                                   };
        int[] start = new int[] {0,4};
        int[] destination = new int[] {4,4};
        hasPath(maze, start, destination);
    }
    
}
