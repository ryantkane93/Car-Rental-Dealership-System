/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.util.Date;

/**
 *
 * @author Ryan
 */
public class BusinessClient extends Client {
    
    //Inherit all of the Client member variables along with its setters and getters.
    
    private String company;
    private String companyPhone;

   public BusinessClient()
   {
       super();
       this.company = "Gentech";
       this.companyPhone = "718-675-4329";

   }
    public BusinessClient(String lastName, String firstName, String address, String city, String state, int zipCode, String telephone, String birthDate, double amountOwed,String company, String companyPhone) {
        super(lastName, firstName, address, city, state, zipCode, telephone, birthDate, amountOwed);
        this.company = company;
        this.companyPhone = companyPhone;
    }
    
    
}
