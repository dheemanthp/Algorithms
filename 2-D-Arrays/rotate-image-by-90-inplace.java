
https://leetcode.com/problems/rotate-image/
http://javabypatel.blogspot.com/2016/11/rotate-matrix-by-90-degrees-inplace.html
// O(n)^2 , as two for loops

class Solution {
    public void rotate(int[][] matrix) {
        //row and column
        int length = matrix.length -1;
        System.out.println("Outerloop will run by Half of length " + (length/2));
        //outerloop by 1/2 length , tells how many rows to cover
        for(int i = 0 ; i <= (length)/2 ;i++){
            // inner loop condition is critical , j = i and j < length -i 
            // starting from i to length - i
            //For Inner loop, it should starts from where outer loop starts and decrements end 
            //layer in each iteration because in each iteration, Left wall and Right wall of matrix
            //is getting rotated, so no need to touch it in next iteration.
            for(int j = i ; j < length - i ;j++){ // when j == i , we exit out of loop
                
                System.out.print("Rotate with  i value " + i + " ");
                System.out.print("Rotate with  j value " + j + " ");
                System.out.print("point 1: "+ "(" +i+","+j+")" + " ");
                System.out.print("point 2: "+ "(" +j+","+(length-i)+")" + " ");
                System.out.print("point 3: "+ "(" +(length-i)+","+(length-j)+")" + " ");
                System.out.print("point 4: "+ "(" +(length-j)+","+i+")" + " ");
                System.out.println();
            
                int p1 = matrix[i][j];
                int p2 = matrix[j][length - i];
                int p3 = matrix[length-i][length-j];
                int p4 = matrix[length-j][i];
                
                matrix[i][j] = p4;
                matrix[j][length - i] = p1;
                matrix[length-i][length-j] = p2;
                matrix[length-j][i] = p3;
            }
        }
    }
}
/*
[[1,2,3],[4,5,6],[7,8,9]]
Outerloop will run by Half of length 1
Rotate with  i value 0 Rotate with  j value 0 point 1: (0,0) point 2: (0,2) point 3: (2,2) point 4: (2,0) 
Rotate with  i value 0 Rotate with  j value 1 point 1: (0,1) point 2: (1,2) point 3: (2,1) point 4: (1,0) 

when i value is 1 , j loop does not run , so we exit

*/
