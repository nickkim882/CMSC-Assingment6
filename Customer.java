/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class represents the customer that is trying to buy a beverage from this shop.
 * Due: 12/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nicholas Kim
*/
public class Customer {
	
	private String name;
	private int age;
	
	public Customer(String name, int age) {
		
		this.name = name; 
		this.age = age;
		
	}
	
	public Customer(Customer other) {
		
		this.name = other.name;
		this.age = other.age;
		
	}
	
	public String toString() {
		
		return name + " " + age;
		
	}
	
	//Setters
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setAge(int age) {
		
		this.age = age;
		
	}
	
	//Getters
	public String getName() {
		
		return name;
		
	}
	
	public int getAge() {
		
		return age;
		
	}
	
}
