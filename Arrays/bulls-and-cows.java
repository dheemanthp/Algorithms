https://leetcode.com/problems/bulls-and-cows/

//Amazing solution
//put all the values in 2 arrays , one array will contain characters count for secret,
another array will contain characters count for guess

//Genius solution
class Solution {
    public String getHint(String secret, String guess) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        StringBuilder SB = new StringBuilder();
        int bull = 0;
        int cow = 0;
        
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bull++;
            else {
                a1[secret.charAt(i) - '0']++;//increment based on secret
                a2[guess.charAt(i) - '0']++;//increment based on guess
            }
        }
        
        for (int i = 0; i < 10; i++) {
            cow += Math.min(a1[i], a2[i]);//compare both and take minimum
        }
        
        return SB.append(bull + "A" + cow + "B").toString();
    }
}
