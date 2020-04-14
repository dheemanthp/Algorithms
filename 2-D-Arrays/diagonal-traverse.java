class Solution {
    //https://leetcode.com/problems/diagonal-traverse/
    //Running time complexity : mxn
    //Running space complexity :Note that the space occupied by the output array doesn't count towards 
    //the space complexity since that is a requirement of the problem itself.
    
    /*
    output : [1,2,4,7,5,3,6,8,9]
    
    
store the result is 1 , row 0 col 0 EVEN GO UP
Next going right in same row
 store the result is 2 , row 0 col 1 ODD GO DOWN
Next Diagonally going Down
 store the result is 4 , row 1 col 0 ODD GO DOWN
Next going down in same col
 store the result is 7 , row 2 col 0 EVEN GO UP
Next Diagonally going up
 store the result is 5 , row 1 col 1 EVEN GO UP
Next Diagonally going up
 store the result is 3 , row 0 col 2 EVEN GO UP
Next going down in same col
 store the result is 6 , row 1 col 2 ODD GO DOWN
Next Diagonally going Down
 store the result is 8 , row 2 col 1 ODD GO DOWN
Next going right in same row
 store the result is 9 , row 2 col 2 EVEN GO UP
    
    */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return new int[0];
        } 

        //Idea is the following
        //notice all values in the same diagonal share the same sum value of x index + y index
        //direction of going up right or going down left depends whether the index sum is even or odd
        //for each even or odd diagonal, there are three cases:
        // 1. there is room to go that direction 
        // 2. there is no row space to go further but there is col space 
        // 3. there is no col space to go further but there is row space
        int rows = matrix.length;
        int cols = matrix[0].length;
        //new result array
        int[] res = new int[rows * cols];
        int r = 0;
        int c = 0;
        //
        for (int i = 0; i < rows * cols; i++) {
         res[i] = matrix[r][c];
        String OddEven = ((r +c)%2 == 0)?" EVEN GO UP":" ODD GO DOWN";
         System.out.println(" store the result is " + res[i] + " , row " + r + " col " + c + OddEven);
            
          // even sum diagonal always goes up
          if ((r + c) % 2 == 0) {
            
             
            //Next Go up Diagonally  
            if (r - 1 >= 0 && c + 1 < cols) {
                System.out.println("Next Diagonally going up");
              c = c + 1;
              r = r - 1;
            //Next Go Right in same row
            } else if (r - 1 < 0 && c + 1 < cols) {
                System.out.println("Next going right in same row");
              c = c + 1;
            //Next Go Down in same column
            } else if (r + 1 < rows && c + 1 > cols - 1) {
                System.out.println("Next going down in same col");
              r = r + 1;
            }
              
          }
          // odd sum diagonal always goes down
          else if ((r + c) % 2 != 0) {
              
            
              //Next Go Down Diagonally  
            if (r + 1 < rows && c - 1 >= 0) {
                System.out.println("Next Diagonally going Down");
              c = c - 1;
              r = r + 1;
              //Next Go Down in same column
            } else if (r + 1 < rows && c - 1 < 0) {
                System.out.println("Next going down in same col");
              r = r + 1;
              //Next Go Right in same row
            } else if (r + 1 > rows - 1 && c +1 < cols) {
                System.out.println("Next going right in same row");
              c = c + 1;
            }
              
          }
        }
        return res;
    }
}


