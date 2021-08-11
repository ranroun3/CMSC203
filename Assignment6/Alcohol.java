/**
 * CMSC 203 CRN 47229
 * Assignment 5
 * Dr. Grinberg
 * @author RonyStephan
 * Description: This serves as the class for an alcoholic beverage drink.
 */
public class Alcohol extends Beverage {
	
	private boolean onWeekend;
	
	/**
	 * parametrized constructor for alcohol
	 * @param name name of beverage
	 * @param size size of drink
	 * @param b is the beverage offered on weekends
	 */
	public Alcohol(String name, SIZE size, boolean b) {
		super(name, TYPE.ALCOHOL, size);
		this.onWeekend=b;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str+= "\nOffered on weekends: " + onWeekend;
		str+=" | Price: " + this.calcPrice();
		return str;
	}
	

	@Override
	public boolean equals(Object o) {
		Alcohol a = (Alcohol)o;
		if(super.equals(a)
				&& this.onWeekend==a.onWeekend) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * A method to calculate the price of the drink
	 * @return price of drink
	 */
	public double calcPrice() {
		double drinkPrice = getBasePrice();
		if(this.getSize()==SIZE.MEDIUM) {
			drinkPrice+=getSizeUpPrice();
		}
		else if(this.getSize()==SIZE.LARGE) {
			drinkPrice+=getSizeUpPrice();
			drinkPrice+=getSizeUpPrice();
		}
		
		if(onWeekend) {
			drinkPrice+=0.6;
		}
		return drinkPrice;
	}
	/**
	 * setter method for onWeekend boolean
	 * @param b boolean if offered on weekend
	 */
	public void setOnWeekend(boolean b) {
		this.onWeekend=b;
	}
	/**
	 * getter method for onWeekend boolean
	 * @return boolean for weekend offering
	 */
	public boolean getOnWeekend() {
		return onWeekend;
	}
}

