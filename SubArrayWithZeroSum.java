import java.util.HashMap;

public class SubArrayWithZeroSum{
//works for all negative numbers
//If we consider all prefix sums, we can
//notice that there is a subarray with 0
//sum when :
//1) Either a prefix sum repeats or
//2) Or prefix sum becomes 0.

//Prefix sums for above array are:
//1, 5, 3, 1, 6, 2, 5

//Since prefix sum 1 repeats, we have a subarray
//with 0 sum. 

//the running time is O(n)
//the idea is simple
//keep adding every item as part of the sum 
//put the sum and index as part of a hash map
//exit criteria is
//1) if the sum becomes zero
//2) if the array element is zero
//3) if a prefix sum is previously found


boolean subArrayWithZeroSum(int arr[] , int size) {
    
    HashMap<Integer,Integer> subArrayMap = new HashMap<Integer,Integer>();
    int sum = 0;
    System.out.println("hid");    
    for(int i = 0;i<size;i++) {
        System.out.println("hid 1");
        sum = sum + arr[i];
        System.out.println("hid 2");
        if(arr[i] ==0 || sum == 0 || subArrayMap.get(sum) != null) {
            System.out.println("hid 3");
            return true;
        }
        
        subArrayMap.put(sum,i);
    }
    return false;
}

    public static void main(String []args){
        
    int arr[] = {-3, -1, 4, 1, 6};
    
    SubArrayWithZeroSum obj = new SubArrayWithZeroSum();
    boolean found = obj.subArrayWithZeroSum(arr,arr.length);
        if(found) {
            System.out.println("the sub array with sum zero is found");    
        } else {
            
            System.out.println("not found");    
        }
    }
}
