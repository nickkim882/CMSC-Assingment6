/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class represents a beverage and each beverage is assinged a name, type, and size
 * Due: 12/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nicholas Kim
*/
public abstract class Beverage {
	
	private String name;
	private Type type;
	private Size size;
	private static final double PRICE = 2.0;
	private static final double SIZE_PRICE = 0.5;
	
	public Beverage(String name, Type type, Size size) {
		
		this.name = name;
		this.type = type;
		this.size = size;
		
	}
	
	public double addSizePrice() {
		
		if(size == Size.SMALL) {
			
			return PRICE;
			
		}
		else if(size == Size.MEDIUM) {
			
			return PRICE + SIZE_PRICE;
			
		}else {
			
			return PRICE + (2*SIZE_PRICE);
			
		}
		
	}
	
	public abstract double calcPrice();
	
	public String toString() {
		
		return name + " " + size;
		
	}
	
	public boolean equals(Object obj) {
		
		if(obj == null) {
			
			return false;
			
		}
		if(this == obj) {
			
			return true;
			
		}
		Beverage bev = (Beverage) obj;
		
		if(name.equals(bev.name) && type == bev.type && size == bev.size) {
			
			return true;
			
		}
		
		return false;
	}
	
	//setters 
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setType(Type type) {
		
		this.type = type;
		
	}
	
	public void setSize(Size size) {
		
		this.size = size;
		
	}
	
	//getters
	public String getName() {
		
		return name;
		
	}
	
	public Type getType() {
		
		return type;
		
	}
	
	public Size getSize() {
		
		return size;
		
	}
}
