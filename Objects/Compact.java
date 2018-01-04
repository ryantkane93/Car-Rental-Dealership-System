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
public class Compact extends carBase{
    
    private int passangerSeats;
    private String startUp;
    
    //Inherit all of the carBase member variables and functions.
   public Compact()
    {
        super();
        passangerSeats = 3;
        startUp = "automatic";
        dailyRate = 29.99;
        dailyBusinessRate = 24.99;
    }

    public int getPassangerSeats() {
        return passangerSeats;
    }

    public void setPassangerSeats(int passangerSeats) {
        this.passangerSeats = passangerSeats;
    }


    public String getStartUp() {
        return startUp;
    }

    public void setStartUp(String startUp) {
        this.startUp = startUp;
    }
   
   
 @Override                                                             
   public String toString()                                              
   { 
      return String.format(super.toString() + "Number of passanger seats: %d%nStart-up method: %s%n", getPassangerSeats(), getStartUp());                                 
   } 

  Compact(Compact c) //Copy constructor that creates a deep copy of a compact object.
  {
     super(c);
     this.passangerSeats = c.passangerSeats;
     this. startUp = c.startUp;
     
  }
   
}    

