/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

/**
 *
 * @author Ryan
 */
public class Small extends carBase {

    private int numDoors;
    private double trunkWidth;

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public double getTrunkWidth() {
        return trunkWidth;
    }

    public void setTrunkWidth(double trunkWidth) {
        this.trunkWidth = trunkWidth;
    }
    
    public Small() {
        super();
        numDoors = 2;
        trunkWidth = 22.0;
        dailyRate = 39.99;
        dailyBusinessRate = 29.99;
    }
    
    Small(Small s)
    {
         super(s);
         this.numDoors = s.numDoors;
         this.trunkWidth = s.trunkWidth;
    }
    
   @Override                                                             
   public String toString()                                              
   { 
      return String.format(super.toString() + "Number of doors: %d %nTrunk width: %.1f inches%n", getNumDoors(), getTrunkWidth());                                 
   } 
}