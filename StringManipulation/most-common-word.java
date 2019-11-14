https://leetcode.com/problems/most-common-word/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        //put all the banned words in a set
        Set<String> S = new HashSet<>();
        for(String str : banned) {
            S.add(str);            
        }
        //clean all the words in paragraph and add it to stringbuilder
        String ans = "";
        int ansfreq = 0;
        StringBuilder SB = new StringBuilder();
        HashMap<String, Integer> count = new HashMap<>();        
        for(char c : paragraph.toCharArray()) {
            if(Character.isLetter(c)) {
                SB.append(Character.toLowerCase(c));
                System.out.println("append here");
            } else if(SB.length() > 0) {
                String finalword = SB.toString();
                //a word is present in SB
                //check if the word is presnt in banned list
                if(!S.contains(finalword)) {
                    count.put(finalword,count.getOrDefault(finalword,0)+1);
                    if(count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
            SB = new StringBuilder();
            }//end elseif
        }//end for loop
        if(ans == "") return SB.toString();
        else return ans;
    }
}
