
public class Solution {
    //Running time
    //n* n!
    //Permutation  
    static void  permutation(String output, String input) {
    //Base case
    if(input.isEmpty()){
     System.out.println(output);   
    } else {
        for(int i = 0 ; i < input.length(); i++) {
            permutation(output + input.charAt(i), input.substring(0,i) + input.substring(i+1,input.length()));
        }
      }
    }
    //Combination
    //Enumerates all subsets of n elements using recursion.
    //0 to 2^N - 1
    static void combination(String prefix, String s) {
        System.out.println(prefix);
        for (int i = 0; i < s.length(); i++)
            combination(prefix + s.charAt(i), s.substring(i + 1));
    }  
        
    public static void main(String[] args) {
        String input = "123";
        String output = "";
        permutation(output, input);
        System.out.println("=====================");   
        combination(output ,input);
    }

//=====================
//Permutation
//=====================
//123
//132
//213
//231
//312
//321
//=====================
//Combination
//=====================
//1
//12
//123
//13
//2
//23
//3    

}
