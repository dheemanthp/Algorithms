
//https://leetcode.com/problems/top-k-frequent-words/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> H = new HashMap<>();
        List<String> result = new LinkedList<>();
        
        for(int j = 0 ;j < words.length ; j++) {
            if(H.containsKey(words[j])) {
                H.put(words[j],H.get(words[j]) +1);
            } else{
                H.put(words[j] ,1);
            }
        }
        //Use a MIN heap
        //The idea is to keep a count of each word in a HashMap and then insert in a Priority Queue.
        //While inserting in pq, if the count of two words is same then insert based on string compare of the keys.
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        
        //Entry set
        for(Map.Entry<String, Integer> entry: H.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            //add every element at the beginning
            result.add(0,pq.poll().getKey());
        
        return result;    
    }
}
