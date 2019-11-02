//MEDIUM

public class Solution {
//https://leetcode.com/problems/walls-and-gates/submissions/
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        int INF = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    System.out.println("Adding the gate: "+ "("+ i+ " " + j + ")");
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        //run the while loop until queue is not empty
        while(!queue.isEmpty()) {
            //remove the item from the queue
            int[] top = queue.remove();
            int row = top[0];
            int col = top[1];
            //now check all the 4 directions around the given cell
            //above
            System.out.println("===");
            System.out.println("pop out "+ "("+ row + " " + col + ")");
            //above
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                System.out.println("Condition 1");
                System.out.println("Condition 1 "+ "("+ (row - 1) + " " + col + ")");
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            //below
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                System.out.println("Condition 2");
                System.out.println("Condition 2 "+ "("+ (row + 1)+ " " + col + ")");
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            //left
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                System.out.println("Condition 3");
                System.out.println("Condition 3 "+ "("+ row+ " " + (col - 1) + ")");
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            //right
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                System.out.println("Condition 4");
                System.out.println("Condition 4 "+ "("+ row+ " " + (col + 1) + ")");
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
}
