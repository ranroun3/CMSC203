/**
 * CMSC 203 CRN 47229
 * Assignment 5
 * Dr. Grinberg
 * @author RonyStephan
 * Description: This class serves as a beverage object for the drink shop
 */
public abstract class Beverage {
	private String name;
	private TYPE type;
	private SIZE size;

	private final double BASE_PRICE = 2.0;
	private final double SIZE_UP_PRICE =1.0;
	
	/**
	 * parametrized constructor for beverage 
	 * @param name name of beverage
	 * @param type type of beverage(ENUM)
	 * @param size size of beverage(ENUM)
	 */
	public Beverage(String name, TYPE type, SIZE size) {
		this.name=name;
		this.type=type;
		this.size=size;
	}
	
	/**
	 * method to calculate the price of beverage
	 * @return double price of beverage
	 */
	public abstract double calcPrice();
	
	@Override
	public String toString() {
		return "Drink Type: " + type + " | Drink Name: " + this.name + " | Size: " + this.size +"";
	}
	
	@Override
	public boolean equals(Object o) {
		Beverage b = (Beverage) o;
		if(this.size.equals(b.size) && this.name.equals(b.name) && this.type.equals(b.type)) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * getter method for beverage name
	 * @return beverage name string
	 */
	public String getBevName() {
		return this.name;
	}
	
	/**
	 * getter method for beverage type
	 * @return enum type of beverage;
	 */
	public TYPE getType() {
		return this.type;
	}
	
	/**
	 * getter method for beverage size
	 * @return enum size of beverage
	 */
	public SIZE getSize() {
		return this.size;
	}
	
	/**
	 * setter method for beverage name
	 * @param n name of beverage
	 */
	public void setName(String n) {
		this.name=n;
	}
	
	/**
	 * setter method for type of beverage
	 * @param t enum type of beverage 
	 */
	public void setType(TYPE t) {
		this.type=t;
	}
	
	/**
	 * setter method for size of beverage
	 * @param s enum size of beverage
	 */
	public void setSize(SIZE s) {
		this.size=s;
	}
	
	/**
	 * getter method for final base price of drink
	 * @return base price of drink
	 */
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	/**
	 * getter method for final size up price of drink
	 * @return size up price
	 */
	public double getSizeUpPrice() {
		return SIZE_UP_PRICE;
	}
	
}
