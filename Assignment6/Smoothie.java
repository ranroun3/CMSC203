/**
 * CMSC 203 CRN 47229
 * Assignment 5
 * Dr. Grinberg
 * @author RonyStephan
 * Description: This class serves as a smoothie beverage drink.
 */

public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean hasProteinPowder;
	/**
	 * parametrized constructor for smoothie beverage
	 * @param name name of beverage
	 * @param size enum size of beverage
	 * @param numOfFruits the number of fruits in the drink(MAX 5)
	 * @param hasExtraProtein whether the drink has protein powder or not
	 */
	public Smoothie(String name, SIZE size, int numOfFruits, boolean hasExtraProtein) {
		super(name, TYPE.SMOOTHIE, size);
		this.numOfFruits=numOfFruits;
		this.hasProteinPowder=hasExtraProtein;
	}
	@Override
	public String toString() {
		String str = super.toString();
		str+= "\nNumber of fruits: " + numOfFruits;
		str+=" | Extra protein: " + hasProteinPowder;
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
		if(numOfFruits>0) {
			drinkPrice+=(0.5*numOfFruits);
		}
		if(hasProteinPowder) {
			drinkPrice+=1.5;
		}
		return drinkPrice;
	}
	@Override
	public boolean equals(Object o) {
		Smoothie s = (Smoothie) o;
		if(super.equals(s)
				&& this.numOfFruits==s.numOfFruits
				&& this.hasProteinPowder ==s.hasProteinPowder) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * setter method for the number of fruits in drink
	 * @param fruits fruits in drink
	 */
	public void setNumOfFruits(int fruits) {
		this.numOfFruits=fruits;
	}
	
	/**
	 * setter method for the protein powder boolean
	 * @param b whether or not the drink has protein
	 */
	public void setHasProteinPowder(boolean b) {
		this.hasProteinPowder=b;
	}
	
	/**
	 * getter method for number of fruits
	 * @return number of fruits in drink
	 */
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	/**
	 * getter method for the protein boolean
	 * @return
	 */
	public boolean getAddProtien() {
		return hasProteinPowder;
	}
	

}
