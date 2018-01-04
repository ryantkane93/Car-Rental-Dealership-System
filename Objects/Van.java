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
public class Van extends carBase {

    private String primaryUse;
    private String doorsOpen;
    
    public Van() 
    {
        super();
        primaryUse = "families";
        doorsOpen = "automatically";
        dailyRate = 169.99;
        dailyBusinessRate = 139.99;
    }

    public String getPrimaryUse() {
        return primaryUse;
    }

    public void setPrimaryUse(String primaryUse) {
        this.primaryUse = primaryUse;
    }

    public String getDoorsOpen() {
        return doorsOpen;
    }

    public void setDoorsOpen(String doorsOpen) {
        this.doorsOpen = doorsOpen;
    }
    
    Van (Van v)
    {
         super(v);
         this.doorsOpen = v.doorsOpen;
         this.primaryUse = v.primaryUse;
    }
    
   @Override                                                             
   public String toString()                                              
   { 
      return String.format(super.toString() + "Doors open %s%nPrimarily used for %s%n", getDoorsOpen(), getPrimaryUse());                                 
   } 
}
