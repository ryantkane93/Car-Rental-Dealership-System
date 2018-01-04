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
public class Sport extends carBase {

    private double horsePower;
    private int numExhaust;
    
    public Sport() {
        super();
        horsePower = 320;
        numExhaust = 2;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public void setDailyBusinessRate(double dailyBusinessRate) {
        this.dailyBusinessRate = dailyBusinessRate;
    }

    
    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    public int getNumExhaust() {
        return numExhaust;
    }

    public void setNumExhaust(int numExhaust) {
        this.numExhaust = numExhaust;
    }
    
  Sport (Sport sp)
  {
     super(sp);
     this.horsePower = sp.horsePower;
     this.numExhaust = sp.numExhaust;
  }
   @Override                                                             
   public String toString()                                              
   { 
      return String.format(super.toString() + "Horse power: %.1f hp%nNumber of exhuast pipes: %d%n", getHorsePower(), getNumExhaust());                                 
   } 
  
 }
