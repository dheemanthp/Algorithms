
https://leetcode.com/problems/min-stack/

class Node{
    long min;//used Long to avoid possible lossy conversion
    long data;//used Long to avoid possible lossy conversion
    Node link;
    
    Node(long dataVal, long minVal){
        this.min = minVal;
        this.data = dataVal;
        this.link = null;
    }
}

class MinStack {

    /** initialize your data structure here. */
    //Stack follow last in , first out
    // we can use a singly linked list
    Node head;
    Node tail;
    //H->T
    //H->(-2,-2)->T
    //H->(0,-2)->(-2,-2)->T
    //H->(-3,-3)->(0,-2)->(-2,-2)->T
    
    public MinStack() {
        head = new Node(Long.MAX_VALUE,Long.MAX_VALUE);//insert at the head and remove at the head 
        tail = new Node(Long.MAX_VALUE,Long.MAX_VALUE);
        head.link = tail;
    }
    
    public void push(int x) {
        Node newEntry  = new Node(x,Math.min(head.link.min,x));
        newEntry.link = head.link;
        head.link = newEntry;
        //System.out.println(" pushed new entry with data + " + newEntry.data + " min value " + newEntry.min);
    }
    
    public void pop() {
        head.link = head.link.link;
    }
    
    public int top() {
        return (int)head.link.data;
    }
    
    public int getMin() {
        return (int)head.link.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
