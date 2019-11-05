import java.io.*; 
import java.util.*; 

public class GraphDFS {
https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
//Code can traverse through unconnected or disconnected Graph's.
//For instance vertex 3 is disconnected from 0,1,2
//After visiting 3, it shall visit 0,1,2 as well
  
  
  private int V;//total number of Vertex
  private LinkedList<Integer>[] adj; //adjacency Matrix, array of lists
  
  
 //Constructor
  GraphDFS(int v) {
    V = v;
    
    adj = new LinkedList[v]; //Adjacency matrix , init List of arrays
    for(int i = 0; i< V ; i++ ) {
      adj [i] = new LinkedList<Integer>(); //Init each Linked List in the array
    }
  }
  
  //Add an Edge to the vertex
  void addEdge(int v , int e) {
   adj[v].add(e); 
  }
  
  //dfs Utility
  void dfsUtil(int v, boolean[] visited) {
    visited[v] = true;
    System.out.println("Traverse from vertex:"+ v + " ");
    //Iterator for the list
    Iterator<Integer> i = adj[v].listIterator();
    //Iterate throug the list
    while(i.hasNext()) {
     int n = i.next();
     System.out.println(v + " " + n);
      if(!visited[n]) {
        dfsUtil(n, visited) ;
      }
    }
  }
  
  
  
  
 //DFS
  void dfs(int v) {
    //array to mark if a vertex is visited or not visited
    //By default it is set to false;
    boolean[] visited = new boolean[V];
    //start from vetex v
    dfsUtil(v, visited);
    
    //But say we have disconnected graphs , then run a for loop for every vertex
    for (int i = 0 ;i < V; i++) {
      if(visited[i] == false) {
        dfsUtil(i, visited);
      }
    }
    
  }
  
  public static void main(String[] args) {
    
    GraphDFS g = new GraphDFS(4);
    //Below is a connected graph
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 1);
    //Below is an unconnected graphs
    g.addEdge(3, 3);//vertex 3 points to vertex 3 , hence a loop 
    
    //Start from Vertex 3
    g.dfs(2);
  }
  
}
