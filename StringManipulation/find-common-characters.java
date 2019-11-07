//https://leetcode.com/problems/find-common-characters/
//https://leetcode.com/problems/find-common-characters/discuss/422732/Java-HASHMAP-CLEAN-SOLUTION

class Solution {
    
//Example of 3 simple strings
// Input strings : CCCO LO LO
// Main HashMap called "H" will contains the total numbers of characters and their total count
//C -> 3
//L -> 2
//O -> 3
 
 //Minimum Hashmap called "MIN" will contains Hashmap of every string
//C -> 3
//O -> 1
// here compare both H and MIN hashmaps and update H to contain the minimum C-3,L-0,O-1 

//MIN will contains Hashmap of every string
//L -> 1
//O -> 1
// here compare both H and MIN hashmaps and update H to contain the minimum C-0,L-0,O-1 

//MIN will contains Hashmap of every string
//L -> 1
//O -> 1
// here compare both H and MIN hashmaps and update H to contain the minimum C-0,L-0,O-1 





public List<String> commonChars(String[] A) {
    
    //Hashmap to store all the characters and their count
    HashMap<Character,Integer> H = new HashMap<>();
    List<String> L = new ArrayList<>();
    
    for(String str : A) {
        for(int i = 0 ; i < str.length(); i++){
            //total count of all the characters
            if(H.containsKey(str.charAt(i))) {
                H.put(str.charAt(i),H.get(str.charAt(i))+1);    
            } else{
                H.put(str.charAt(i),1);    
            }
        }
    }
    
    //for every string update the hashmap H with minimum
    for(String str : A) {
        // HashMap to store count of characters in a given string
        HashMap<Character,Integer> MIN = new HashMap<>();
        for(int i = 0 ; i < str.length(); i++){
            if(MIN.containsKey(str.charAt(i))) {
                MIN.put(str.charAt(i),MIN.get(str.charAt(i))+1);    
            } else{
                MIN.put(str.charAt(i),1);    
            }
        }
        //Now compare H and MIN Hashmap , and ensure to store Minimum in H
        for(Character C : H.keySet()){
            if(MIN.containsKey(C)){
                H.put(C,Math.min(H.get(C),MIN.get(C)));
            } else{
                H.put(C,0);
            }
        }
    }
    //Given that H has the final count of characters , put it in a list           
    for(Character C : H.keySet()) {
        for(int j =1 ; j <=H.get(C);j++){
            L.add(String.valueOf(C));
        }
    }
    return L;
}

}
