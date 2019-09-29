import java.io.*;
import java.util.*;


public class MergeSortedArrays {
//https://www.geeksforgeeks.org/merge-3-sorted-arrays/
//Running time
//if there are 2 arrays of size m and size n
//O(m+n) for 2 arrays
//if there are 3 arrays of size m and n and q
//O(m+n+q) for 3 arrays

  static Vector<Integer> merge(Vector<Integer> v1, Vector<Integer> v2) {
  
  //get size of vectors
  int m = v1.size();
  int n = v1.size();
  System.out.println("the vector size is v1:" + m + "the vector size is v2:" + n); 
  //Resultant Vector
  Vector<Integer> v3 = new Vector<Integer>(m+n);
  
  int i = 0 , j = 0;
  //loop through both arrays
  while (i < m && j < n) {
    if(v1.get(i) < v2.get(j)) {
      v3.add(v1.get(i));
      System.out.println("case 1"); 
      i++;
    } else {
      v3.add(v2.get(j));
      System.out.println("case 2"); 
      j++;
    }
  }
  if(i >= m) {
    while (j < n) {
      v3.add(v2.get(j));
      System.out.println("case 3"); 
        j++;
    }
  } else {
      v3.add(v1.get(i));
      System.out.println("case 4"); 
      i++;
  }
  return v3;    
  }
  
  
  public static void main(String[] args) {

  //create Vector1
    Vector<Integer> v1 = new Vector<Integer>();
    v1.addElement(1);
    v1.addElement(5);
    v1.addElement(7);
    v1.addElement(8);
  //create Vector2
    Vector<Integer> v2 = new Vector<Integer>();
    v2.addElement(2);
    v2.addElement(3);
    v2.addElement(9);
    v2.addElement(10);

    Vector<Integer> v3 = merge(v1,v2);
    Enumeration<Integer> e = v3.elements();
    while(e.hasMoreElements()) {
      System.out.println("the elements are" + e.nextElement()); 
    }
  }
}

