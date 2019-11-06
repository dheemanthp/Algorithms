
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

  class Node {
   int data;
   Node left;
   Node right;

   Node(int value) {
     data = value;
     left = null;
     right = null;
   } 
  }

public class Solution {
//http://cslibrary.stanford.edu/110/BinaryTrees.html
//Did not do 12. countTrees()

  
  
  Node head;
  //Level Order Traversal
  void LevelOrderTraversal (Node node) {
  //print it out
    
  if (node == null) return;
  Node curr = node;
  Queue<Node> Q = new LinkedList<Node>();
  
  
  int count  = 0;
  Q.add(curr);
   while(Q.size() > 0 ) { 
  
    count  = Q.size(); 
    System.out.println("Queue size is " + count); 
    while(count > 0 ) {
      Node output = Q.poll();
      System.out.print(output.data+ " ");
      if(output.left != null ) { Q.add(output.left); };
      if(output.right != null ) { Q.add(output.right); };
      count --;
    }
    System.out.println();
   }
  }
  
/*
 *Give a binary search tree and a number, inserts a new node
 *with the given number in the correct place in the tree.
 */
  Node CreateBST(Node node, int value) {
    //if head is null
    if(node == null) {
         return new Node(value);
    }
    //traverse through the BST
    if(value <= node.data) {
       node.left = CreateBST(node.left,value);
    }
    if(value > node.data) {
      node.right = CreateBST(node.right,value);
    }
    // return the (unchanged) node pointer
    return node;
  }
   
  //Lookup
  boolean LookUp(Node node, int value) {
    //if head is null base case
    if(node == null) {
         return false;
    }
    if(value == node.data) return true;
    else {
      return (LookUp(node.left,value) ||
              LookUp(node.right,value));
    }
  }

  /*simple binary tree traversal. 
   *Given a binary tree, count the number of nodes in the tree.
   */
  int Size(Node node) {
    int count = 0;
  
    if(node == null) return 0;
    else {
     return(1 + Size(node.left) + Size(node.right));
    }
  }

	
//Delete a node in a BST Tree 
//https://leetcode.com/problems/delete-node-in-a-bst/submissions/ 
	
    //https://www.youtube.com/watch?v=gcULXE7ViZw
    public static TreeNode findMin(TreeNode root) {
        if(root == null) return null;
        else {
           while (root.left != null) {
               root = root.left;
           }
            return root;
        }
    }
    
    
   
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(key < root.val) { root.left = deleteNode(root.left,key); }
        else if (key > root.val) { root.right = deleteNode(root.right,key); }
        else {
            //3 cases
            // 1st case: it is a leaf node
            if(root.left == null && root.right == null) {
                root = null;
                //return null;
            }
            //2nd case : it has only one child
            else if(root.left == null) {
                TreeNode temp = root;
                root = root.right;
                temp = null;
                //return root;
            }
            //2nd case : it has only one child
            else if(root.right == null) {
                TreeNode temp = root;
                root= root.left;
                temp = null;
                //return root;
            } else {
            //3rd case : it has 2 children
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right,temp.val);
                //return root;
            }
        }
        return root;
        
        
    }
	
	
//Symmetric Tree (Mirror Image of itself)
//Given a binary tree, check whether it is a mirror of itself.  
//https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/
//Running time O(n)  
  
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root,root);
    }    
    
    public boolean isSymmetricHelper(TreeNode root1,TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        else if(root1 != null && root2 != null && root1.val == root2.val) {
            return (isSymmetricHelper(root1.left,root2.right) &&
                    isSymmetricHelper(root1.right,root2.left));
        } else {
           return false;
        }
    }  

/*
This solution updates the max variable whenever the sum of left subtree and right subtree 
is greater than the previous max sum. The return statement only keep track of the height of a node. 
Brilliant solution!
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/diameter-of-binary-tree/submissions/
public class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //System.out.println(root.val);
        //System.out.println("the left depth is " + left);
        //System.out.println("the right depth is " + right);            
        //tracks height of left subtree + right subtree
        max = Math.max(max, left + right);
        //System.out.println("max is " + max); 
        //System.out.println("returning " + (Math.max(left, right) + 1)); 
        //track height of tree from a given node
        return Math.max(left, right) + 1;
    }
}

	
	
/*
 Diameter of a tree
 O(n^2)
 This is not an optimized solution , hence below solution is O(n^2)
 Optimized implementation: The above implementation can be optimized by calculating the height in the same recursion rather than calling a height() separately.
 Thanks to Amar for suggesting this optimized version. This optimization reduces time complexity to O(n).
 https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
*/
int diameter(Node node) {
    if(node == null) return 0;
    int lheight = maxDepth(node.left);//passing through root
    int rheight = maxDepth(node.right); //passing through root
    int ldiameter = diameter(node.left); //recursively check without the root
    int rdiameter = diameter(node.right); ////recursively check without the root
    int fd = Math.max(lheight+rheight+1, Math.max(ldiameter,rdiameter));
    return fd;
}

/*
 Compute the "maxDepth" of a tree -- the number of nodes along
 the longest path from the root node down to the farthest leaf node.
*/
  int maxDepth(Node node) {
    int count = 0;
  
    if(node == null) return 0;
    else {
     return(Math.max(1 + maxDepth(node.left), 1+ maxDepth(node.right)));
    }
  }

/*
 Compute the "minDepth" of a tree -- the number of nodes along
 the shortest path from the root node down to the farthest leaf node.
*/
//NOTE :dheemz : the path must end on a leaf node 
//     :Note that the path must end on a leaf node.
//     Hence the input of [3,2] is not 1 but 2
//check special case is updated for this purpose
  
  public int minDepth(Node root) {
        if(root == null) return 0;
        //Special case: If left subtree is NULL, recur for right subtree 
        else if (root.left == null) 
            return minDepth(root.right) + 1; 
        //Special case: If right subtree is NULL, recur for left subtree 
        else if (root.right == null) 
            return minDepth(root.left) + 1; 
        //normal case
        else {
            return Math.min(1+minDepth(root.left),1+minDepth(root.right));
        }
    }

  
 /*
 Given a non-empty binary search tree,
 return the minimum data value found in that tree.
 Note that the entire tree does not need to be searched.
*/
  int minValue(Node node) {
   if(node == null) return 0;
    else {
      while(node.left != null) {
        node = node.left;
      }
      return node.data;
    }
  }
  
 /*
 Given a binary search tree, print out
 its data elements in increasing
 sorted order.
*/

  void sortedOutput(Node node) {
   if(node == null) return;
    
    sortedOutput(node.left);
    System.out.print(node.data + " ");
    sortedOutput(node.right);
    
    return;
  }


//Sum Root to Leaf Numbers
//apply DFS(O(n))
/*  
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
Note: A leaf is a node with no children. 
https://leetcode.com/problems/sum-root-to-leaf-numbers/
*/  
public int sumNumbers(Node root) {
	//trick is to send a zero here
	return sum(root, 0);
}

public int sum(Node n, int sum){
	if (n == null) return 0;
    sum = sum*10 + n.data;
    System.out.println("Sum is " + sum);
	if (n.right == null && n.left == null) return sum;
	return (sum(n.left, sum) + sum(n.right, sum));
  }
}  
  
 /*
 Given a tree and a sum, return true if there is a path from the root
 down to a leaf, such that adding up all the values along the path
 equals the given sum.

 Strategy: subtract the node value from the sum when recurring down,
 and check to see if the sum is 0 when you run out of tree.
*/
//https://leetcode.com/problems/path-sum/submissions/  
    public boolean hasPathSum(Node root, int sum) {
        return hasPathSumHelper(root,sum);
        }
    
    private boolean hasPathSumHelper(Node root,int sum) {
        if(root == null) {
            return false;         
        } 
        sum = sum - root.data;
        
        if (root.left == null & root.right == null && sum == 0) {
         return true;      
        }
        else {
            System.out.println("the data is:" +root.data +"sum is: "+  sum);
            return (hasPathSumHelper(root.left,sum) || hasPathSumHelper(root.right,sum));
        }
    }  
  
//the below code was breaking in Leetcode
  /*  boolean hasPathSum(Node node , int sum) {
    //base case
    if(node == null) {
     if(sum == 0 ) return true;
     else return false;
    }
    //decrement in every step
    sum = sum-node.data;
      return(hasPathSum(node.left,sum) ||
             hasPathSum(node.right,sum));
  }*/
  
  
  /*
 Change a tree so that the roles of the
 left and right pointers are swapped at every node.
 */
  
  void mirror(Node node) {
    
    if(node == null) return;
    mirror(node.left);
    mirror(node.right);
    
   //swap
    Node temp = node.left;
    node.left = node.right;
    node.right = temp;
  }
  
/*
 For each node in a binary search tree,
 create a new duplicate node, and insert
 the duplicate as the left child of the original node.
 The resulting tree should still be a binary search tree.
 */
  void duplicate(Node node) {
  if(node == null ) return;
  duplicate(node.left);
  duplicate(node.right);
  Node temp = new Node(node.data);
  temp.left = node.left;
  node.left = temp;  
  }
  
/*
 Given two trees, return true if they are
 structurally identical.
*/
  
  boolean sameTree(Node node1, Node node2) {
  if(node1 == null && node2 == null) return true;
  if(node1 != null && node2 == null) return false;
  if(node1 == null && node2 != null) return false;
   return (sameTree(node1.left, node2.left) &&
           sameTree(node1.right, node2.right));
  }    


/*
 *Returns true if a binary tree is a binary search tree.
 *Send the upper limit value and lower limit value
 *https://leetcode.com/problems/validate-binary-search-tree/submissions/
 *https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 */
 public boolean helper(TreeNode node, Integer lower, Integer upper) {
      //if node is null return here
    if (node == null) return true;
    
    // now hold the value here
    int val = node.val;
      System.out.println("val " + val + "lower " + lower + " upper " + upper);
      //if current value is lesser than lower
    if (lower != null && val <= lower) return false;
      //if current value is greater than upper
    if (upper != null && val >= upper) return false;

    if(helper(node.right, val, upper) && helper(node.left, lower, val)) {
        return true;
    } else{
        return false;
    }
  }

  public boolean isValidBST(TreeNode root) {
      //helper function is important here
    return helper(root, null, null);
  }


/*
 WARNING : BELOW APPROACH WILL FAIL FOR SOME TREES:
 DO NOT USE THIS APPROACH
 Returns true if a binary tree is a binary search tree.
*/ 
  boolean isBST(Node node) {
    if(node == null) return true;
    if(node.left != null && node.left.data > node.data) {
      return false;
    }
    if(node.right != null && node.right.data <= node.data) {
      return false;
    }
    return (isBST(node.left) && isBST(node.right));
      
  }
  
 /*
 Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z':
 a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically
smaller than "aba".  A leaf of a node is a node that has no children.)
 */
 //https://leetcode.com/problems/smallest-string-starting-from-leaf/submissions/ 
 public String smallestFromLeaf(TreeNode root) {
    //perform DFS
    return smallestFromLeafHelper(root,"");
} 
    
public String smallestFromLeafHelper(TreeNode root,String suffix) {
    if(root == null) return suffix;
    //at every visit , add the character to the right
    //final solution will have the first character to the right
    //
    
    suffix = (char)('a' + root.val) + suffix;
    
    if(root.left == null && root.right==null) {
        return suffix;
    }
    //if the left is null go to right
    //if the right is null go the left
    if(root.left == null || root.right == null) {
        return (root.left == null)? smallestFromLeafHelper(root.right,suffix):
                                    smallestFromLeafHelper(root.left,suffix); 
    }
       //DFS here , keep going to the left
        String left = smallestFromLeafHelper(root.left,suffix);
        String right = smallestFromLeafHelper(root.right,suffix);

    
   return left.compareTo(right) <= 0?left:right;

 }    
} 

// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//Note: A leaf is a node with no children.
 //Input Tree [5,4,8,11,null,13,4,7,2,null,null,5,1]
 // Sum :22
 //Output : [[5,4,11,2],[5,8,4,5]]

    public List<List<Integer>> pathSum(Node root, int sum) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> current =  new ArrayList<Integer>();
        pathSumHelper(root,sum,current,output);
        return output;
    }    

    public void pathSumHelper(Node root, int sum,List<Integer> current,List<List<Integer>> output) {
      if(root == null) return;
      sum = sum - root.data;
       current.add(root.data);
      if(root.left == null && root.right == null && sum == 0) {
          output.add(new ArrayList(current));
      } else {
          pathSumHelper(root.left,sum,current,output);
          pathSumHelper(root.right,sum,current,output);
      }
 //removes the current element only i.e, if there are 5 elements in ArrayList, 
  //it will remove the 5th element only
      current.remove(current.size()-1); 
    } 
  
  
/**
 Given a binary tree, prints out all of its root-to-leaf
 paths, one per line. Uses a recursive helper to do the work.
*/
    public List<String> binaryTreePaths(Node root) {
        List<String> output = new ArrayList<String>();
        StringBuffer current = new StringBuffer();
        binaryTreePathsHelper(root,current,output);
        return output;
    }
    
    void binaryTreePathsHelper(Node root,StringBuffer current,List<String> output) {
        if(root == null) return;
        int length = current.length();//we will have to delete the current element after recursion
        //so make sure to take the length of the string
        current.append(root.data);        
        if(root.left == null && root.right == null) {

            output.add(new String(current.toString()));
        } else {
            current.append("->");
            binaryTreePathsHelper(root.left,current,output);
            binaryTreePathsHelper(root.right,current,output);
        }
        //current.setLength(length);//use this line or below line
        current.delete(length,current.length());
    }    

  //===================================================================
  //Alternative approach below.
  //===================================================================
public void printPaths(Node node) {
  int[] path = new int[1000];
  printPaths(node, path, 0);
}

/**
 Recursive printPaths helper -- given a node, and an array containing
 the path from the root node up to but not including this node,
 prints out all the root-leaf paths.
*/
  
  
/**
 Utility that prints ints from an array on one line.
*/
private void printArray(int[] ints, int len) {
  int i;
  for (i=0; i<len; i++) {
   System.out.print(ints[i] + " ");
  }
  System.out.println();
}
  
private void printPaths(Node node, int[] path, int pathLen) {
  
  if(node == null) {
    return;
  }
  path[pathLen] = node.data;
  pathLen++;
  
  if(node.left == null && node.right == null) {
    printArray(path,pathLen);
  }
  
  printPaths(node.left,path,pathLen);
  printPaths(node.right,path,pathLen);
} 
  
  public static void main(String[] args) {
   Solution S = new Solution();
   S.head = S.CreateBST(null,12);
   S.CreateBST(S.head,14);
   S.CreateBST(S.head,6);
   S.CreateBST(S.head,4);
   S.CreateBST(S.head,8);
   S.CreateBST(S.head,9);
   S.CreateBST(S.head,10);
   S.CreateBST(S.head,13);
   S.CreateBST(S.head,7);   
    
   //Level Order Traversal
    System.out.println("Level Order Traversal");
    S.LevelOrderTraversal(S.head);
    
    //LookUp
    boolean output1 = S.LookUp(S.head,20);
    System.out.println("LookUp 40 " + output1);
    boolean output2 = S.LookUp(S.head,9);
    System.out.println("LookUp 9 " + output2);
    
    //sizeof
    System.out.println("The total number of nodes are " + S.Size(S.head));
    
    //maxDepth
    System.out.println("Max Depth is " + S.maxDepth(S.head));
    
    //minValue
    System.out.println("Minimum Value is " + S.minValue(S.head));
    
    //SortedOputput
    System.out.println("Sorted Output is ");
    S.sortedOutput(S.head);
    
    //hasPathSum
    System.out.println("hasPathSum :" + S.hasPathSum(S.head,39));
    System.out.println("hasPathSum :" + S.hasPathSum(S.head,22));
    System.out.println("hasPathSum :" + S.hasPathSum(S.head,45));
    System.out.println("hasPathSum :" + S.hasPathSum(S.head,46));
    
    //mirror
    S.mirror(S.head);
    System.out.println("Mirror Level Order Traversal");
    S.LevelOrderTraversal(S.head);
    System.out.println("Reverse Mirror Level Order Traversal");
    S.mirror(S.head);
    S.LevelOrderTraversal(S.head);
    
    //double Tree
    //S.duplicate(S.head);
    //System.out.println("Duplicate a tree");
    //S.LevelOrderTraversal(S.head);
    //System.out.println("Sorted Output is ");
    //S.sortedOutput(S.head);
    
    //sameTree
   System.out.println("is it same tree? :" + S.sameTree(S.head,S.head));
   Solution S1 = new Solution();
   S1.head = S1.CreateBST(null,12);
   S1.CreateBST(S1.head,14);
   S1.CreateBST(S1.head,6);
   S1.CreateBST(S1.head,4);
   S1.CreateBST(S1.head,8);
   S1.CreateBST(S1.head,9);
   System.out.println("is it same tree? :" + S.sameTree(S.head,S1.head));
    
   //isBST
   System.out.println("is this a BST tree? :" + S.isBST(S.head)); 
    //mirror it so that structure of BST changes , and hence it will not be a BST
   S.mirror(S.head); 
   System.out.println("is this a BST tree? :" + S.isBST(S.head));  
   S.mirror(S.head);
   Solution S2 = new Solution();
   S2.head = S2.CreateBST(null,12);
   S2.CreateBST(S2.head,14);
   S2.CreateBST(S2.head,6);
   //S2.mirror(S2.head); 
   System.out.println("is this a BST tree? :" + S2.isBST(S2.head));   
 
   
   //printPaths
   System.out.println("printPaths");
   S.printPaths(S.head); 
   
   //Diameter of a tree
   S.CreateBST(S.head,3);
   S.CreateBST(S.head,2);
   S.CreateBST(S.head,1);
   int diameter = S.diameter(S.head);
   System.out.println("the diameter is " + diameter);
   S.LevelOrderTraversal(S.head);

   }
}
