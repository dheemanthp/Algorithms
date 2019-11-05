
//https://leetcode.com/problems/is-graph-bipartite/submissions/
class Solution {
    
    //we can solve this problem using DFS or BFS
    //the main idea is , hold a vertex assign a color to it 
    // and all the vertex reachable from it should have a different color
    //if the reachable vertex do not have the same color then exit out
    public boolean isBipartite(int[][] graph) {
        
        //have a color array storing all the verticies
        int[] color = new int[graph.length]; //number of rows of graph
        Queue<Integer> Q = new LinkedList<>();
              
        for (int i=0 ; i < graph.length; i++) {
            
            if(color[i] == 0) {
                color[i] = 1; // 1 is blue and -1 is red
                System.out.println(" the Bipartite vertex " + i + " added color " + ((color[i] ==1)?"BLUE":"RED"));
            }
            //add the vetex to the queue
            Q.add(i);
            while(!Q.isEmpty()) {
                 int vertex = Q.remove();
    
                 for(int V : graph[vertex]) { //all the reachable veticies
                     System.out.println(" the Adjacent vertex (" + vertex + " " + V + ")");
                    if(color[V] == 0)  {
                        color[V] = -color[vertex];
                        System.out.println(" Added Color " +((color[V] ==1)?"BLUE":"RED")+ " and Adding " + V + " to the queue ");
                        Q.add(V);
                    } else{
                        if(color[V] == -color[vertex]) {
                            System.out.println(" Ignoring vertex " + V + " as it has the correct Color");
                        }
                        //Terminate if the codition does not satisfy
                        if(color[V] != -color[vertex]) return false;
                    }
                 }//end of for
             }//end of while
        }//end of for
        return true;
    }
}

/*
 the Bipartite vertex 0 added color BLUE
 the Adjacent vertex (0 1)
 Added Color RED and Adding 1 to the queue 
 the Adjacent vertex (0 3)
 Added Color RED and Adding 3 to the queue 
 the Adjacent vertex (1 0)
 Ignoring vertex 0 as it has the correct Color
 the Adjacent vertex (1 2)
 Added Color BLUE and Adding 2 to the queue 
 the Adjacent vertex (3 0)
 Ignoring vertex 0 as it has the correct Color
 the Adjacent vertex (3 2)
 Ignoring vertex 2 as it has the correct Color
 the Adjacent vertex (2 1)
 Ignoring vertex 1 as it has the correct Color
 the Adjacent vertex (2 3)
 Ignoring vertex 3 as it has the correct Color
 the Adjacent vertex (1 0)
 Ignoring vertex 0 as it has the correct Color
 the Adjacent vertex (1 2)
 Ignoring vertex 2 as it has the correct Color
 the Adjacent vertex (2 1)
 Ignoring vertex 1 as it has the correct Color
 the Adjacent vertex (2 3)
 Ignoring vertex 3 as it has the correct Color
 the Adjacent vertex (3 0)
 Ignoring vertex 0 as it has the correct Color
 the Adjacent vertex (3 2)
 Ignoring vertex 2 as it has the correct Color
*/
