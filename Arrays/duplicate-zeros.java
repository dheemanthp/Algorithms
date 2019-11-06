
//https://leetcode.com/problems/duplicate-zeros/submissions/
running time: O(n)
class Solution {
    public void duplicateZeros(int[] arr) {
        
        if(arr == null) return;
        if(arr.length == 0) return;
        //count the number of zero's
        int count  = 0;
        for(int i =0 ; i<= arr.length-1; i++){
            if(arr[i] == 0) {
            count++;    
            }
        }

        int newLength = arr.length + count;
        //j for original array
        //k for new array
        //in place 
        //if you encounter a zero in the original array , and if the k value is greater than the original array then ignore twice
        //if you encounter a valid number in the original array , and if the k value is greater than the original array size then ignore once
        for(int j = (arr.length -1) ,k = (newLength -1) ; j >= 0 && k >= 0;j--,k--) {
            //System.out.println("the arr[j] " + arr[j]);
            //System.out.println("the k value is " + k + " j value is " + j);
            
            //you can have a valid number
            if(arr[j] != 0){
                if(k < arr.length) arr[k] = arr[j];//copy it
            //you can have a zero
            } else{
                if(k < arr.length) arr[k] = arr[j];//copy it once
                k--;
                if(k < arr.length) arr[k] = arr[j];//copy it second time
            }
            
            //Wrote below junk , then above code is cute
           /* if(k <= (arr.length-1)) {
                
                // if zero, copy in 2 slots
                if(arr[j] == 0) {
                    arr[k] = arr[j];
                    k--;
                    arr[k] = arr[j];
                    
                //if non-zero , copy in one slot
                } else{
                    arr[k] = arr[j];
                }
            //until k reaches the original array length use the ignore tactic
            } else{
                
                //if zero ignore 2 slots
                if(arr[j] == 0) {
                    //System.out.println("ignore zero");
                        k--;
                        if(k <= (arr.length-1)) {
                            arr[k] = arr[j];
                        }
                    //if valid number ignore once
                } else{
                    //System.out.println("ignore valid number");
                }             
            }*/
        }
        return;
    }
}
