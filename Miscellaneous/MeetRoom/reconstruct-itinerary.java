
https://leetcode.com/problems/reconstruct-itinerary/

class Solution {
public List<String> findItinerary(List<List<String>> tickets) {
        
        //base case
        if (tickets == null || tickets.size() == 0) return null;
        
        //map containing a string as KEY , and priority queue to store the destination lexicographically
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        //take every list and parse them from LIST of LIST's
        for (List<String> ticket : tickets) {
            //put the Source in the hashmap as a KEY
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            //now add the Destination into the priority queue
            graph.get(ticket.get(0)).offer(ticket.get(1));  // Assumption : The edge is [from, to] format
        }
        //now create a List of Strings which is the output
        List<String> itinerary = new ArrayList<>();
        System.out.println("start here");
        //now start from JFK
        dfs(graph, "JFK", itinerary);
        
        //return the result
        System.out.println("end here");
        return itinerary;
        
    }
    //start DFS
    private void dfs(Map<String, PriorityQueue<String>> graph, 
                     String from, List<String> itinerary) {
        //get the value for Every KEY, first key will be JFK
        PriorityQueue<String> adjacents = graph.getOrDefault(from, new PriorityQueue<>());
        
        //until the priority queue is not empty keep recursing
        while (!adjacents.isEmpty()) 
            dfs(graph, adjacents.poll(), itinerary);
        
       // Inserts the specified element at the specified position in this list (optional operation).
        //add everything at the beginning 
        //Given that it goes to the bottom completely and then comes out to first 
        itinerary.add(0,from); // Once all adjacents are traversed, add the graph node into itinerary
    }
}
