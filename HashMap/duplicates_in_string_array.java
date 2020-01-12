import java.util.*;

public class Leet442 {
  
    public static void main(String args[]) { 
        String[] str = { "dheem","bheem","dheem", "kleem", "mleem", "chleem" , "kleem"};
        HashMap<String,Integer> H = new HashMap<>();
        for(int i = 0; i< str.length; i++) {
            H.put(str[i],H.getOrDefault(str[i],0)+1);
            
            /*
            Elimiate boiler plate code
            if(H.containsKey(str[i])){
                H.put(str[i],H.get(str[i]) + 1);
            } else{
                H.put(str[i],1);
            }*/
        }
        
        for(String key : H.keySet()) {
            if(H.get(key) > 1) {
                System.out.println(key + " is a duplicate");
            }
        }
    } 
} 
