/**
 * CMSC 203
 * Gregory Grinberg
 * Montgomery College
 * Assignment 4
 * 7/19/2021
 * @author ronys
 * Description: This represents a property, which contains its own plot object
 */
public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;

	/**
	 * No-arg constructor for the Property class that uses default values, and creates a default plot
	 */
	public Property(){
		city="";
		owner = "";
		propertyName="";
		rentAmount=0;
		this.plot = setPlot(0, 0, 1, 1);
	}
	
	/**
	 * Copy constructor of a specified property p
	 * @param p the plot to be copied
	 */
	public Property(Property p) {
		if(!p.equals(null)) {
			this.propertyName = p.propertyName;
			this.city = p.city;
			this.owner = p.owner;
			this.rentAmount = p.rentAmount;
			this.plot = new Plot(p.plot);
		}
		
		else {
			city="";
			owner = "";
			propertyName="";
			rentAmount=0;
			this.plot = setPlot(0, 0, 1, 1);
		}
	}
	
	/**
	 * A property class constructor with specified values, creating a default plot 
	 * @param propertyName name of property
	 * @param city city of property
	 * @param rentAmount amount of rent
	 * @param owner owner
	 */
	public Property(String propertyName, String city, 
			double rentAmount, String owner) {
		this.propertyName=propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner=owner;
		this.plot = setPlot(0, 0, 1, 1);
		//create default Plot where x,y are set to 0, width and depth set to 1
	}
	
	/**
	 * Parametrized property class constructor that passes plot values in to be created
	 * @param propertyName name of property
	 * @param city city name
	 * @param rentAmount rent 
	 * @param owner owner 
	 * @param x x-coordinate of plot
	 * @param y y-coordinate of plot
	 * @param width width of plot
	 * @param depth depth of plot
	 */
	public Property(String propertyName, String city,
			double rentAmount, String owner,
			int x, int y, int width, int depth) {
		this.propertyName=propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner=owner;
		this.plot = setPlot(x,y,width,depth);
	}
	
	/**
	 * Getter method for the property name
	 * @return property name
	 */
	public String getPropertyName() {
		return propertyName;
	}
	
	/**
	 * Setter method for the property name
	 * @param p the name to be set
	 */
	public void setPropertyName(String p) {
		propertyName=p;
	}
	
	/**
	 * getter method for the city field
	 * @return string of city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Setter method for the city field
	 * @param c the city to be inputted
	 */
	public void setCity(String c) {
		city=c;
	}
	
	/**
	 * Setter method for the plot object that creates a plot with the specified information and returns it
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param width width of object
	 * @param depth depth of object
	 * @return plot object created
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		return new Plot(x, y, width, depth);
	}
	
	/**
	 * A getter method for the plot object that verifies the object is not null before returning
	 * @return plot object
	 */
	public Plot getPlot() {
		if(!this.plot.equals(null)) {
			return this.plot;
		}
		else {
			return new Plot(0,0,1,1);
		}
	}
	
	/**
	 * a getter method for the rent amount
	 * @return rent amount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	
	/**
	 * a setter method for the rent amount
	 * @param d the rent amount to be set
	 */
	public void setRentAmount(double d) {
		rentAmount=d;
	}
	
	/**
	 * A getter method for the owner field
	 * @return string with owner
	 */
	public String getOwner() {
		return owner;
	}
	
	/**
	 * A setter method for the owner field
	 * @param o the owner to be set
	 */
	public void setOwner(String o) {
		owner=o;
	}
	
	/**
	 * A tostring method for the property object
	 * @return String 
	 */
	public String toString() {
		String str = "Property Name: " + propertyName +
				"\nLocated in: " + city +
				"\nBelonging to: " + owner + 
				"\nRent Amount: " + rentAmount;
		return str;
	}
}
