import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


public class Solution {
    Node head;//head
    //Make this class static , so that it is accessible by the main program
    static class Node {
        int data;
        Node next; // next
    
    public Node(int d) {
          data = d;
          next = null;
        }
    }

/////////////////////////////////////////////////////////////////  
    //Add a node
/////////////////////////////////////////////////////////////////
  
    void add(Node nd) {
        Node temp = head;
        if(head == null) {
            head = nd;
        }
        //move to the end of the Node
        while(temp.next != null) {
            temp =  temp.next;
        }
       //add the new node here
        temp.next = nd;
        return;
    }

/////////////////////////////////////////////////////////////////
//Count the occurence of a given value
/////////////////////////////////////////////////////////////////
    int count(int value) {
      Node temp = head;
      int count = 0;
      while (temp != null) {
        if(temp.data == value) {
          count++;
        }
        temp = temp.next;
      }
      return count;
    }

/////////////////////////////////////////////////////////////////
//Write a GetNth() function that takes an integer index and 
//returns the datavalue stored in the node at that index position.
/////////////////////////////////////////////////////////////////
    int GetNth(int index) {
      Node temp = head;
      int pos = 0;
      while (temp != null) {
        if(pos == index){
          return temp.data;
        } else {
          pos++;
          temp =  temp.next;
        }
      }
      return -1;
    }
/////////////////////////////////////////////////////////////////
//Write a InsertNth() function that takes a new node at integer index
/////////////////////////////////////////////////////////////////
    boolean InsertNth(int index, Node newNode) {
      Node temp  = head;
      int pos = 0;
      //base case
      if (temp == null) {
        head = newNode;
        return true;
      }
      //Insert at the beginning
      if(index == 0) {
         newNode.next = head;
        head = newNode;
        return true;
        }
      //traverse
      while(temp != null) {
        if(pos == index-1) {
          newNode.next =  temp.next;
          temp.next = newNode;
          return true;
        } else {
          pos++;
          temp = temp.next;
        }
      }
      //throw new IllegalArgumentException("Input index is out of bound");
      return false;
    }
/////////////////////////////////////////////////////////////////
//Remove Duplicates
/////////////////////////////////////////////////////////////////
    boolean removeDuplicates(int value) {
      Node curr = head;
      Node prev = null;
      
      if(curr == null ) {
        return false;
      }
       
        boolean found = false;
        while(curr != null) {
          if(curr.data == value) {
            found = true;
            break;
        } else {
            prev = curr;
            curr = curr.next;
        }
      }
      //now delete all the nodes from here on which match the value
      if(found == true) {
        prev = curr; // need to retain this value
        
        //skipped all the duplicate values
        while (curr.data == value || curr == null) {
         curr = curr.next;
        }
        prev.next = curr;
        return true;
      }
        return false;
    }
/////////////////////////////////////////////////////////////////
//Shuffle Merge
/////////////////////////////////////////////////////////////////
    Node shuffleMerge(Solution ld,Solution ldNew) {
      Node first = ld.head;
      Node second = ldNew.head;
    
      while(true) {
        System.out.println("merge");
        //base case
        if(first == null) {
          System.out.println("case 1");
          ld.head = second;
          break;
        } else if(second == null) {
          System.out.println("case 2");
          break;
        } else if (first.next == null) {
          System.out.println("case 3");
         first.next = second;
         break;
        } else if (second.next == null) {
          System.out.println("case 4");
          second.next = first.next;
          first.next = second;
          break;
        }

        Node temp;
        //Integrate it to first LinkedList
        if(first != null && second != null) {
          System.out.println("start merge" + "first"+ first.data + "second" + second.data);
          temp = second.next;
          second.next = first.next;
          first.next = second;
          first = second.next;
          second = temp;
          System.out.println("after merge" + "first"+ first.data + "second" + second.data);
          System.out.println("merge complete");
        }
      }
      return ld.head;
    }
/////////////////////////////////////////////////////////////////
//Reverse
/////////////////////////////////////////////////////////////////
  void reverse() {
    
    Node pres = head;
    if(pres == null) return;
    
    Node prev = null;
    Node next = null;
    
    while(pres != null) {
      System.out.println("loop" + pres.data);
      next = pres.next;
      pres.next = prev;
      prev = pres;
      pres = next;
    }
    
    head = prev;
    return;
  }
/////////////////////////////////////////////////////////////////
//Recursive Reverse
/////////////////////////////////////////////////////////////////
  void recursiveReverse(Node base) {
    Node first;
    Node rest;
    
    //base case
    if(base == null) return;
    
    first =  base;
    rest = first.next;
    
    if(rest == null) {
     head = first; 
      return;
    }
    recursiveReverse(rest);
    rest.next = first;
    first.next = null;
  }

/////////////////////////////////////////////////////////////////    
    //print a node
/////////////////////////////////////////////////////////////////  
    void print(Node nd) {
    Node temp = nd;
     while(temp != null){
         System.out.println("data is: " + temp.data);
         temp = temp.next;
     }
    }
/////////////////////////////////////////////////////////////////    
    //Delete a node
/////////////////////////////////////////////////////////////////
      boolean delete(int value) {
        Node pres = head;
        Node prev = null;
        
        if(pres == null) {
          return false;
        }
        if(pres.data == value) {
          head = pres.next;
          return true;
        }
        //move to the end of the Node
        while(pres != null) {
          if(pres.data == value) {
             //unlink here 
             prev.next = pres.next;
             return true;
          } else {
              prev = pres;
              pres = pres.next;
            }  
        }//end of while loop
        return false;
    }
  
  
    
    //Driver Program    
    public static void main(String[] args) {
        Solution ld = new Solution();
        //create a head node
        ld.head = new Node(1);
        System.out.println("======================================================");
        //add more nodes
        ld.add(new Node(2));
        ld.add(new Node(3));
        ld.add(new Node(4));
        ld.add(new Node(10));
        ld.add(new Node(10));
        ld.add(new Node(20));

        //ld.add(new Node(5));
        //ld.add(new Node(4));
        System.out.println("======================================================");
        //print
        ld.print(ld.head);
        
        System.out.println("======================================================");
        //delete a node based on value
        if (ld.delete(3)) {
            System.out.println("data" + 3 + "deleted");
            //print
            ld.print(ld.head);
        } else {
            System.out.println("data not present");
        }
        
        System.out.println("======================================================");
        //count the occurance of a given a value
        int count = ld.count(4);
        System.out.println("count " + count);
        
        System.out.println("======================================================");
        //Get Nth
        int pos = 2;
        int value = ld.GetNth(pos);
        if (value != -1) {
            System.out.println("value found:" + value + " in position:" + pos);
            //print
            ld.print(ld.head);
        } else {
            System.out.println("data not present");
        }
        
        System.out.println("======================================================");
        //InsertNth
        pos = 3;
        if(ld.InsertNth(pos, new Node(10))) {
            System.out.println("value inserted at pos: " + pos);
            //print
            ld.print(ld.head);
       } else {
            System.out.println("the position is invalid");          
       }
       
       System.out.println("======================================================");
       //Remove Duplicates
       System.out.println("Remove Duplicates");
       ld.removeDuplicates(10);
       //print
       ld.print(ld.head);
       
        System.out.println("======================================================");
      //ld.delete(1);
      //ld.delete(2);
      //ld.delete(4);
      //ld.delete(10);
      //ld.delete(20);
      
       //Shuffle Merge
       //create a new List
        Solution ldNew = new Solution();
        //create a head node
        ldNew.head = new Node(100);
              //add more nodes
        ldNew.add(new Node(200));
        ldNew.add(new Node(300));
        ldNew.add(new Node(400));
      //print
        System.out.println("===============Old Linked list========================");
        ld.print(ld.head);
        System.out.println("===============New Linked list========================");
      //print
        ld.print(ldNew.head);
        System.out.println("=============Shuffle Merge Output====================");
        ld.shuffleMerge(ld,ldNew);
        //print
        ld.print(ld.head);
        System.out.println("==================Reverse============================");
        //Reverse
        ld.reverse();
        ld.print(ld.head);
        System.out.println("===============Recursive Reverse=====================");
        //Reverse
        Node temp = ld.head;
        ld.recursiveReverse(temp);
        ld.print(ld.head);
        System.out.println("======================================================");

      
        return;  
    }
}
