
public class Solution {

//O(n) with extra space of a string builder
    private static String getWordWrap(String s, int k) {
    	String[] sArr = s.split(" ");
    	StringBuilder sb = new StringBuilder();
    	int cnt = 0;
    	for(int i=0;i<sArr.length;i++) {
    		cnt += sArr[i].length() + 1;
    		System.out.println("count: " + cnt);
    		if(cnt > k+1) {
    			if(sb.length() > 0) {
    			    			System.out.println("Delete: " + sb.toString());
    				sb.deleteCharAt(sb.length() - 1);
    			}
    			System.out.println("output: " + sb.toString());
    			return sb.toString();
    		}
    		sb.append(sArr[i] + " ");
    		System.out.println(sb.toString());
    	}
    	return s;
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
