

//https://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
public class MyClass {
    
    static void swap(int[] input, int i, int j) {
        if(input == null) return;
        input[i] ^= input[j];
        input[j] ^= input[i];
        input[i] ^= input[j];
        }
    
    public static void main(String args[]) {
        
        
        
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9};
        
        int j =0;
        for(int i = 0; i < arr.length-1; i++) {
            
            if(arr[i] % 2 == 0) {
                swap(arr,i,j);
                j++;
            }

        }
        
       for(int k : arr) {
        System.out.println("array value is " + k);    
       } 

      
    }
}
