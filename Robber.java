class Robber {
//Check leetcode for full description
https://leetcode.com/problems/house-robber/
//The idea is simple
//you only need to keep track of the previous two maximums.
//Everything else can be thrown out
 //“For every house in the list, either add its gold to the max gold 2 indices back or
 //keep the max gold 1 index back.”
//Running time O(n)

  
    public int rob(int[] houses) {
      //base case
      if(houses.length == 0) {
       return 0; 
      }
      //only 1 house
      if(houses.length == 1) {
       return houses[0];
      }
      //two maximums
      int currentMax = 0;
      int prevMax = 0;

      for(int i = 0; i < houses.length; i++) {
        int currentHouseTreasure = houses[i];
        //check Max of current maximum and (Previous maximum + current value)
        int newMax = Math.max(currentMax, prevMax + currentHouseTreasure);
        prevMax = currentMax;
        currentMax = newMax;
      }

      return currentMax;
    } 
  
 public static void main(String[] args) {
  
  //Variety of Input Arrays
   Robber robber = new Robber();
   //int[] houses = {1,2,3,1};
   int[] houses = {1};
   System.out.println("the maximum loot is  " + robber.rob(houses));
  }
}
