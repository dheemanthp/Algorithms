
//https://leetcode.com/problems/clone-graph/


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

public class Solution {
    //MainIdea : create a Hashmap of Value , and the corresponding newly created node
    public HashMap<Integer, Node> map = new HashMap<>();
    //call a helper function for recursion
    public Node cloneGraph(Node node) {
        return clone(node);
    }
    //this is a recursive function
    public Node clone(Node node) {
        //when node is null return
        if (node == null) return null;
        //TERMINATOR CONDITION TO AVOID CYCLES
        //if the map contains the value , then return newly created node
        if (map.containsKey(node.val)) 
            return map.get(node.val);
        //create a new node , and an empty array list
        Node newNode = new Node(node.val, new ArrayList<Node>());
        //put the new node value , and the newly created node
        map.put(newNode.val, newNode);
        //for each of the neighbours , add each of neighbours to the new neighbour's list
        //but ensure to call the recursive function
        for (Node neighbor : node.neighbors) 
            newNode.neighbors.add(clone(neighbor));
        //return the new node
        return newNode;
    }
}

class SolutionPractice {
    
    HashMap<Integer,Node> H = new HashMap<>();
    public Node cloneGraph(Node node) {
        //for recursion
        return helper(node);
    }
    Node helper(Node node) {
        if(node == null) return null;
        //terminator condition
        if(H.containsKey(node.val)) {
            //return the already existing duplicate new node
            return H.get(node.val);
        }

        Node newNode = new Node(node.val,new ArrayList<>());
        H.put(node.val,newNode);
        for(Node n : node.neighbors){
            //add the neighbors to the new node's List
            newNode.neighbors.add(helper(n));
        }
        return newNode;
    }
}


