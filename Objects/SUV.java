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
public class SUV extends carBase {

    private double height;
    private double rimSize;
    
    
    public SUV() 
    {
        super();
        height = 7.0;
        rimSize = 18.0;
        dailyRate = 159.99;
        dailyBusinessRate = 149.99;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRimSize() {
        return rimSize;
    }

    public void setRimSize(double rimSize) {
        this.rimSize = rimSize;
    }
    
    SUV(SUV s) //Copy constructor that creates a deep copy.
  {
     super(s);
     this.height = s.height;
     this.rimSize = s.rimSize;
  }
    
   @Override                                                             
   public String toString()                                              
   { 
      return String.format(super.toString() + "Vehicle height: %.1f feet%nRim diameter: %.1f inches%n", getHeight(), getRimSize());                                 
   }                                 
   
      
}
