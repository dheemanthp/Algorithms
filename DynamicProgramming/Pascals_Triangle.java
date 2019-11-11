//=======================================================================================================
//https://www.programcreek.com/2013/01/leetcode-triangle-java/ 
//DP solution : https://leetcode.com/problems/triangle/discuss/38730/dp-solution-for-triangle
//Minimum path sum of a triangle:

//Bottom-up' DP
class Solution {
    //back tracking solution , start from last but one row
    //O(n)
    public static int minimumTotal(List<List<Integer>> triangle) {
        //start from last but one row.
        for(int i = triangle.size()-2 ; i >= 0 ; i-- ) {
            //for the last but one row , traverse every element
            //modify the element 
            for(int j = 0 ; j < triangle.get(i).size() ; j++ ) {
              //now try to find the minimum of 2 elements from next row                
              int previousMin =  Math.min(triangle.get(i+1).get(j) , triangle.get(i+1).get(j+1));
              //now add the minimum to the current element
              int current = triangle.get(i).get(j) + previousMin;  
              //store it   
              triangle.get(i).set(j,current);
            }
        }
        //finally the first element will have the minimum sum
        return triangle.get(0).get(0);
    }
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList(2));
        triangle.add(new ArrayList<Integer>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
        System.out.println(" the minimum cost is " + minimumTotal(triangle));
    }
    
}

//=======================================================================================================
//https://leetcode.com/problems/pascals-triangle-ii/
//here you will use previous solution and modify the curent array
// if K = 3 , then means there are 4 rows, and hence 4 elements , first Backfill them
//Deadly Amazing Backfill solution
//0 0 0 0
//1 0 0 0
//1 1 0 0
//1 2 1 0
//1 3 3 1

public class Solution {
    public List<Integer> getRow(int k) {
        Integer[] arr = new Integer[k + 1];
        //BackFill with zero
        Arrays.fill(arr, 0);
        //init the first element
        arr[0] = 1;
        // if input is 3, that means we will have 4 rows , hence i <=3 , 0,1,2,3
        for (int i = 0; i <= k; i++) {
        //now first time we will not enter here 
        //J should always be greater than zero , as we will be check (j-1)th element
            for (int j = i; j > 0; j--) { 
                arr[j] = arr[j] + arr[j - 1];
                System.out.print("i is " + i + " j is " + j + "the arr is " + arr[j] + " ");
            }
            System.out.println();
        }       
        return Arrays.asList(arr);
    }
}
//=======================================================================================================
//Both the below problems are solved here by me
//https://leetcode.com/problems/pascals-triangle/
//https://leetcode.com/problems/pascals-triangle-ii/

class Solution {

    //problem 2
    public List<Integer> getRow(int rowIndex) {
     List<List<Integer>> output = generate(rowIndex+1);
     return output.get(rowIndex);
    }
    //problem 1
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new LinkedList<List<Integer>>();
        for(int i = 0 ;i < numRows ; i++) {
            List<Integer> row = new  LinkedList<Integer>();
            row.add(1);
            for(int j = 1 ;j < i; j++) {
                List<Integer> previoustRow = output.get(i-1);
                    row.add(previoustRow.get(j-1) +previoustRow.get(j));
            }
            if(i > 0) {
                row.add(1); }
         output.add(row);   
        }
        return output;
    }
}
