
public class Solution {

//O(n) with extra space of a string builder
    private static String getWordWrap(String s, int k) {
       //split all words
    	String[] sArr = s.split(" ");
        //string builder
    	StringBuilder sb = new StringBuilder();
    	int cnt = 0;
        //check every every word 
    	for(int i=0;i<sArr.length;i++) {
                //count the length of the string + 1 space
    		cnt += sArr[i].length() + 1;
    		System.out.println("count: " + cnt);
                //if count is greater than k+1
    		if(cnt > k+1) {
    			if(sb.length() > 0) {
    			        // Adding a new word will exceed the required length , hence do not add any new words,
    			        //just trim the space at the end of the already built word, and return
    			    	System.out.println("Delete: " + sb.toString() + ":at location" + (sb.length() - 1));
    				    sb.deleteCharAt(sb.length() - 1);
    			}
    			System.out.println("output: " + sb.toString());
    			return sb.toString();
    		}
                //otherwise append the new string to the string builder
    		sb.append(sArr[i] + " ");
    		System.out.println(sb.toString());
    	}
        //just return sb in this case
    	return sb.toString();
    }

    public static void main(String[] args) {
    	String s1 = "Codility We test coders"; int k1 = 14;
    	String s2 = "The quick brown fox jumps over the lazy dog"; int k2 = 39;
    	String s3 = "Why not"; int k3 = 39;
    	String s4 = "Codility We test coders"; int k4 = 2;
    	System.out.println(getWordWrap(s1, k1));
    	System.out.println(getWordWrap(s2, k2));
    	System.out.println(getWordWrap(s3, k3));
    	System.out.println(getWordWrap(s4, k4));
    }
}
