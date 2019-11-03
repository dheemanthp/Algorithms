public class Solution {
    //https://leetcode.com/problems/the-maze/
    //Basic idea is to keep rolling until we hit the WALL
    // once we hit the wall , try to backtrack one step , and store that Cell.
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
