import java.util.ArrayList;

/**
 * CMSC 203 CRN 47229
 * Assignment 5
 * Dr. Grinberg
 * @author RonyStephan
 * Description: This class serves as a customer order, which can store several beverages of varying types.
 */

public class Order implements OrderInterface, Comparable {
	private int orderNumber;
	private int orderTime;
	private DAY day;
	private Customer cust;
	private ArrayList<Beverage> bevList;
	
	/**
	 * parametrized constructor for order object
	 * @param orderTime the time of day that order is placed
	 * @param d enum day that order is placed
	 * @param c customer of the order
	 */
	public Order(int orderTime, DAY d, Customer c) {
		this.orderTime=orderTime;
		this.orderNumber=generateRandom();
		this.day=d;
		cust = new Customer(c);
		bevList = new ArrayList<Beverage>();
	}

	
	@Override
	public boolean isWeekend() {
		if(day.equals(DAY.SATURDAY) || day.equals(DAY.SUNDAY)){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		if(bevList.isEmpty()) {
			return null;
		}
		else {
			return(bevList.get(itemNo));
		}
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(bevName, size, extraShot, extraSyrup);
		bevList.add(c);

	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		boolean isWeekend=isWeekend();
		Alcohol a = new Alcohol(bevName, size, isWeekend);
		bevList.add(a);

	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie s = new Smoothie(bevName, size, numOfFruits, addPRotien);
		bevList.add(s);

	}

	@Override
	public double calcOrderTotal() {
		double total=0;
		for(Beverage b : bevList) {
			total+=b.calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		int counter=0;
		for(Beverage b: bevList) {
			if(b.getType().equals(type)) {
				counter++;
			}
		}
		return counter;
	}
	@Override
	public String toString() {
		String str = "Order number: " + this.orderNumber 
				+" | Order time: " + this.orderTime 
				+" | Customer name: " + cust.getName()
				+" | Customer age: " + cust.getAge()
				+"\n--------------------------\nORDER LIST\n--------------------------\n";
		for(int i=0; i<bevList.size(); i++) {
			if(i!=0) {
				str+="\n\n";
				str+=bevList.get(i).toString();
				
			}
			else {
				
				str+=bevList.get(i).toString();
				
			}
		}
		str+="\n--------------------------\n";
		str+="Order total: " + calcOrderTotal();
		str+="\n\n";
		return str;
	}
	/**
	 * Getter method for order item count
	 * @return number of items on order
	 */
	public int getTotalItems() {
		return bevList.size();
	}
	
	/**
	 * getter method for order number(randomly generated)
	 * @return order number
	 */
	public int getOrderNo() {
		return orderNumber;
	}

	/**
	 * setter number for order number
	 * @param i order number to be set
	 */
	public void setOrderNo(int i) {
		this.orderNumber=i;
	}

	/**
	 * getter method for order time
	 * @return time that order was placed
	 */
	public int getOrderTime() {
		return orderTime;
	}
	
	/**
	 * setter method for order time
	 * @param t time that the order was placed
	 */
	public void setOrderTime(int t) {
		this.orderTime=t;
	}

	/**
	 * getter method for order day
	 * @return enum day that order was placed
	 */
	public DAY getOrderDay() {
		return day;
	}
	
	/**
	 * setter method for order day
	 * @param d enum day that the order was placed
	 */
	public void setDay(DAY d) {
		this.day=d;
	}
	
	/**
	 * getter method for the current customer
	 * @return deep copy of the current customer
	 */
	public Customer getCustomer() {
		return new Customer(this.cust);
	}
	
	/**
	 * setter method for the current customer
	 * @param c customer to be copied
	 */
	public void setCustomer(Customer c) {
		this.cust = new Customer(c);
	}

	/**
	 * A method to generate a order number within the range of 10000 and 90000
	 * @return number between 10000 and 90000
	 */

	public int generateRandom() {
		int min=10000;
		int max=90000;
		return min + (int)(Math.random() * ((max - min) + 1));
	}

	@Override
	public int compareTo(Object o) {
		Order order = (Order)o;
		if(this.getOrderNo()>order.getOrderNo()) {
			return 1;
		}
		else if(this.getOrderNo()<order.getOrderNo()) {
			return -1;
		}
		else {
			return 0;
		}
	}


}
