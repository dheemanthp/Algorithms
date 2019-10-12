class Main {

//Time Complexity : O(n)
  static int  nonRepeatingCharInString(String str) {
  int NO_OF_CHARS = 256; 
  if(str == null ) {
     return 0;
  }  
  int length = str.length();
  if(length == 1) {
    return 0;
  }
  int[] count = new int[NO_OF_CHARS];
  //int the count to -1
  for(int i =0 ; i< NO_OF_CHARS ; i++) {
    count[i] = -1;
  }
  for (int i = 0 ; i < length; i++) {
    if(count[str.charAt(i)] == -1) {
        count[str.charAt(i)] = i;
    } else {
        count[str.charAt(i)] = -2;
    }
  }
  //loop through array ,ignore negative values and 
  //also store the minimum index value
  int result = Integer.MAX_VALUE;
  for(int i =0 ; i< NO_OF_CHARS ; i++) {
    if(count[i] != -1 && count[i] != -2) {
    result = Math.min(count[i],result);    
    }
   
  }
  return result;
  }


  public static void main(String[] args) {
    System.out.println(nonRepeatingCharInString("GeeksForGeeks"));
    System.out.println(nonRepeatingCharInString("GeeksFor"));
  }
}
