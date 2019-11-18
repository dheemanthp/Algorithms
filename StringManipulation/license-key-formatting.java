https://leetcode.com/problems/license-key-formatting/

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        
        
        //break the string into parts
        //String[] strArray = S.split("-");
        StringBuilder SB = new StringBuilder();
        int counter = 0;
        
        for(int i = S.length()-1; i >= 0 ; i--) {
            if(S.charAt(i) != '-') {
                SB.append(S.charAt(i));
                counter++;
                if(counter%K  == 0 && i!= 0){
                    SB.append("-");
                    counter = 0;
                }
                
            }
        }
        
        String output = SB.reverse().toString().toUpperCase();
        if(output.length() > 0) {
        return (output.charAt(0) == '-'?output.substring(1, output.length()):output);
        } else{
            return output;
        }

    }
}
    
    

    
class AlternativeSolution {
    public String licenseKeyFormatting(String S, int K) {
        
        
        //break the string into parts
        String[] strArray = S.split("-");
        StringBuilder SB = new StringBuilder();
        int counter = 0;
        
        for(int i = strArray.length-1; i >= 0 ; i--) {
            for(int j = strArray[i].length()-1; j >= 0  ; j--) {
                SB.append(strArray[i].charAt(j));
                counter++;
                System.out.println("the SB String is " + SB.toString());
                if(counter%K  == 0){
                    System.out.println("Append -  here as Length is " +SB.length());
                    
                    SB.append("-");
                    counter = 0;
                }
            }
            
        }
        String output = SB.reverse().toString().toUpperCase();
        return (output.charAt(0) == '-'?output.substring(1, output.length()):output);
    }
}
