fibonacci series

//recursion
public class MyClass {
    
    
    static int fib(int n) {
        
     if (n == 0) return 1;
     if (n == 1) return 1;
      return  (fib(n-1) + fib(n-2));  
    }
    //space optimized storing previous 2 values
    static int fibSpaceOptimized(int n) {
        
     int a = 1;
     int b = 1;
     if(n == 0) return a;
     if(n == 1) return b;
     for(int i = 2; i <= n ; i++) {
         int c = a+b;
         a = b;
         b = c; 
     }
        return b;     
      
    }
    
    public static void main(String args[]) {
      int n=10;
      System.out.println("Fibonacci series is " + fib(9));
      System.out.println("Fibonacci series is " + fibSpaceOptimized(9));
    }
}
