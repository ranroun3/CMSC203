import javafx.scene.layout.Region;
/**
 * CMSC 203
 * Gregory Grinberg
 * Montgomery College
 * Assignment 4
 * 7/19/2021
 * @author ronys
 *Description: this represents a management company, which has its own plot, and array of properties.
 */
public class ManagementCompany {
	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY=5;
	private final int MGMT_WIDTH=10;
	private final int MGMT_DEPTH=10;
	private Plot plot;
	 /**
     * A No-arg Constructor that creates a Management Company object.
     */
	public ManagementCompany() {
		this.name="";
		this.taxID="";
		this.mgmFeePer=0;
		this.plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}
	
    /**
     * A management company constructor with a default company plot.
     * @param name name of the company
     * @param taxID taxID of the property
     * @param mgmFeePer management fee
     */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		this.plot = new Plot(0,0,MGMT_WIDTH, MGMT_DEPTH);
		properties= new Property[MAX_PROPERTY];

	}
	 
	/**
     * A management company constructor that sets the plot for the company. 
     * @param name name to be returned
     * @param taxID taxID
     * @param mgmFeePer managementfee
     * @param x x-coordinate
     * @param y y-coorinate
     * @param width width of plot
     * @param depth depth of plot
     */
	public ManagementCompany(String name, String taxID, 
			double mgmFee, int x, int y, 
			int width, int depth) {
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		this.plot= new Plot(x,y,width, depth);
		properties= new Property[MAX_PROPERTY];
	}
	
	  /**
     * Copy constructor creates a ManagementCompany object using another ManagementComapany object.
     * @param otherCompany otherCompany is an object that is a copy 
     */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name=otherCompany.name;
		this.taxID=otherCompany.taxID;
		this.mgmFeePer=otherCompany.mgmFeePer;
		this.plot= new Plot(otherCompany.plot);
		properties= new Property[MAX_PROPERTY];
		if(!otherCompany.plot.equals(null)) {
			this.plot= new Plot(otherCompany.plot);
		}
		else {
			this.plot=new Plot();
		}
	}
	  
	/**
     * A get method that returns the size of properties array. 
     * @return MAX_PROPERTY size of the array. 
     */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	/**
	 * getter method for the plot
	 * @return
	 */
	public Plot getPlot() {
		return this.plot;
	}
	
	/**
	 * Getter method for the name field
	 * @return name field
	 */
	public String getName() {
		return this.name;
	}
	
	  /** 
     * Adds a an already created property to the array. 
     * @param property
     * @return -1 if array is full, -2 if property is null, 
     * -3 if it is not contained in managementco plot, -4 if it overlaps a preexisting plot,
     * or the index at which it was added
     */
	public int addProperty(Property prop) {
		if(prop == null) {
			return -2;
		}
		if (!plot.encompasses(prop.getPlot())) 
			return -3;
		for (int i = 0; i < properties.length; i++) {
			if(properties[i] != null) {
				if(properties[i].getPlot().overlaps(prop.getPlot())) {
					return -4;
				}
			}else {
				properties[i] = new Property(prop);
				return i;
			}
		}
		return -1;
}

	/**
     * A method that adds the property with four arguments and a default plot to the array.
     * @param name the name of property
     * @param city city of property
     * @param rent the amount of rent
     * @param owner the owner of the property
     * @return-1 if array is full, -2 if property is null, 
     * -3 if it is not contained in managementco plot, -4 if it overlaps a preexisting plot,
     * or the index at which it was added
     * 
     */
	public int addProperty(String name, String city,
			double rent, String owner) {
		Property prop = new Property(name, city, rent, owner);
		return addProperty(prop);
	}

	  /**
     * An add property that has all the parameters for the property and the plot. 
     * @param name name of owner
     * @param city city of property
     * @param rent rent amount
     * @param owner owner of property
     * @param x x-coordinate of property
     * @param y y-coordinate of property
     * @param width width of plot
     * @param depth depth of plot
     * @return -1 if array is full, -2 if property is null, 
     * -3 if it is not contained in managementco plot, -4 if it overlaps a preexisting plot,
     * or the index at which it was added
     */
	public int addProperty(String name, String city, double rent,
			String owner, int x, int y, int width,
			int depth) {
		Property prop = new Property(name, city, rent, owner,
				x, y, width, depth);
		return addProperty(prop);
	}

	/**
	 * A method that adds up the total rent from all properties.
	 * @return total rent amout
	 */
	public double totalRent() {
		double rentSum=0.0;
		for(Property p: properties) {
			if(p == null) {
				break;
			}
			rentSum += p.getRentAmount();
			/*if(!p.equals(null)) {
				rentSum+=p.getRentAmount();
			}*/
		}
		return rentSum;
	}
	
	/**
	 * A method that returns the maximum amount of rent from any single property.
	 * @return the max amount of rent
	 */
	public double maxRentProp() {
//		double max=0;
//		for(int i=0; i<properties.length; i++) {
//			if(!properties[i].equals(null)) {
//				if(properties[i].getRentAmount()>max) {
//					max=properties[i].getRentAmount();
//				}
//			}
//		}
		int i=maxRentPropertyIndex();
		double maxAmount;
		if(properties[i]!=null) {
			 maxAmount=properties[i].getRentAmount();
		}
		else {
			maxAmount=0.0;
		}
		return maxAmount;
	}
	
	/**
	 * A method that finds the index of the property with the highest rent.
	 * @return the index of the property with the highest rent
	 */
	private int maxRentPropertyIndex() {
		double max=0;
		int index=0;
		for(int i=0; i<properties.length; i++) {
			if(properties[i]==null) {
				break;
			}
			else {
				if(properties[i].getRentAmount()>max) {
					max=properties[i].getRentAmount();
					index=i;
				}
			}
		}
		return index;
	}
	
	/**
	 * A method that displays information about the property at a specified index
	 * @param i the index at which to search
	 * @return the String of the property at index i
	 */
	private String displayPropertyAtIndex(int i) {
		if(!properties[i].equals(null)) {
		return properties[i].toString();
	}
		else {
			Property prop = new Property();
			return prop.toString();
		}
	}
	
	/**
	 * A method that displays information about the property in a string format
	 * @return String a string with info of all properties
	 */
	public String toString() {
		//StringBuilder str = new StringBuilder("List of the properties for "+ name + ", taxID: " + taxID);
		int count=0;
		String str = "List of the properties for " + name  + ", taxID: " + taxID;
		str+="\n _____________________ \n";
		for(int i=0; i<properties.length; i++) {
			if(properties[i]==null) {
				break;
			}
			else if((properties[i])!=null) {
				str+=displayPropertyAtIndex(i);
				count++;
			}
		}
		str+="\n _____________________ \n";
		str+= "total management fee: " + mgmFeePer*count;
		return str;
	}
}
	