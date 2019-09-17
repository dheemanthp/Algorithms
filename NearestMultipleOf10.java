public class NearestMultipleOf10 {
    
    // example : number is 4722
    static int round(int num) {
        
        if (num < 0 ){
            return -1;
        }
    
        int lower_limit = (num /10) * 10;//4720
        int upper_limit = lower_limit + 10; //4730
    
        return (((num -lower_limit) < (upper_limit-num))?lower_limit:upper_limit);
    }    

    public static void main(String[] args) {
        
        int num1 =  4722; //output expected is 4720
        //made the round() funtion static, hence directly accessing herre
        System.out.println(round(num1));
        num1 =  4728; //output expected is 4730
        System.out.println(round(num1));
        num1 =  4725; //output expected is 4730
        System.out.println(round(num1));
        
    }
}