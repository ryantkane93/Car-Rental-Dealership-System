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

public class Client
{
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String telephone;
    private String birthDate;
    private double amountOwed;

    Client() //Default Constructor
    {
        this("John", "Doe", "1 Main Street", "Alexandria", "New York", 11763, "631-654-6732", "01/01/1990", 0.00); //Call parameterized constructor
    }
    public Client(String lastName, String firstName, String address, String city, String state, int zipCode, String telephone, String birthDate, double amountOwed) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.amountOwed = amountOwed;
        
    }

    public double getAmountOwed() {
        
        return amountOwed;
    }

    public String amountOwedString()
    {
        return String.format("$%.2f",amountOwed);
    }
    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

   @Override
   public String toString()
   {
       return String.format("Name: %s %s%nAddress: %s, %s, %s %d%nTelephone number: %s%nDOB: %s", 
               getFirstName(), getLastName(), getAddress(), getCity(), getState(), getZipCode(), getTelephone(), getBirthDate());

   }
}