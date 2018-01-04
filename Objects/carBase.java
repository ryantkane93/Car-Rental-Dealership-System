/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Ryan
 */
public class carBase  //extends carObject
{
	//private variables
	private String make;
	private String model;
	private String year;
	private String color;
	private String vin;
	private double price;
	private int cylinders;
	private String type;
        private Date dueDate;
        private Date returnDate;
        private Date pickupDate;
        private Client currentOwner;
        
	// protected variables
	protected double dailyRate;
        protected double dailyBusinessRate;
	protected boolean available;
	
        
	carBase() //Default constructor
	{
            this("Ford", "Fiesta", "2014", "White", "VI12345", 4, 0.00, "Compact", true, 0.00);
            //Call the parameterized constructor in the default constructor to instantiate a new object.
	}
        //Parameterized constructor
	carBase(String Make, String Model, String Year, String Color, String Vin, int Cylinders, double Price, String Type, boolean Available, double DailyRate)
	{
		make = Make;
		model = Model;
		year = Year;
		color = Color;
		vin = Vin;
		cylinders = Cylinders;
		price = Price;
		type = Type;
		dailyRate = 0.00;
		available = Available;		
                dailyRate = DailyRate;
                dueDate = new Date();
                returnDate = new Date(0,0,0);
                pickupDate = new Date();
                currentOwner = new Client();
	}

    
   
    public Client getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(Client currentOwner) {
        this.currentOwner = currentOwner;
    }

    public double getDailyBusinessRate() {
        return dailyBusinessRate;
    }
      
    public Date getDueDate() {
        return dueDate;
    }
    
     public String stringDueDate() {
        String temp=dueDate.toString();
        return temp.substring(0,10);
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
        String temp=returnDate.toString();
        return temp.substring(0,10);
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getPickupDate() {
        String temp=pickupDate.toString();
        return temp.substring(0,10);
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }
        
        
	public void setMake(final String Make)
	{
		make = Make;
	}
	public void setModel(final String Model)
	{
		model = Model;
	}
	public void setYear(final String Year)
	{
		year = Year;
	}
	public void setColor(final String Color)
	{
		color = Color;
	}
	public void setVin(final String Vin)
	{
		vin = Vin;
	}
	public void setCylinder(final int CylinderCount)
	{
		cylinders = CylinderCount;
	}
	public void setPrice(final double Price)
	{
		price = Price;
	}
	public void setType(final String Type)
	{
		type = Type;
	}
	public String getModel()
	{
		return model;
	}
	public String getMake()
	{
		return make;
	}
	public String getYear()
	{
		return year;
	}
	public String getColor()
	{
		return color;
	}
	public String getVin()
	{
		return vin;
	}
	public int getCylinder()
	{
		return cylinders;
	}
	public double getPrice()
	{
		return price;
	}
	public String getType()
	{
		return type;
	}

    public double getDailyRate() {
        return dailyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
                                                             
   @Override
   public String toString()                                              
   {                                                                     
      return String.format("Make: %s%nModel: %s%nYear: %s%nVIN: %s%nPrice: $%.2f%nCylinders: %d%nType: %s%n",
      getMake(), getModel(), getYear(),getVin(), getPrice(), getCylinder(), getType());                                 
   } 
 
//Start the comparator definition
public static Comparator<carBase> carBaseComparator  = new Comparator<carBase>() {
@Override
public int compare(carBase carBase1, carBase carBase2) {

String car1Vin = carBase1.getVin().toUpperCase();
String car2Vin = carBase2.getVin().toUpperCase();
//ascending order
return car1Vin.compareTo(car2Vin);
}
};
protected int compareTo(carBase carBase2) {
		return 0;
	}

//End comparator definition

carBase(carBase obj) //Copy constructor
{
    
   this.make = obj.make;
   this.model = obj.model;
   this.year = obj.year;
   this.color = obj.color;
   this.vin = obj.vin;
   this.cylinders = obj.cylinders;
   this.price = obj.price;
   this.type = obj.type;
   this.dailyRate = obj.dailyRate;
   this.dailyBusinessRate = obj.dailyBusinessRate;
   this.currentOwner = obj.currentOwner;
   this.available = obj.available;
   this.pickupDate = obj.pickupDate;
   this.returnDate = obj.returnDate;
   this.dueDate = obj.dueDate;
}

}
