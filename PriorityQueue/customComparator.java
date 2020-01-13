
class Solution {
    
    //Using Priority QUEUE
    //methods used are peek(), poll() , add()
    //for a MAX PQ only we will use custom comparator
    //for MIN PQ see this https://coderanch.com/t/608503/java/comparator-sort-priority-queue
    //by default PQ is MIN PQ
    
    
    class The_Comparator implements Comparator<Integer> { 
    public int compare(Integer int1, Integer int2) 
    { 
        /*
        if (int1 < int2) 
            return 1; 
        else if (int1 > int2) 
            return -1; 
        else
            return 0; 
        */ 
        return int2.compareTo(int1); 
    } 
} 
    
public int customComparator() {
    
        PriorityQueue<Integer> PQT = new PriorityQueue<>(new The_Comparator());
        PQT.add(50);
        PQT.add(30);
        PQT.add(10);
        PQT.add(40);
        PQT.add(80);
        PQT.add(60);
        PQT.add(70);
        System.out.println("size is " + PQT.size());
        int size = PQT.size();
        for(int i = 0; i < size; i++) {
            System.out.println("dheem " + i);
            System.out.println("the value in PQT is "+ PQT.poll());
        }
    }
}
