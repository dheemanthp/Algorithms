
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

/*n: the number of nodes.
m: the number of edges (assume no duplicated edges)
time: O(n+m), preprocess map takes n+m and later used another n to do count and dfs.
space: O(n^2) for the adjacency list, since the worst case is every node connected to all other nodes, which means n nodes,  and each has an n-1 neighbours.
Building adjacency List 
visited list
*/

class Solution {
    public int countComponents(int n, int[][] edges) {
        if (edges == null) return 0;
        if (edges.length == 0) return n;
        //visited
        boolean[] visited = new boolean[n];
          //adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
          //create the adjacency list
        for(int i = 0; i < n ; i++) {
            adj.add(i,new ArrayList<Integer>());
        }
        //update the adjacency list        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]); // changes only the first inner list
            adj.get(edge[1]).add(edge[0]); // changes only the first inner list
        }
         //do a DFS
        int count  = 0;
        for(int j = 0; j < n ; j++) {
            if(!visited[j]) {
                dfs(j, adj, visited);
                //System.out.println("====we have finished one undirected graph=====");        
                count++;
            }
        }
        return count;
    }
    //DFS
    void dfs(int j,ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[j] = true;
        //System.out.println("adjacency of " + j + " =" + adj.get(j));
        for(int k: adj.get(j)){
            if(!visited[k]) {
                //System.out.println("we have not visited " + k + " let us go inside");
                dfs(k, adj, visited);
            }
        }
        return;
    }
}

