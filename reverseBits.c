uint32_t reverseBits(uint32_t n) {
    if(n == 0) return 0;
 uint32_t rev = 0; 
      
    // traversing bits of 'n' from the right 
    unsigned int count = sizeof(n) * 8; //count is 32
    while (n > 0) 
    { 
        // bitwise left shift  
        // 'rev' by 1 
        rev <<= 1; 
          
        // if current bit is '1' 
        if (n & 1 == 1) {//check if bit is set on LSB
            rev ^= 1; //set it
        }
          
        // bitwise right shift  
        // 'n' by 1 
        n >>= 1; 
        count--;      
    } 
      
    // required number 
    rev <<= count; 
    return rev; 
}
/*
uint32_t reverseBitss(uint32_t num) {
    
 unsigned int count = sizeof(num) * 8 - 1; 
    unsigned int reverse_num = num; 
    printf("%d\n",num);  
    num = num >> 1; 
    printf("%d\n",num);
    while(num) 
    { 
       
       reverse_num = reverse_num << 1;        
       printf("%d\n",reverse_num); 
       reverse_num |= reverse_num | (num & 1); 
       printf("%d\n",reverse_num);  
       num = num >> 1;
       printf("num---- %d\n",num);  
       count--; 
    } 
    reverse_num <<= count; 
    return reverse_num; 
}

    uint32_t reverseBitss(uint32_t n) {
        n = (n >> 16) | (n << 16);
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
        return n;
    }*/
