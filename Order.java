/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class represents the order of the customer. The customer is allowed to add different drinks to his/her order
 * Due: 12/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nicholas Kim
*/
import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order>{
	
	private int orderNumber;
	private int orderTime;
	private Day day;
	private Customer customer;
	private ArrayList<Beverage> beverages;
	
	
	public Order(int orderTime, Day day, Customer customer) {
		
		this.orderNumber = random();
		this.orderTime = orderTime;
		this.day = day;
		this.customer = customer;
		this.beverages = new ArrayList<>();
	
	}
	
	private int random() {
		
		return (int)(Math.random()*(90000 - 10000 + 1)) + 10000;
		
	}
	
	@Override
	public boolean isWeekend() {
		
		if(day == Day.SATURDAY || day == Day.SUNDAY) {
			
			return true;
			
		}
		
		return false;
	}
	@Override
	public Beverage getBeverage(int itemNo) {
		
		if(itemNo >= 0 && itemNo > beverages.size()) {
			
			return beverages.get(itemNo);
			
		}
		
		return null;
	}
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
		
	}
	@Override
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName, size, isWeekend()));
		
	}
	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	
	}
	@Override
	public double calcOrderTotal() {
		
		double total = 0;
		
		for(Beverage bev: beverages) {
			
			total += bev.calcPrice();
			
		}
		
		return 0;
	}
	@Override
	public int findNumOfBeveType(Type type) {
		
		int num = 0;
		
		for(Beverage bev: beverages) {
			
			if(type == bev.getType()) {
				
				num++;
				
			}
			
		}
		
		return 0;
	}
	
	public String toString() {
		
		String bevs = "";

		for(Beverage bev: beverages) {
			
			bevs += bev.toString() + "\n";
			
		}
		
		return "Order Number: " + orderNumber + "\nOrder Time: " + orderTime + "\nDay: " + day + "\nName: " + customer.getName() + "\nAge: " + customer.getAge() + "\nBeverages: \n" + bevs; 
		
	}

	@Override
	public int compareTo(Object obj) {
		
		Order order = (Order) obj;
		
		if(this.orderNumber > order.orderNumber) {
			
			return 1;
			
		}else if(this.orderNumber < order.orderNumber) {
			
			return -1;
			
		}
			
		return 0;
	}
	
	//setters
	public void setCustomer(Customer customer) {
		
		this.customer = customer;
		
	}
	
	public void setOrderNo(int orderNumber) {
		
		this.orderNumber = orderNumber;
		
	}
	
	public void setOrderTime(int orderTime) {
		
		this.orderTime = orderTime;
		
	}
	
	public void setDay(Day day) {
		
		this.day = day;
		
	}
	
	//getters
	public Customer getCustomer() {
		
		return new Customer(customer);
		
	}
	
	public int getOrderNo() {
		
		return orderNumber;
		
	}
	
	public int getTime() {
		
		return orderTime;
		
	}
	
	public Day getDay() {
		
		return day;
		
	}

}
