/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class is the Driver class which allows the user to order things from the BevShop and can see everything about their order.
 * Due: 12/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nicholas Kim
*/



import java.util.*;

public class BevShopDriverApp {

	public static void main(String[] args) {
		
		BevShop bevShop = new BevShop();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());
		
        boolean keepOrdering = true;
        
        while(keepOrdering) {
        	
        	System.out.println("Start please a new order:");
        	//used total monthly sale because I didn't understand how the order number worked since it was a random number that was generated
        	//I didn't want to change stuff from the other classes so I just kept it
        	System.out.println("Your Total Order for now is " + bevShop.totalMonthlySale());
            System.out.print("Would you please enter your name: ");
            String name = sc.nextLine();
            
            System.out.print("Would you please enter your age: ");
            int age = sc.nextInt();
            sc.nextLine(); 
            
            //checks to make sure customer is of valid age for alcohol
            if(bevShop.isValidAge(age)) {
            	
            	System.out.println("Your age is above 21 and you are eligible to order alcohol");
            	
            	
            }else {
            	
            	System.out.println("Your age is below 21 so you are uneligible to order alcohol");
            	
            }
            
            //checks to make sure the time is within the correct time period
            int time;
            do {
                System.out.print("Please enter the order time (between " + BevShopInterface.MIN_TIME + " and " + BevShopInterface.MAX_TIME + "): ");
                time = sc.nextInt();
                sc.nextLine(); 
                if(!bevShop.isValidTime(time)) {
                	
                	System.out.println("Invalid Time. Please Enter Again.");
                
                }
  
            } while (!bevShop.isValidTime(time));
            
            
            //Checks to make sure a valid day is entered
            int day;
            do {
            	System.out.println("What is the day? (Monday = 1, Tuesday = 2, ... , Sunday = 7) ");
            	day = sc.nextInt();
            	sc.nextLine();
            	if(day < 1 || day > 7) {
            		
            		System.out.println("Invalid number. Please Enter a number between 1-7.");
            		
            	}
            }while(day < 1 || day > 7);
            
            Day dayOfWeek = null;
            
            if (day == 1) {
                dayOfWeek = Day.MONDAY;
            } 
            else if (day == 2) {
            	dayOfWeek = Day.TUESDAY;
            } 
            else if (day == 3) {
            	dayOfWeek = Day.WEDNESDAY;
            } 
            else if (day == 4) {
            	dayOfWeek = Day.THURSDAY;
            } 
            else if (day == 5) {
            	dayOfWeek = Day.FRIDAY;
            } 
            else if (day == 6) {
                dayOfWeek = Day.SATURDAY;
            } 
            else if (day == 7) {
            	dayOfWeek = Day.SUNDAY;
            }
            
            bevShop.startNewOrder(time, dayOfWeek, name, age);
            boolean addBev = true;
            
            //Keeps running until addbev is false
            while (addBev) {
                System.out.println("Would you like to add a drink to your order? (y/n)");
                String addDrinkResponse = sc.nextLine();
                if (!addDrinkResponse.equals("y")) {
                    break;
                }

                System.out.println("Choose a drink type: 1. Alcohol 2. Coffee 3. Smoothie");
                int drinkType = sc.nextInt();
                sc.nextLine(); 
                
                //adds whatever drink they chose to the menu
                if (drinkType == 1) {
                    if (!bevShop.isValidAge(age)) {
                        System.out.println("Your age is below 21 so you are uneligible to order alcohol!");
                    } 
                    else if (!bevShop.isEligibleForMore()) {
                        System.out.println("You have reached the maximum alcohol drinks for this order.");
                    } 
                    else {
                        System.out.print("Enter the name of the alcohol drink: ");
                        String alcoholName = sc.nextLine();
                        System.out.print("Choose a size (SMALL, MEDIUM, LARGE): ");
                        Size alcoholSize = Size.valueOf(sc.nextLine().toUpperCase());
                        bevShop.processAlcoholOrder(alcoholName, alcoholSize);
                    }
                } 
                else if (drinkType == 2) {
                    System.out.print("Enter the name of the coffee: ");
                    String coffeeName = sc.nextLine();
                    System.out.print("Choose a size (SMALL, MEDIUM, LARGE): ");
                    Size coffeeSize = Size.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Add extra shot? (y/n): ");
                    boolean extraShot = sc.nextLine().equals("y");
                    System.out.print("Add extra syrup? (y/n): ");
                    boolean extraSyrup = sc.nextLine().equals("y");
                    bevShop.processCoffeeOrder(coffeeName, coffeeSize, extraShot, extraSyrup);
                } 
                else if (drinkType == 3) {
                    System.out.print("Enter the name of the smoothie: ");
                    String smoothieName = sc.nextLine();
                    System.out.print("Choose a size (SMALL, MEDIUM, LARGE): ");
                    Size smoothieSize = Size.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Enter the number of fruits: ");
                    int numFruits = sc.nextInt();
                    sc.nextLine(); 
                    if (bevShop.isMaxFruit(numFruits)) {
                        System.out.println("You reached the maximum number of fruits allowed.");
                    } 
                    else {
                        System.out.print("Add protein? (y/n): ");
                        boolean addProtein = sc.nextLine().equals("y");
                        bevShop.processSmoothieOrder(smoothieName, smoothieSize, numFruits, addProtein);
                    }
                } 
                else {
                    System.out.println("Invalid drink type.");
                }
                System.out.println("The Total Price on the Order: " + bevShop.getCurrentOrder().calcOrderTotal());
            }
            System.out.println("Would you like to start a new order? (y/n)");
            String continueResponse = sc.nextLine();
            if (!continueResponse.equals("y")) {
                keepOrdering = false;
            }
               
        }
        System.out.println("Summary of all orders:");
        System.out.println(bevShop.toString());
	}
	
}
