import java.util.ArrayList;
import java.util.Collections;

/**
 * CMSC 203 CRN 47229
 * Assignment 5
 * Dr. Grinberg
 * @author RonyStephan
 * Description: This class serves as a beverage shop, which can hold several orders,each with several beverages.
 */
public class BevShop implements BevShopInterfce{
	private int numOfAlcoholicDrinks;
	private ArrayList<Order> orderList;
	private int currentOrderIndex;

	public BevShop() {
		orderList= new ArrayList<Order>();
		numOfAlcoholicDrinks=0;
	}
	@Override
	public boolean validTime(int time) {
		if(time>=MIN_TIME && time<=MAX_TIME) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean eligibleForMore() {
		if(numOfAlcoholicDrinks<MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean validAge(int age) {
		if(age>MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		if(validTime(time)) {
			Order o = new Order(time, day, new Customer(customerName, customerAge));
			orderList.add(o);
			currentOrderIndex=orderList.indexOf(o);
			numOfAlcoholicDrinks=0;


		}
		else {
			System.out.println("Sorry, Shop is currently closed!");
		}
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orderList.get(currentOrderIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);

	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		if(eligibleForMore()) {
			orderList.get(currentOrderIndex).addNewBeverage(bevName, size);
			numOfAlcoholicDrinks++;
		}
		else {
			System.out.println("Not eligible for alcohol!");
		}
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		orderList.get(currentOrderIndex).addNewBeverage(bevName, size,  numOfFruits, addProtien);

	}

	@Override
	public int findOrder(int orderNo) {
		int orderFound=-1;
		for(int i=0; i<orderList.size(); i++) {
			if(orderList.get(i).getOrderNo()==orderNo) {
				orderFound=i;
			}
		}
		return orderFound;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		double orderTotal=0;
		if(findOrder(orderNo) !=-1) {
			orderTotal= orderList.get(findOrder(orderNo)).calcOrderTotal();
		}
		else {
			orderTotal=0;
		}
		return orderTotal;
	}

	@Override
	public double totalMonthlySale() {
		double total=0;
		for(Order o: orderList) {
			total+=o.calcOrderTotal();
		}
		return total;
	}

	@Override
	public void sortOrders() {
		int orderLength=orderList.size();
		for(int i=0; i<orderLength-1; i++) {
			int min_index=i;
			for(int j=i+1; j<orderLength; j++) {
				if(orderList.get(j).getOrderNo()<orderList.get(i).getOrderNo()) {
					min_index=j;
				}
			}
			Collections.swap(orderList, i, min_index);
		}

	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orderList.get(index);

	}
	
	/**
	 * getter method for the current order
	 * @return order object at the current index
	 */
	public Order getCurrentOrder() {
		return getOrderAtIndex(currentOrderIndex);
	}
	
	/**
	 * getter method for the current amount of alcoholic drinks on the order
	 * @return number of alcoholic drinks
	 */
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholicDrinks;
	}
	
	@Override
	public String toString() {
		String str= "Welcome to the Bradley Beverage Shop!\n";
		for(Order o:orderList) {
			str+="\n\nNEW ORDER \n--------------------------\n";
			str+=o.toString();

		}
		str+="\n************************\nTOTAL MONTHLY SALES\n************************\n";
		str+=totalMonthlySale();
		str+="\n\nThank you for using the Bradley Beverage Shop, goodbye!";
		return str;
	}
	
	/**
	 * method determine if the smoothie object has reached the maximum amount of fruits
	 * @param num number of fruits in the current smoothie
	 * @return boolean whether or not the smoothie has reached the limit
	 */
	public boolean isMaxFruit(int num) {
		if (num > MAX_FRUIT) {
			return true;
		}
		return false;
	}
	
	/**
	 * getter method for the final of the maximum amount of alcoholic drinks
	 * @return the maximum amount of alcoholic drinks
	 */
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	/**
	 * getter method for the final of the minimum age allowed to purchase alcohol
	 * @return the minimum age to purchase alcohol
	 */
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	/**
	 * getter method for the total amount of monthly orders
	 * @return the amount of monthly orders
	 */
	public int totalNumOfMonthlyOrders() {
		return orderList.size();
	}

}
