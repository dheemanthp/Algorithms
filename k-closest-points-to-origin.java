https://leetcode.com/problems/k-closest-points-to-origin/

//BEST SOLUTION IS USING MAX HEAP
//SECOND BEST SOLUTION IS USING TREE MAP , but it cannot store duplicates , hence 

/*II. The second solution is based on the first one. We don't have to sort all points.
Instead, we can maintain a max-heap with size K. 
Then for each point, we add it to the heap. Once the size of the heap is greater than K, 
we are supposed to extract one from the max heap to ensure the size of the heap is always K. 
Thus, the max heap is always maintain top K smallest elements from the first one to crruent one. 
Once the size of the heap is over its maximum capacity, it will exclude the maximum element in it, 
since it can not be the proper candidate anymore.

Theoretically, the time complexity is O(NlogK), but pratically, the real time it takes on leetcode is 134ms.

The advantage of this solution is it can deal with real-time(online) stream data.
It does not have to know the size of the data previously.
The disadvatage of this solution is it is not the most efficient solution.*/


//Then tried to use Priority Queue to maintain a max heap with size K
import java.util.Comparator; 
class Solution {
    
      // A custom comparator that compares two Strings by their length.
        Comparator<int[]> tuppleDistanceComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                System.out.println(p1[0] + " " + p1[1] + "compare to " + p2[0] + " " + p2[1]);
                return (p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
            }
        };
    
    public int[][] kClosest(int[][] points, int K) {
        
        //Custom comparator
        //PriorityQueue<int[]> pq = new PriorityQueue<int[]>(tuppleDistanceComparator);
        
        //The above Comparator can also be created using lambda expression like this
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> 
        p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);

        for (int i = 0; i < points.length; i++) {
            //passing address
            System.out.println("offer");
            pq.offer(points[i]);
            if (pq.size() > K) {
                System.out.println("remove");
                pq.poll();
            }
        }
        //store result here
        int[][] res = new int[K][2];
        while (K > 0) {
            K--;
            System.out.println(" the top K elements are " + pq.peek()[0] + " "+ pq.peek()[1]);
            res[K] = pq.poll();
        }
        return res;
    }
}






//==========================================================================================================
//import java.util.TreeMap; 
//import java.util.Comparator; 
//Firstly, I came up with a solution using treemap(sorted map) but fails when distances are same
//It does not allow duplicates
class SolutionSample {
    public int[][] kClosest(int[][] points, int K) {
        //Treemap is needed to store the distance as key , and co-ordinates as value
        //TreeMap<Double, Integer[]> tm = new TreeMap<Double, Integer[]>(new TreeCompare()); 
        TreeMap<Double, Integer> tm = new TreeMap<Double, Integer>(); 
        for (int i = 0 ; i< points.length; i++) {
            int[] tupple = new int[2];
            tupple[0] = points[i][0];//X
            tupple[1] = points[i][1];//Y

            
            Double distance =  Math.sqrt(Math.pow(0-tupple[0],2) + 
                                     Math.pow(0-tupple[1],2));
            System.out.println("the distance is "+distance + "i value is " + i);
            tm.put(distance,i); 
        }
        int j =0;
       int[][] kClosest = new int[K][2];
        // Get first k values (map is sorted)
		for (Map.Entry<Double, Integer> entry : tm.entrySet()) {
			if (j<K) {
                System.out.println("the key value is "+ entry.getKey());
				kClosest[j][0] = points[entry.getValue()][0];
				kClosest[j][1] = points[entry.getValue()][1];
				j++;
			}else{
				break;
			}
		}
		return kClosest;
        
    }
}
