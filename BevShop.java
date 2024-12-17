/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class represents the BevShop and within this class you can make orders.
 * Due: 12/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nicholas Kim
*/
import java.util.ArrayList;

public class BevShop implements BevShopInterface{

	private int numAlcDrinks;
	private ArrayList<Order> orders;
	private Order currentOrder;
	
	public BevShop() {
		
		this.numAlcDrinks = 0;
		this.orders = new ArrayList<>();
		
	}
	
	@Override
	public boolean isValidTime(int time) {
		
		if(time >= 8 && time <= 23) {
			
			return true;
			
		}
		return false;
	}

	@Override
	public int getMaxNumOfFruits() {
		
		return MAX_FRUIT;
		
	}

	@Override
	public int getMinAgeForAlcohol() {
		
		return MIN_AGE_FOR_ALCOHOL;
		
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		
		if(numOfFruits > MAX_FRUIT) {
			
			return true;
			
		}
		
		return false;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		
		return MAX_ORDER_FOR_ALCOHOL;
		
	}

	@Override
	public boolean isEligibleForMore() {
		
		if(numAlcDrinks < MAX_ORDER_FOR_ALCOHOL) {
			
			return true;
			
		}
		
		return false;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		
		return numAlcDrinks;
		
	}

	@Override
	public boolean isValidAge(int age) {
		
		if(age >= MIN_AGE_FOR_ALCOHOL) {
			
			return true;
			
		}
		return false;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		
		currentOrder = new Order(time, day, new Customer(customerName, customerAge));
		orders.add(currentOrder);
		numAlcDrinks = 0;
		
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		
		currentOrder.addNewBeverage(bevName, size);
		numAlcDrinks++;
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
		
	}

	@Override
	public int findOrder(int orderNo) {
		
		for(int i = 0; i < orders.size(); i++) {
			
			if(orders.get(i).getOrderNo() == orderNo) {
				
				return i;
				
			}
			
		}
		
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		
		int index = findOrder(orderNo);
		
		if(index == -1){
			
			return 0;
			
		}
		
		return orders.get(index).calcOrderTotal();
		
	}

	@Override
	public double totalMonthlySale() {
		
		double total = 0;
		
		for(Order order: orders) {
			
			total += order.calcOrderTotal();
			
		}
		
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		
		return orders.size();
		
	}

	@Override
	public Order getCurrentOrder() {
		
		if(currentOrder == null) {
			
			return null;
			
		}
		
		return currentOrder;
		
	}

	@Override
	public Order getOrderAtIndex(int index) {
		
		if(index >= orders.size() || index < 0) {
			
			return null;
			
		}
		
		return orders.get(index);
	}

	@Override
	public void sortOrders() {
		
		for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).compareTo(orders.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Order temp = orders.get(i);
                orders.set(i, orders.get(minIndex));
                orders.set(minIndex, temp);
            }
        }
		
	}

	public String toString() {
		
		String allOrders = "";
		
		for(Order order: orders) {
			
			allOrders += order.toString() + "\n";
			
		}
		
		return "Orders:\n" + allOrders + "Total Monthly Sale: $" + totalMonthlySale();
		
	}
	
}
