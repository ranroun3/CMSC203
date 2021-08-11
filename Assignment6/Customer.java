import java.util.ArrayList;

/**
 * CMSC 203 CRN 47229
 * Assignment 5
 * Dr. Grinberg
 * @author RonyStephan
 * Description: This class serves as a customer who can place an order of several drink objects.
 */

public class Customer {
	
	private int age;
	private String name;
	
	/**
	 * parametrized constructor 
	 * @param name name of customer
	 * @param age age of customer
	 */
	public Customer(String name, int age) {
		this.age=age;
		this.name=name;
	}
	
	/**
	 * copy constructor
	 * @param c customer object to be copied
	 */
	public Customer(Customer c) {
		this.name=c.name;
		this.age=c.age;
	}
	
	@Override
	public String toString() {
		return "Customer name: " + this.name +", Age: "
				+  this.age;
	}
	/**
	 * setter method for customer name
	 * @param s name to be set
	 */
	public void setName(String s) {
		this.name=s;
	}
	
	/**
	 * setter method for customer age
	 * @param i age of customer
	 */
	public void setAge(int i) {
		this.age=i;
	}
	
	/**
	 * getter method for customer name
	 * @return name of customer
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * getter method for customer age
	 * @return age of customer
	 */
	public int getAge() {
		return age;
	}
}
