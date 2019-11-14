

public class MyClass {
    
      static void swap(int[] input, int i, int j) {
      if(input == null) return;
      input[i] ^= input[j];
      input[j] ^= input[i];
      input[i] ^= input[j];

      }
      
    public static void helper(int[] arr, int low,int high) {
        if(low >= high) return;
        else {
            helper(arr,low+1,high-1);
            swap(arr,low,high);
        }
    }

    public static void main(String args[]) {
    
    int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
    helper(arr,0,arr.length-1);
    for(int a : arr) {
        System.out.println(a);
    }

    }
}
