public class Solution {
  //https://leetcode.com/discuss/interview-question/398023/Microsoft-Online-Assessment-Questions
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
//==============================================================================================================================
  //Largest MAX PAIR (of negative and positive)
//find largest positive, negative number in array
//Also got Min Moves to Make String Without 3 Identical Consecutive Letters, Longest Semi-Alternating Substring
//==============================================================================================================================  
  import java.util.*; 
public class Solution {

  public static int pair(int[] arr) {
      
      Set<Integer> S = new HashSet<Integer>();
      int max = Integer.MIN_VALUE;
      for(int i =0 ; i < arr.length ; i++) {

          if(S.contains(-1 * arr[i])) {
             if((-1 * arr[i]) > (arr[i])) {
                 max =Math.max(max,(-1 * arr[i]));
                 //System.out.println(arr[i] + " "  + (-1 * arr[i]));
             } else {
                 max =Math.max(max,(arr[i]));
                 //System.out.println((-1 * arr[i]) + " " + arr[i]);
             }
              
          } else {
              S.add(arr[i]);
          }
      }
      return max;      
  }


    public static void main(String args[]) {

      int[] arr = new int[]{ 4, 8,-10, 9, -4, 1, -1, -8, -9 ,10};
      int max =  pair(arr);
      System.out.println("max pair is" + -max + " " + max);

    }
}
//==============================================================================================================================
//System Design Question : Logger : //https://www.baeldung.com/java-write-to-file
//==============================================================================================================================  
Class Logger {
  private final Object lock;
  private BufferedWriter out;
  private FileWriter fstream;
  
  Logger() {
    lock = new Object();
    out = null;
    fstream = null;
  }
  
  void open(String file) {
    fstream = new FileWriter(file, true); //true tells to append data.
    out = new BufferedWriter(fstream);
    
    
  }
  void write(int[] intArray) {
    synchronized (lock)
        {   
            for(int i : intArray) {
              //write integer
              try {
                out.write(i);
              } catch (IOException e) {
                  System.err.println("Error: " + e.getMessage());
              } 
            }
        }
  }
  void write(String[] strArray) {
    synchronized (lock)
        {
            for(String str : strArray) {
              //write String
              try {
                out.write(str);
              } catch (IOException e) {
                  System.err.println("Error: " + e.getMessage());
              } 
            }
        }
  }
  
  void close {
        if(out != null) {
        out.close();
    }
  }
}





