public class Solution {
  //https://leetcode.com/discuss/interview-question/334888/microsoft-azure-compute-online-assessment-2019
  //Question1 :Best answer
  //Based on the principle that
  //From the pattern it is quite clear that 
  //if  n == (Math.pow(2, i) - 1) , then it is always 1
  //other wise it is always 0
  public static int nthTermModified(int n) {
      //base case
      if( n == 0 ) return 0;
      //base case
      if (n == 1) return 1;
      //loop until (Math.pow(2, i) - 1) > n
      for (int i = 2; i < n ; i++) {
        if((Math.pow(2, i) - 1) ==  n)
            return 1;//condition satisifed return 1
        if ((Math.pow(2, i) - 1) > n )
            return 0;//condition satisifed return 0
      }
      return 0;      
  }
  //Question1 :Simple answer
  //Straight forward solution of memoization
   public static int nthTerm(int n) {
      
       if(n == 0) return 0;
       if (n ==1) return 1 ;

          boolean odd,even;
          int i = 2;
          int[] store = new int[n+1];
          store[0] = 0; store[1] = 1;
          while (i <= n) {
              if(i%2 == 0) {
                store [i] = 3 * store[i-2];
                System.out.println("even " + i + " result " + store[i]);
              } else {
                store [i] = store [i/2] + 2 * store[i-1];  
                System.out.println("odd " + i + " result " + store[i]);
                
              }
              i++;
          }

        return store [n];
   }


    public static void main(String args[]) {

      //System.out.println("the nth term is " + nthTerm(1));
      System.out.println("the nth term is " + nthTermModified(2));
      System.out.println("the nth term is " + nthTermModified(3));
      System.out.println("the nth term is " + nthTermModified(4));
      System.out.println("the nth term is " + nthTermModified(5));
      System.out.println("the nth term is " + nthTermModified(6));
      System.out.println("the nth term is " + nthTermModified(7));
      System.out.println("the nth term is " + nthTermModified(8));
      System.out.println("the nth term is " + nthTermModified(15));
    }
}
