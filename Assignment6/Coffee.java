/**
 * CMSC 203 CRN 47229
 * Assignment 5
 * Dr. Grinberg
 * @author RonyStephan
 * Description: This class serves as a coffee beverage drink.
 */

public class Coffee extends Beverage{
	private boolean hasExtraShot;
	private boolean hasExtraSyrup;

	/**
	 * parametrized constructor for coffee beverage
	 * @param name name of coffee
	 * @param size enum size of coffee
	 * @param shot whether the coffee has an extra shot of espresso or not
	 * @param syrup whether the coffee has syrup in it
	 */
	public Coffee(String name, SIZE size, boolean shot, boolean syrup) {
		
		super(name, TYPE.COFFEE, size);
		this.hasExtraShot=shot;
		this.hasExtraSyrup=syrup;
	}
	@Override
	public String toString() { 
		String str = super.toString();
		str+= "\nExtra shot: " + hasExtraShot;
		str+=" | Extra syrup: " + hasExtraSyrup;
		str+=" | Price: " + this.calcPrice();
		return str;
	}
	@Override
	public double calcPrice() {
		double drinkPrice = getBasePrice();
		if(this.getSize()==SIZE.MEDIUM) {
			drinkPrice+=getSizeUpPrice();
		}
		else if(this.getSize()==SIZE.LARGE) {
			drinkPrice+=getSizeUpPrice();
			drinkPrice+=getSizeUpPrice();
		}
		if(this.hasExtraShot) {
			drinkPrice+=0.5;
		}
		if(this.hasExtraSyrup) {
			drinkPrice+=0.5;
		}
		return drinkPrice;
	}
	@Override
	public boolean equals(Object o) {
		Coffee c =(Coffee) o;
		if(super.equals(c)
				&& this.hasExtraShot==c.hasExtraShot 
				&& this.hasExtraSyrup ==c.hasExtraSyrup) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * setter method for the hasExtraShot boolean
	 * @param b whether the coffee has an extra shot
	 */
	public void setHasExtraShot(boolean b) {
		this.hasExtraShot=b;
	}
	
	/**
	 * setter method for the hasExtraSyrup boolean
	 * @param b whether or not the coffee has extra syrup
	 */
	public void setHasExtraSyrup(boolean b) {
		this.hasExtraSyrup=b;
	}
	
	/**
	 * getter method for the hasExtraShot boolean
	 * @return boolean whether drink has an extra shot
	 */
	public boolean getExtraShot() {
		return this.hasExtraShot;
	}
	
	/**
	 * getter method for the hasExtraSyrup boolean 
	 * @return boolean whether drink has extra syrup
	 */
	public boolean getExtraSyrup() {
		return this.hasExtraSyrup;
	}
}
