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
public class Mid extends carBase {

    private boolean hasMoonRoof;
    private String trunkType;
    
    public Mid() {
        super(); //Call the carBase constructor.
        hasMoonRoof = false;
        trunkType = "Hatchback";
    }

    public boolean isHasMoonRoof() {
        return hasMoonRoof;
    }

    public void setHasMoonRoof(boolean hasMoonRoof) {
        this.hasMoonRoof = hasMoonRoof;
    }

    public String getTrunkType() {
        return trunkType;
    }

    public void setTrunkType(String trunkType) {
        this.trunkType = trunkType;
    }
    
    
    
    Mid(Mid m)
  {
     super(m);
     this.hasMoonRoof = m.hasMoonRoof;
     this.trunkType = m.trunkType;
     dailyRate = 49.99;
     dailyBusinessRate = 44.99;
  }
    

   @Override                                                             
   public String toString()                                              
   { 
      return String.format(super.toString() + "Has moon roof: %s%nTrunk type: %s%n", isHasMoonRoof(), getTrunkType());                                 
   }                                 
   
}
