//https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        //use a HashMap to track the count
        HashMap<Integer,Integer> H = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length ; i++) {
            
            if(H.containsKey(nums[i])) {
                H.put(nums[i],H.get(nums[i]) + 1);                
                
            }else {
                H.put(nums[i],1);
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        //MIN HEAP
        PriorityQueue<Map.Entry<Integer,Integer>> PQ = new PriorityQueue<>(
                                                        (a,b) -> a.getValue() -b.getValue()
                                                        );
        
        for(Map.Entry<Integer,Integer> entry : H.entrySet()) {
            PQ.offer(entry);
            if(PQ.size() > k){
                PQ.poll();
            }
        }
        
        while(!PQ.isEmpty()){
            result.add(0,PQ.poll().getKey());
            
        }
    return  result;       
        
    }
}
