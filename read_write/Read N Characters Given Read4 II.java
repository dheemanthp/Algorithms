//https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/


/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    
    
    
    char[] buff = new char[4];
    int readCount = 0; // helps to understand if there are more items in buff , that has to be copied into buf , before we can call read4 again
    int totalcount = 0; // total count of characters read by read4 function.
    
    public int read(char[] buf, int n) {
        int ptr = 0;
        //System.out.println(" Coming inside the function Read count is "+ readCount);
        while (ptr < n) {
            //buf is the destination
            
            if(readCount == 0) {
                totalcount = read4(buff);
            }
            //System.out.println ("the totalcount is " + totalcount + " and the value of n is " + n);
            
            while((ptr < n) && (readCount < totalcount)) {
                
                buf[ptr++] = buff[readCount++];
                //System.out.println(" Writing here: Read count is "+ readCount);
            }
            if(readCount == totalcount) {
                readCount = 0;
            }
            // read4 returns less than 4, end of file
        if (totalcount < 4) break;
            
        }
        return ptr;
    }
}








/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
//public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
/*    
This is a great solution! I just noticed two things to make it more intuitive.

shift breaking condition to the end, "if (buffCnt < 4) break;"
instead of "if (buffPtr >= buffCnt)", simply "if (buffPtr == buffCnt)"
code slightly modified as below:
*/
    /*
private int buffPtr = 0;
private int buffCnt = 0;
private char[] buff = new char[4];
//read function has two inputs 
    
public int read(char[] buf, int n) {
    
    int ptr = 0;
    //loop until we reach n chracters
    while (ptr < n) {
        //number of characters read
        if (buffPtr == 0) {
            buffCnt = read4(buff);
        }
        
        while (ptr < n && buffPtr < buffCnt) {
            buf[ptr++] = buff[buffPtr++];
        }
        //reset the buffptr
        // all chars in buff used up, set pointer to 0
        if (buffPtr == buffCnt) buffPtr = 0;
        // read4 returns less than 4, end of file
        if (buffCnt < 4) break;
    }
    return ptr;
}

}




*/
