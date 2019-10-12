

class Main {

  static int convertString(String str) {
    int result = 0; int i = 0;
    char[] C = str.toCharArray();
    int sign;
    if(C[0] == '-') {
    sign = -1;i =1;
    } else {
    sign = +1;  
    } 
    for(; i < str.length(); i ++) {


     result = result * 10 + str.charAt(i) - '0';

      //123
      //1
      //10 + 2
      //12 *10 +3 

    }
   return (result*sign);
  }



  public static void main(String[] args) {
    System.out.println("Hello world!");

    String str = "-123";
    int val = Integer.parseInt(str);

    System.out.println(convertString(str));

  }
}
