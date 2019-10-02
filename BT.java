
import java.io.*;
import java.util.*;

class Node {
   int key;
   Node left, right;
  
  Node(int value) {
    key = value;
    left = null;
    right = null;
  }
}

//class Binary Tree {
class Solution {
  Node root;
  Solution () {
    root = null; 
  }

 /* 
//Non recursive In order
  void Inorder(Node root) {
    if(root == null) return;
    Node curr = root;
    Stack<Node> S = new Stack<Node>();
    while (curr != null || S.size() > 0 ) {
      //Push all the left items to the stack
      while(curr != null) {
      S.push(curr);
      curr = curr.left;  
      }
      //pop the stack
      curr = S.pop();
      //print the key
      System.out.println(curr.key);
      //point curr to right , if right is null then stack size comes into picture
      curr = curr.right;
    }
    
  }*/


//Non recursive Inorder , returning a Linked List
  LinkedList<Integer> Inorderpractice(Node node) {
  //Init stack and Linked List
  LinkedList<Integer> LL = new LinkedList<Integer>();
  if(node == null) {return LL; }
  Node curr = node;
  Stack<Node> S = new Stack<Node>();
  while(S.size() > 0  || curr != null ) {
    while ( curr != null) {
      S.push(curr);
      curr = curr.left;
    }
    curr = S.pop();
    LL.add(curr.key);
    curr = curr.right;
  }
    return LL;
}    
  
  //Non recursive PreOrder
    void Preorder(Node root) {
      if(root == null) return;
      Node curr = root;
      Stack<Node> S = new Stack<Node>();
      S.push(curr);
      while(S.size() > 0) {
       
       curr = S.pop();
       System.out.println(curr.key); 
       if(curr.right != null) {
        S.push(curr.right);  
       }
       if(curr.left != null) {
        S.push(curr.left);  
       } 
      }      
  }

//Print Level order traversal Line by Line
//https://www.geeksforgeeks.org/print-level-order-traversal-line-line/
      List<List<Integer>> levelOrderlinebyline(Node node) {
      //Note here below syntax
      //List of List is finally the array List of List
      List<List<Integer>> LL = new ArrayList<List<Integer>>();

      if (node == null) {return LL;}
      Queue<Node> Q = new LinkedList<Node>();
      Node curr = node;
      Q.add(curr);
      int nodecount;
      //check until the queue is empty
      while (Q.size() > 0) {

        //keep track of number of elements in queue,and reset it
        nodecount = Q.size();
        //Run this loop for every level
        List<Integer> L = new ArrayList<Integer>();
        while (nodecount > 0) {


        curr = Q.poll();//remove the element from queue
        L.add(curr.key);
        //System.out.print(curr.val + " ");

       if(curr.left != null) { Q.add(curr.left); }
       if(curr.right != null) { Q.add(curr.right);}  
       nodecount --;
        }
        LL.add(L);
        //System.out.println("");
      }
      return LL;
    }

//Print Level order traversal
  void PrintLevelOrderTraversal(Node node) {
    
    if(node == null ) return;
    
    Node curr = node;
    Queue<Node> Q = new LinkedList<Node>();
    Q.add(curr);
    
      while(Q.size() > 0 ) {
       curr = Q.poll();
       System.out.println(curr.key);

       if(curr.left != null) {
         Q.add(curr.left);
       }
       if(curr.right != null) {
         Q.add(curr.right);       
       } 
      }
    
  }
  
  //Non recursive Post Order
  //2 stack solution
  //push root to the stack1
  //pop every item from stack1 and push it to stack2
  //also ensure to push each item left and right to stack1
  //finally when stack1 is empty, print the stack2
  
    public ArrayList<Integer> Postorder(Node root) {
 
        ArrayList<Integer> lst = new ArrayList<Integer>();
 
        if(root == null)
            return lst; 
 
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        System.out.println("debug:::::::push" + root.key); 
 
        Node prev = null;
        while(!stack.empty()){
            Node curr = stack.peek();
 
            // go down the tree.
            //check if current node is leaf, if so, process it and pop stack,
            //otherwise, keep going down
            if(prev == null || prev.left == curr || prev.right == curr){
              if(prev != null ) {
              System.out.println("debug::::::: " + prev.key + "::::::::" + curr.key);  
              } else {
              System.out.println("debug::::::: " + prev + "::::::::" + curr.key);  
              }
              
              
                //prev == null is the situation for the root node
                if(curr.left != null){
                    System.out.println("debug:::::::push" + curr.left.key);  
                    stack.push(curr.left);
                }else if(curr.right != null){
                    System.out.println("debug:::::::push" + curr.right.key);  
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    System.out.println("debug:case1:pop::::: " + curr.key);
                    lst.add(curr.key);
                }
 
            //go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
            }else if(curr.left == prev){
                if(curr.right != null){
                    System.out.println("debug:::here1::::push" + curr.right.key);  
                    stack.push(curr.right);
                }else{
                    stack.pop();
                    System.out.println("debug:case2:pop:::::: " + curr.key);
                    lst.add(curr.key);
                }
 
            //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack. 
            }else if(curr.right == prev){
                stack.pop();
                System.out.println("debug:case3:pop::::: " + curr.key);
                lst.add(curr.key);
            }
            
            prev = curr;
        }
 
        return lst;
    }
  
  
  //Recursive functions
  //Left Root Right
  void PrintInorder(Node n) {
    //base case
    if(n == null) {
      return; 
    }
    PrintInorder(n.left);
    System.out.println(n.key);
    PrintInorder(n.right);
  }
  
  //Root Left Right
  void PrintPreorder(Node n) {
    //base case
    if(n == null) {
      return; 
    }
    System.out.println(n.key);
    PrintPreorder(n.left);
    PrintPreorder(n.right);
  }
  //Left Right Root
  void PrintPostorder(Node n) {
    //base case
    if(n == null) {
      return; 
    }
    PrintPostorder(n.left);
    PrintPostorder(n.right);
    System.out.println(n.key);
  }
  
  
  //Wrapper Functions
  void PrintInorder() { PrintInorder(root); }
  void PrintPreorder() { PrintPreorder(root); }
  void PrintPostorder() { PrintPostorder(root); }
  
  
 public static void main(String[] args) {
   Solution BT = new Solution();
   BT.root = new Node(20) ;
   BT.root.left = new Node(9);
   BT.root.left.left = new Node(4);
   BT.root.left.right = new Node(11);
   BT.root.left.right.right = new Node(13);
   BT.root.left.right.right.right = new Node(15);
   BT.root.right = new Node(22);
   //BT.root.right.left = new Node(8);
   //BT.root.right.right = new Node(15);
   System.out.println("Recursive InOrder");
   BT.PrintInorder();
   System.out.println("Recursive PreOrder");
   BT.PrintPreorder();
   System.out.println("Recursive PostOrder");
   BT.PrintPostorder();
   System.out.println("InOrder");
   //BT.Inorder(BT.root);
   //System.out.println("InOrder practice");
   LinkedList<Integer> LL = BT.Inorderpractice(BT.root);
   Iterator<Integer> itv = LL.listIterator();
   while (itv.hasNext()) {
     System.out.println(itv.next());
   }
   System.out.println("PreOrder");
   BT.Preorder(BT.root);
   System.out.println("PostOrder");
   ArrayList<Integer> list = BT.Postorder(BT.root);
   Iterator<Integer> it = list.listIterator();
   while (it.hasNext()) {
     System.out.println(it.next());
   }
   
   System.out.println("Level order traversal");
   BT.PrintLevelOrderTraversal(BT.root);
   System.out.println("Level order traversal line by line");
   //write iterator to print List of List below
   BT.levelOrderlinebyline(BT.root);
   
  }
}
