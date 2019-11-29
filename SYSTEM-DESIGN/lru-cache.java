//https://leetcode.com/problems/lru-cache/
class LRUCache {
    
    final Node head = new Node(0, 0);
    final Node tail = new Node(0, 0);
    final Map<Integer, Node> map;
    final int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
      int res = -1;
      if(map.containsKey(key)){
        Node n = map.get(key);
        remove(n);
        insertToHead(n);
        res = n.value;
      }
      return res;   
    }
    
    public void put(int key, int value) {
      if(map.containsKey(key)){
        Node n = map.get(key);
        remove(n);
        n.value = value;
        insertToHead(n);
      } else {
        
        if(map.size() == capacity){
           map.remove(tail.prev.key); 
           remove(tail.prev);
        } 
        
        Node n = new Node(key, value);
        insertToHead(n);
        map.put(key, n);
      }  
    }
    
    private void remove(Node n){
      n.prev.next = n.next;
      n.next.prev = n.prev;
    }
    
    private void insertToHead(Node n){
      Node headNext = head.next;
      head.next = n;
      headNext.prev = n;
      n.prev = head;
      n.next = headNext;
    }
    
    class Node{
      Node prev, next;
      int key, value;
      Node(int k, int v){
        key = k;
        value = v;
      }
    }
}



//i explicitly unlinked it , which you dont need to
//also used dummy front and last nodes
class LRUCacheMySolution {
    private class Node {
        int key;
        int val;
        Node left;
        Node right;
        
        Node(int keyData, int data ,Node left , Node right) {
            key = keyData;
            val = data;
            left  = null;
            right = null;
        }
    }

    //default limit
    private int limit  = 5;
    //use a HashMap
    private HashMap<Integer,Node> H;
    //use a doubly Linked List
    private Node front = null;
    private Node last = null;

    public void LRUPrint(){
        Node temp =  front;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.right;
        }
        System.out.println();
    }
    public LRUCache(int capacity) {
        limit = capacity;
        H = new HashMap<>();
        
    }
    
    public int get(int key) {
        System.out.println("GET " + " key " + key);
        //if no key return -1
        if(!H.containsKey(key)) return -1;
        Node temp = H.get(key);
        //only one item in DLL
        if(temp.left == null && temp.right == null) {
            return temp.val;
        }

        //unlink the temp node
        if(temp.left != null && temp.right != null) {
            Node prev = temp.left;
            Node next = temp.right;
            prev.right = temp.right;
            next.left = temp.left;
            temp.left = null;
            temp.right = null;
            //add it to the last    
            last.right = temp;
            temp.left = last;
            last = temp;
        } else if (temp.left == null) { //first
                System.out.println("GET " + " key " + key + " unlink the first ");
                //unlink the node
                Node next = temp.right;
                next.left = null;
                //set the first
                front = next;
                //add it to the last    
                last.right = temp;
                temp.left = last;
                temp.right = null;
                last = temp;
        }else {//last
                //trying to access last hence we are good here
        }
        LRUPrint();
        return temp.val;
    }
    
    public void put(int key, int value) {
        System.out.println("PUT " + " key " + key + " value " + value);
        Node node = new Node(key,value,null,null);
        //check if there are no items in hashmap
        if(H.isEmpty()) {
            front = node;
            last = node;
            H.put(key,node);
        //check if the hashmap size is less than limit , add the value at the last
        } else if(H.size() < limit) {
            last.right =  node;
            node.left = last;
            node.right = null;
            last = node;
            H.put(key,node);
        //if limit is reached , then evict the first and add the value at the last
        } else {
            
            if(H.containsKey(key)) {
                System.out.println("key already present");
                Node temp = H.get(key);
                //unlink DLL
                Node prev = temp.left;
                Node next = temp.right;
                if(prev != null) prev.right = temp.right;
                if(next != null) next.left = temp.left;
                if(temp == front) {
                    front = front.right;
                }
                if(temp == last) {
                    last = last.left;
                }
                temp.left = null;
                temp.right = null;
                
                //put in the last
                last.right = node;
                node.left = last;
                last = node;
                //put key
                H.put(key,node);
            } else {
            
                System.out.println("limit reached" + "key " + key + " value " + value);
                //remove front
                Node temp = front.right;
                front.right = null;
                if(temp!= null) temp.left = null;
                //////remove key
                H.remove(front.key);
                front = temp;
                //put in the last
                last.right = node;
                node.left = last;
                last = node;
                //put key
                H.put(key,node);
            }
        }
        LRUPrint();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
