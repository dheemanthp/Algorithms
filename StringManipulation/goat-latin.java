https://leetcode.com/problems/goat-latin/

class Solution {
    public String toGoatLatin(String S) {
        
        //use a string builder
        StringBuilder SB = new StringBuilder();
        //check every word
        String[] word = S.split(" ");
        for(int i = 0; i< word.length; i++) {
            char firstchar = word[i].toLowerCase().charAt(0);
            if(firstchar == 'a'||firstchar == 'e'||firstchar == 'i'|| firstchar == 'o'||firstchar == 'u') {
                SB.append(word[i]);
            } else {
                SB.append(word[i].substring(1));
                SB.append(word[i].substring(0,1));
            }
            SB.append("ma");
            int j = i+1;
            while(j!=0) {
                SB.append("a");
                j--;
            }
            SB.append(" ");
        }
        return SB.toString().trim();
    }
}
