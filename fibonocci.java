
// 0, 1, 1, 2, 3, 5, 8....
//Iterative
void fib(int input){
  int first = 0, second = 1;
  for(int i=0; i< input; i++){
    System.out.println(" " + first );
    int temp = first;
    first = second;
    second = temp + first;        
  }
}

//Recursive
void fibRecursion(int input){
  int first = 0,second  =1;
  
  for(int i = 0 ; i< input; i++) {
  System.out.print("  " + fibhelper(i));  
  }
}
int fibhelper(int input){ 
  if(input == 0 || input == 1) return 1;
  else {
    return fibhelper(input-1) + fibhelper(input-2);
  }
} 


//RUN:
//sol.fibRecursion(10);
//OUTPUT:
// 1  1  2  3  5  8  13  21  34  55
