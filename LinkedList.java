
public class LinkedList {
    Node head;//head
    static class Node {
        int data;
        Node next; // next
    
    public Node(int d) {
          data = d;
          next = null;
        }
    }
    
   //Add a node    
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
    
    //print a node
    void print(Node nd) {
    Node temp = head;
     while(temp != null){
         System.out.println("data is: " + temp.data);
         temp = temp.next;
     }
    }
    
    //Driver Program    
    public static void main(String[] args) {
        LinkedList ld = new LinkedList();
        ld.head = new Node(1);
        ld.add(new Node(2));
        ld.add(new Node(3));
        //print
        ld.print(ld.head);
        return;  
    }
}
