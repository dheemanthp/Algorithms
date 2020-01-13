// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
//time complexity : we have to go over all the rows and seats , hence O(rows * seats)
//space complexity : we have to store all the rows and seats , hence O(rows* seats)
//logic:
//store the rows, and seats in a Map
//marked the reserved seats in the map
//check for the combination of BC,DE,FG,HJ based on the constraints in the problem

    public int solution(int N, String S) {
        //base case
        if(N < 1|| N > 50) {
             return N;
        }
         //base case    
         if(S == null || S.length() == 0) {
             //just return N*2
             //reason being maximum 4 families per row is 2 , hence N *2
             return N*2; 
         }
        //aeroplane contains (key,value) ---> (Row, List of seats)
        Map<Integer, List<Integer>> aeroplane = new HashMap<>();
        //Empty string Array
        String[] splitStringArray = null;
        //Init aeroplane with zero's
        for (int currRow = 1; currRow <= N; currRow++) {
        //ArrayList of 10 members in every row
            List<Integer> row = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
           	    row.add(0);
            }
            //add every row as a value in the HashMap
            aeroplane.put(currRow, row);	
        }
        //Mark the reserved seats in the aeroplane
        if (S.trim().length() > 0) {
            splitStringArray = S.split(" ");
            int reservedRow;
            String reservedSeat;
            for (int j = 0; j < splitStringArray.length; j++) {
        	String code = splitStringArray[j];
        	    //5A
                if(code.length() == 2) {
                    reservedSeat = code.substring(1);//A
                    reservedRow = Integer.parseInt(code.substring(0, 1));//5
                //35B
                 } else {
                    reservedSeat = code.substring(2);//B
                    reservedRow = Integer.parseInt(code.substring(0, 2));//35
                 }
                  //marking reserved seats
                  switch (reservedSeat) {
                       case "A":aeroplane.get(reservedRow).set(0,1);break;
                       case "B":aeroplane.get(reservedRow).set(1,1);break;
                       case "C":aeroplane.get(reservedRow).set(2,1);break;
                       case "D":aeroplane.get(reservedRow).set(3,1);break;
                       case "E":aeroplane.get(reservedRow).set(4,1);break;
                       case "F":aeroplane.get(reservedRow).set(5,1);break;
                       case "G":aeroplane.get(reservedRow).set(6,1);break;
                       case "H":aeroplane.get(reservedRow).set(7,1);break;
                       case "J":aeroplane.get(reservedRow).set(8,1);break;
                       case "K":aeroplane.get(reservedRow).set(9,1);break;
                       default:break;
                  }//end of switch
            }//end of for loop
        }//end of if
        //Seat combination
        boolean seatBC = false;boolean seatDE = false;
        boolean seatFG = false;boolean seatHJ = false;
        int family = 0;
        for (int currRow = 1; currRow <= N; currRow++) {
            List<Integer> checkRow = aeroplane.get(currRow);
                //Ignore seat A , and check seat BC
                if(checkRow.get(1) != 1 && checkRow.get(2) != 1) {
                    seatBC = true;
                }
                //check seat DE
                if(checkRow.get(3) != 1 && checkRow.get(4) != 1) {
                    seatDE = true;
                }
                //check seat FG
                if(checkRow.get(5) != 1 && checkRow.get(6) != 1) {
                    seatFG = true;
                }
                //Ignore seat K, check seat HJ
                if(checkRow.get(7) != 1 && checkRow.get(8) != 1) {
                    seatHJ = true;
                }
                //BC and DE are set
                if((seatBC && seatDE)){
                    family++;
                    //we only need to check for FG and HJ
                    if((seatFG && seatHJ)){
                        family++;
                    }
                //check for other combinations    
                } else {
                    //DE and FG are set
                    if((seatDE && seatFG)){
                        family++;
                    //check for other combinations
                    } else {
                        //FG and HJ are set
                        if((seatFG && seatHJ)){
                            family++;
                        }
                    }    
                }
                //Reset
                seatBC = false;seatDE = false;
                seatFG = false;seatHJ = false;
        }
    //return the total number of families
    return family;
    }
 public static void main(String[] args) {
     Solution_AirplanSeatAllocation s = new Solution_AirplanSeatAllocation();
     System.out.println(s.solution(2, "1A 2F 1C"));
     System.out.println(s.solution(4, "1A 2F 1C 4A 3D 4C 3C 2G 4K"));
     System.out.println(s.solution(5, "1A 2F 1C 4A 3D 4C 3C 2G 4K"));
     System.out.println(s.solution(50, "1A 3C 2B 40G 5A"));
     System.out.println(s.solution(30, ""));
     System.out.println(s.solution(0, "3B"));
 /*
(1, "1A 1B 1C 1D 1E 1F 1G 1H 1J 1K")
(2, "1A 2F 1C")
(32, "1A 2F 1C 4B 10C 16E 14D")
(48, "1A 2F 1C 4B 10C 16E 14D")
(68, "1A 2F 1C 4B 10C 16E 14D")
(30, "")
(0, "3B")
(60,"4B")
(-1,"2B")



*/
     
 }
}
